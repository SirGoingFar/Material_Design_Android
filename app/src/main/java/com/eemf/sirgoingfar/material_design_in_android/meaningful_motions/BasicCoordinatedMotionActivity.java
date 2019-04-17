package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eemf.sirgoingfar.material_design_in_android.R;

public class BasicCoordinatedMotionActivity extends AppCompatActivity {

    boolean isSceneOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_coordinated_motion_scene_one);

        Button btn = findViewById(R.id.btn_transition);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                @LayoutRes int toScene;
                ViewGroup root = findViewById(R.id.root);

                if(isSceneOne)
                    toScene = R.layout.activity_basic_coordinated_motion_scene_two;
                else
                    toScene = R.layout.activity_basic_coordinated_motion_scene_one;

                //set scene switch flag
                isSceneOne = !isSceneOne;

                //transition coordinator
                TransitionManager.go(Scene.getSceneForLayout(root, toScene, BasicCoordinatedMotionActivity.this));
            }
        });
    }
}
