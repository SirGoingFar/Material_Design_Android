package com.eemf.sirgoingfar.material_design_in_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionInflater;

public class ScrollableSurfaceTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_surface_two);

//        getSupportActionBar().hide();

        /* Toolbar */
        ((android.support.v7.widget.Toolbar) findViewById(R.id.toolbar)).setTitle("SirGoingFar");
    }
}
