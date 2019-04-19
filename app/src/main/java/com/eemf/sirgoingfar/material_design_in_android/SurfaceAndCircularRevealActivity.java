package com.eemf.sirgoingfar.material_design_in_android;

import android.animation.Animator;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

public class SurfaceAndCircularRevealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_and_circular_reveal);

        /* Circular Reveal */
        final ViewGroup viewGroup = findViewById(R.id.fl_layout_1);
        viewGroup.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                ColorDrawable background = (ColorDrawable) viewGroup.getBackground();
                boolean isVeggies = background != null && background.getColor() == ContextCompat.getColor(SurfaceAndCircularRevealActivity.this, R.color.colorAccent);

                float radius = (float) Math.hypot(viewGroup.getWidth() / 2, viewGroup.getHeight() / 2);
                Animator anim;

                if (isVeggies) {
                    anim = ViewAnimationUtils.createCircularReveal(viewGroup, viewGroup.getWidth() / 2, viewGroup.getHeight() / 2, radius, 0);
                    viewGroup.setBackgroundColor(ContextCompat.getColor(SurfaceAndCircularRevealActivity.this, R.color.colorWhite));
                } else {
                    anim = ViewAnimationUtils.createCircularReveal(viewGroup, viewGroup.getWidth() / 2, viewGroup.getHeight() / 2, 0, radius);
                    viewGroup.setBackgroundColor(ContextCompat.getColor(SurfaceAndCircularRevealActivity.this, R.color.colorAccent));
                }
                anim.setDuration(500);
                anim.start();
            }
        });

    }
}
