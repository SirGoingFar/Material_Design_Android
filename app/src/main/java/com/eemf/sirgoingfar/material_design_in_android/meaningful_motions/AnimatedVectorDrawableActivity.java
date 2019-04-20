package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.eemf.sirgoingfar.material_design_in_android.R;

public class AnimatedVectorDrawableActivity extends AppCompatActivity {

    private boolean isTickCross;
    private AnimatedVectorDrawable crossToTick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_vector_drawable);

        /*crossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_tick);

        ImageView imageView = findViewById(R.id.iv_vector_drawable);
        imageView.setImageDrawable(crossToTick);*/


    }

    public void changeDrawable(View view) {
       /* isTickCross = !isTickCross;

        crossToTick.start();*/
    }
}
