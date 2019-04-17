package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.eemf.sirgoingfar.material_design_in_android.R;

public class BasicTransitionActivity extends AppCompatActivity {

    private boolean shouldReverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_transition);

        final Button btn_slideImage = findViewById(R.id.btn_slide_image);
        final ImageView iv_userImage = findViewById(R.id.iv_user_image);

        btn_slideImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                //The ViewGroup, whose initial state is to be captured
                ViewGroup root = findViewById(android.R.id.content);

                //the Sliding effect Actuator
                Slide slide = new Slide(Gravity.TOP);

                if (shouldReverse) {
                    //Doing this calls 'captureStartState()' - which saves the initial state of @root
                    TransitionManager.beginDelayedTransition(root, slide);

                    //after the initial state is captured, hide the image - since it shouldn't be visible in the endState to be captured
                    iv_userImage.setVisibility(View.VISIBLE);

                    //------> At this point, the 'captureEndState()' is called

                    //Post-operation set-up
                    shouldReverse = false;
                    btn_slideImage.setText("Slide OUT");

                } else {
                    //Doing this calls 'captureStartState()' - which saves the initial state of @root
                    TransitionManager.beginDelayedTransition(root, slide);

                    //after the initial state is captured, hide the image - since it shouldn't be visible in the endState to be captured
                    iv_userImage.setVisibility(View.GONE);

                    //------> At this point, the 'captureEndState()' is called

                    //Post-operation set-up
                    shouldReverse = true;
                    btn_slideImage.setText("Slide IN");

                }
            }
        });
    }
}
