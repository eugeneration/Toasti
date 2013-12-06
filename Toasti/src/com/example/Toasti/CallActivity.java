package com.example.Toasti;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

public class CallActivity extends Activity{

	private Context mContext;
	private VideoView vd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		 
		vd = (VideoView) findViewById(R.id.videoView);
		vd.setMediaController(null);
		Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"+R.drawable.plop2);
	    MediaController mc = new MediaController(this);
	    
	    vd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
	        @Override
	        public void onCompletion(MediaPlayer vmp) {
	            vd.setVisibility(View.INVISIBLE);
	            
	            TextView text = (TextView) findViewById(R.id.textView1);
	            text.setVisibility(View.VISIBLE);
	            
	            ImageButton button = (ImageButton) findViewById(R.id.imageButton1);
	            button.setVisibility(View.VISIBLE);
	            
	            ImageView image = (ImageView) findViewById(R.id.imageView1);
	            image.setVisibility(View.VISIBLE);
	            
	            startFalling();
	        }
	    });  
	    
	    vd.setMediaController(mc);
	    vd.requestFocus();
	    vd.setVideoURI(uri);
	    vd.start();	
        
	}
	
	private void startFalling() {
		new CountDownTimer(20000, 1000) {	
			
			TextView mTextField = (TextView) findViewById(R.id.textView1);

		     public void onTick(long millisUntilFinished) {
		    	 LinearLayout animationTarget = (LinearLayout) findViewById(R.id.linear);
		         animationTarget.startAnimation( 
		         	    AnimationUtils.loadAnimation(mContext, R.anim.rotate_indefinitely) );
		    	 
		    	 
		         mTextField.setText("Seconds remaining: " + millisUntilFinished / 1000);
		         if(millisUntilFinished/1000 < 2) {
		        	 ImageView animationTarget2 = (ImageView) findViewById(R.id.imageView2);
		        	 animationTarget2.setVisibility(View.INVISIBLE);
		         }
		         else if((millisUntilFinished/1000) %2 == 0) {
		             int x = (int) (Math.random()*900 );
		        	 ImageView animationTarget2 = (ImageView) findViewById(R.id.imageView2);
		             RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)animationTarget2.getLayoutParams();
		             Log.v("print", "" +par.leftMargin);
		             par.leftMargin = x;

		             animationTarget2.setLayoutParams(par);
		             animationTarget2.startAnimation( 
		             	AnimationUtils.loadAnimation(mContext, R.anim.translate_up) );
		         }
		         if((millisUntilFinished/1000) == .7) {
		             
		             animationTarget.startAnimation( 
		             AnimationUtils.loadAnimation(mContext, R.anim.translate) );
		         }
		     }
		     
		     public void onFinish() {
		    	 ImageView image = (ImageView) findViewById(R.id.imageView1);
		            image.setVisibility(View.INVISIBLE);
		         

		            TextView text = (TextView) findViewById(R.id.textView1);
		            text.setVisibility(View.INVISIBLE);
		            
		            ImageButton button = (ImageButton) findViewById(R.id.imageButton1);
		            button.setVisibility(View.INVISIBLE);
		            
		         mTextField.setText("Done!");
		         startNewVideo();
		     }
		  }.start();
	}
	
	private void startNewVideo() {
		vd.setVisibility(View.VISIBLE);
		
		vd.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
	        @Override
	        public void onCompletion(MediaPlayer vmp) {
	            vd.setVisibility(View.INVISIBLE);
	            finish();
	        }
	    });  
		
		Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"+R.drawable.kachunk2);
	    vd.setVideoURI(uri);
	    vd.setMediaController(null);
	    vd.start();	
	}

	public void hangup(View view) {
		finish();
	}
	

}
