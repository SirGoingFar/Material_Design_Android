package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import com.eemf.sirgoingfar.material_design_in_android.R;

public class InstructiveMotionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructive_motion);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();

        final ScrollView nsv = findViewById(R.id.sv_reader);
        final int startScrollPos = getResources().getDimensionPixelSize(R.dimen.init_scroll_up_distance);
        final int endScrollPos = getResources().getDimensionPixelSize(R.dimen.init_scroll_down_distance);

        //delay for 0.5s
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                //move the NestedScrollView up
                ObjectAnimator.ofInt(
                        nsv,
                        "scrollY",
                        startScrollPos)
                        .setDuration(300)
                        .start();

                //delay for 1.5s
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //move the NestedScrollView down
                        ObjectAnimator.ofInt(
                                nsv,
                                "scrollY",
                                endScrollPos)
                                .setDuration(300)
                                .start();
                    }
                }, 1500);
            }
        }, 500);
    }
}
