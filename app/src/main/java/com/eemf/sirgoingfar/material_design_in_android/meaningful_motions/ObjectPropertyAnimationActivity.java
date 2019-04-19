package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.eemf.sirgoingfar.material_design_in_android.R;

public class ObjectPropertyAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_property_animation);

        //Animate the Button Background Color
        final Button btn = findViewById(R.id.btn_object);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofObject(
                        btn,                        //object whose property will be animated
                        "textColor",   //property to animate
                        new ArgbEvaluator(),
                        Color.RED,
                        Color.BLACK
                )
                        .setDuration(1000)
                        .start();
            }
        });
    }
}
