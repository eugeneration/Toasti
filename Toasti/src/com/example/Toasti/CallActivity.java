package com.example.Toasti;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class CallActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		
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
