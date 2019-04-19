package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.eemf.sirgoingfar.material_design_in_android.R;

public class ActivityTransition2Activity extends AppCompatActivity {

    public static final String KEY_IMAGE_URL = "key_image_url";
    public static final String KEY_ARG_BUNDLE = "key_arg_bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition2);

        Bundle activityBundle = getIntent().getBundleExtra(KEY_ARG_BUNDLE);

        if (activityBundle == null) {
            closeActivityWithToast("Bundle is NULL");
        }

        if (!activityBundle.containsKey(KEY_IMAGE_URL)) {
            closeActivityWithToast("No image URL");
        }

        String imageUrl = activityBundle.getString(KEY_IMAGE_URL);
        ImageView imageView = findViewById(R.id.iv_automobile_image);
        Glide.with(this).load(imageUrl).into(imageView);
    }

    private void closeActivityWithToast(String msg) {
        finish();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
