package com.eemf.sirgoingfar.material_design_in_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.eemf.sirgoingfar.material_design_in_android.meaningful_motions.ActivityTransitionActivity;
import com.eemf.sirgoingfar.material_design_in_android.meaningful_motions.BasicAnimationFirstActivity;
import com.eemf.sirgoingfar.material_design_in_android.meaningful_motions.BasicCoordinatedMotionActivity;
import com.eemf.sirgoingfar.material_design_in_android.meaningful_motions.BasicTransitionActivity;
import com.eemf.sirgoingfar.material_design_in_android.meaningful_motions.ObjectPropertyAnimationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Submit Button Action */
        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScrollableSurfaceActivity.class));
            }
        });

        /* Submit Button 2 Action */
        findViewById(R.id.btn_submit_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScrollableSurfaceTwoActivity.class));
            }
        });

        /* Submit Button 3 Action */
        findViewById(R.id.btn_submit_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BasicAnimationFirstActivity.class));
            }
        });

        /* Submit Button 4 Action */
        findViewById(R.id.btn_submit_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ObjectPropertyAnimationActivity.class));
            }
        });

         /* Submit Button 5 Action */
        findViewById(R.id.btn_submit_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SurfaceAndCircularRevealActivity.class));
            }
        });

        /* Submit Button 6 Action */
        findViewById(R.id.btn_submit_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BasicTransitionActivity.class));
            }
        });

        /* Submit Button 7 Action */
        findViewById(R.id.btn_submit_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BasicCoordinatedMotionActivity.class));
            }
        });

        /* Submit Button 8 Action */
        findViewById(R.id.btn_submit_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityTransitionActivity.class));
            }
        });

    }
}
