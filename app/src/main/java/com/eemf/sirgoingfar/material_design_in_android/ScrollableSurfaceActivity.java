package com.eemf.sirgoingfar.material_design_in_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ScrollableSurfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_surface);

        /* Toolbar */
        ((android.support.v7.widget.Toolbar) findViewById(R.id.toolbar)).setTitle("SirGoingFar");
    }
}
