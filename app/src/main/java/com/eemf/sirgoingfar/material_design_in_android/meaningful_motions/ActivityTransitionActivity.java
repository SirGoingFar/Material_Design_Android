package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.eemf.sirgoingfar.material_design_in_android.R;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION;
import static android.os.Build.VERSION_CODES;

public class ActivityTransitionActivity extends AppCompatActivity implements OnImageClick {

    private static final int SPAN_COUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        /* Mock Data */
        List<Image> data = new ArrayList<>();
        data.add(new Image("https://images.unsplash.com/photo-1503376780353-7e6692767b70?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"));
        data.add(new Image("https://images.unsplash.com/photo-1497131302160-8a042b60b5fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"));
        data.add(new Image("https://images.unsplash.com/photo-1498595664159-2df8dee7e63c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"));
        data.add(new Image("https://images.unsplash.com/photo-1504575797-2f83688754b8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"));
        data.add(new Image("https://images.unsplash.com/photo-1497131302160-8a042b60b5fa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"));
        data.add(new Image("https://images.unsplash.com/photo-1498595664159-2df8dee7e63c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"));
        data.add(new Image("https://images.unsplash.com/photo-1498595664159-2df8dee7e63c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"));

        RecyclerView rv = findViewById(R.id.rv_image);
        rv.setLayoutManager(new GridLayoutManager(this, SPAN_COUNT, GridLayoutManager.VERTICAL, false));
        rv.addItemDecoration(new GridSpacingItemDecoration(SPAN_COUNT, 0, true));
        rv.setAdapter(new ImageRecyclerViewAdapter(this, this, data));
    }

    @Override
    public void onImageClick(String imageUrl, View sharedView) {
        Bundle bundle;
        if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
            /* for Basic Transition */
//            bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();

            /* for Shared View Transition */
            bundle = ActivityOptions.makeSceneTransitionAnimation(
                    this, sharedView, sharedView.getTransitionName())
                    .toBundle();
            //This uses a default transition file called move.xml. See @style/ActivityTransition for more

            bundle.putString(ActivityTransition2Activity.KEY_IMAGE_URL, imageUrl);
            Intent intent = new Intent(this, ActivityTransition2Activity.class);
            intent.putExtra(ActivityTransition2Activity.KEY_ARG_BUNDLE, bundle);
            startActivity(intent, bundle);
        } else {
            bundle = new Bundle();
            bundle.putString(ActivityTransition2Activity.KEY_IMAGE_URL, imageUrl);
            Intent intent = new Intent(this, ActivityTransition2Activity.class);
            intent.putExtra(ActivityTransition2Activity.KEY_ARG_BUNDLE, bundle);
            startActivity(intent);
        }


    }

    private class ImageRecyclerViewAdapter extends RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageViewHolder> {
        private Context mContext;
        private OnImageClick listener;
        private List<Image> mData = new ArrayList<>();

        ImageRecyclerViewAdapter(Context context, OnImageClick clickListener, List<Image> data) {
            mContext = context;
            listener = clickListener;
            mData = data;
        }

        @NonNull
        @Override
        public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ImageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_image, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull final ImageViewHolder imageViewHolder, int i) {
            final Image currentImage = imageViewHolder.getCurrentItem();

            imageViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onImageClick(currentImage.getmImageUrl(), imageViewHolder.imageView);
                }
            });

            Glide.with(mContext)
                    .load(currentImage.getmImageUrl())
                    .into(imageViewHolder.imageView);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class ImageViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;

            public ImageViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.iv_image);
            }

            Image getCurrentItem() {
                return mData.get(getAdapterPosition());
            }
        }
    }

    public class Image {
        private String mImageUrl;

        public Image(String mImageUrl) {
            this.mImageUrl = mImageUrl;
        }

        public String getmImageUrl() {
            return mImageUrl;
        }
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
    }
}

interface OnImageClick {
    void onImageClick(String imageUrl, View sharedView);
}