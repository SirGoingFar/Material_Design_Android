package com.eemf.sirgoingfar.material_design_in_android.meaningful_motions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.eemf.sirgoingfar.material_design_in_android.R;

public class InterpolatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        TextView label = findViewById(R.id.tv_label);
        label.setTranslationY(metrics.heightPixels);

        label.animate()
                .setInterpolator(new BounceInterpolator())        //there are numerous Interpolators
                .setDuration(300)                                 //300ms is the recommended
                .setStartDelay(300)
                .translationYBy(-metrics.heightPixels)
                .start();
    }
}
