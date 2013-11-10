package com.example.Toasti;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CallActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		
		LinearLayout animationTarget = (LinearLayout) this.findViewById(R.id.linear);

        animationTarget.startAnimation( 
        	    AnimationUtils.loadAnimation(this, R.anim.rotate_indefinitely) );
        
		new CountDownTimer(60000, 1000) {
			TextView mTextField = (TextView) findViewById(R.id.textView1);

		     public void onTick(long millisUntilFinished) {
		         mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
		     }

		     public void onFinish() {
		         mTextField.setText("done!");
		     }
		  }.start();
	}

	

}
