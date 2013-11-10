package com.example.Toasti;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.Toasti.ui.ContactsListActivity;

public class FullscreenActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 1200;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
    	ActionBar actionBar = (ActionBar) getActionBar();
        actionBar.hide();
        super.onCreate(icicle);
        setContentView(R.layout.activity_fullscreen);
        

        /* New Handler to start the Menu-Activity 
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(FullscreenActivity.this, ContactsListActivity.class);
                FullscreenActivity.this.startActivity(mainIntent);
                FullscreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}