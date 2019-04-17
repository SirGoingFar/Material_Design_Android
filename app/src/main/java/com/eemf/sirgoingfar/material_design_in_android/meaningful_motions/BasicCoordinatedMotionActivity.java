package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eemf.sirgoingfar.material_design_in_android.R;

public class BasicCoordinatedMotionActivity extends AppCompatActivity implements View.OnClickListener {

    boolean isSceneTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_coordinated_motion_scene_one);

        /*Button btn_1  = findViewById(R.id.btn_transition_1);
        if(btn_1 != null)
            btn_1.setOnClickListener(this);

        Button btn_2  = findViewById(R.id.btn_transition_2);
        if(btn_2 != null)
            btn_2.setOnClickListener(this);*/

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {

        @LayoutRes int toScene;
        ViewGroup root = findViewById(R.id.root);

        switch (v.getId()) {
            case R.id.btn_transition_1:
            case R.id.btn_transition_2:
                if (isSceneTwo)
                    toScene = R.layout.activity_basic_coordinated_motion_scene_one;
                else
                    toScene = R.layout.activity_basic_coordinated_motion_scene_two;

                //set scene switch flag
                isSceneTwo = !isSceneTwo;

                //transition coordinator
                TransitionManager.go(Scene.getSceneForLayout(root, toScene, BasicCoordinatedMotionActivity.this));

                //Optional ---> Transition Manager uses the Default transition effect - Fading
                TransitionInflater.from(BasicCoordinatedMotionActivity.this).inflateTransition(R.transition.default_to_info);
                break;
        }
    }
}
