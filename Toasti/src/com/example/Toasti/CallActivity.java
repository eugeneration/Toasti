package com.example.Toasti;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CallActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		
		LinearLayout animationTarget = (LinearLayout) this.findViewById(R.id.linear);
        animationTarget.startAnimation( 
        	    AnimationUtils.loadAnimation(this, R.anim.rotate_indefinitely) );
        
        final Context mContext = (Context) this;
		new CountDownTimer(60000, 1000) {
			TextView mTextField = (TextView) findViewById(R.id.textView1);

		     public void onTick(long millisUntilFinished) {
		         mTextField.setText("Seconds remaining: " + millisUntilFinished / 1000);
		         if((millisUntilFinished/1000) %2 == 0) {
		             int x = (int) (Math.random()*900 );
		        	 ImageView animationTarget2 = (ImageView) findViewById(R.id.imageView2);
		             RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)animationTarget2.getLayoutParams();
		             Log.v("print", "" +par.leftMargin);
		             par.leftMargin = x;

		             animationTarget2.setLayoutParams(par);
		             animationTarget2.startAnimation( 
		             	AnimationUtils.loadAnimation(mContext, R.anim.translate_up) );
		         }
		     }
		     
		     public void onFinish() {
		         mTextField.setText("done!");
		     }
		  }.start();
	}

	

}
