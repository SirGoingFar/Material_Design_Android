package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.eemf.sirgoingfar.material_design_in_android.R;

public class BasicAnimationFirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_animation_first);

        final Button btn_animate = findViewById(R.id.btn_animate);

        /* METHOD 1 */
        //Initialize the AnimationSet object
        final AnimationSet animSet = new AnimationSet(BasicAnimationFirstActivity.this, null);

        //Animation to Fade out the current Activity
        animSet.addAnimation(new AlphaAnimation(1f, 0f));

        //Animation to translate the current Activity
        animSet.addAnimation(new TranslateAnimation(0, 0, 0, -100));

        //set AnimationSet duration
        animSet.setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));



    /* METHOD 2 */
        /*final Animation animSet = AnimationUtils.loadAnimation(this, R.anim.slideoutbutton); */


        //After the Animations in the AnimationSet are executed, open the next Activity
        animSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn_animate.setVisibility(View.GONE);
                startActivity(new Intent(BasicAnimationFirstActivity.this,
                        BasicAnimationSecondActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //start the Animation when the button is clicked
        btn_animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_animate.startAnimation(animSet);
            }
        });



        /*  METHOD 3 - for API_LEVEL >= Android 4 */
        /*btn_animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_animate.animate()
                        .alpha(0f)
                        .translationY(-100f)
                        .setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                btn_animate.setVisibility(View.GONE);
                                startActivity(new Intent(BasicAnimationFirstActivity.this,
                                        BasicAnimationSecondActivity.class));
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            }
                        });
            }
        });*/

    }
}
