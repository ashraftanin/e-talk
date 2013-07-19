package com.example.etalkvone;


import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class IntroductionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introduction);
		
		ImageButton nextToHome;
		
		TextView tv = (TextView) findViewById(R.id.txtIntro);
		tv.setText(
				"Bob: What’s your name?" +
				System.getProperty ("line.separator")+
				"اسم شما چیست\n" 
				
				);
		
		 nextToHome = (ImageButton) findViewById(R.id.aud1);
		 nextToHome.setOnClickListener(new View.OnClickListener() {
		public void onClick(View view) { 

			MediaPlayer mPlayer = MediaPlayer.create(getBaseContext(),R.raw.file1);
			mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			try {
			mPlayer.prepare();
			} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			}
			mPlayer.start(); 
			}
		
		 });
		 
		 TextView tv1 = (TextView) findViewById(R.id.txtIntro1);
			tv1.setText(
					"John: My name is John. What’s yours?" +
							System.getProperty ("line.separator")+
							"اسم من جان است. و از شما \n" 
					
					);
			
			 nextToHome = (ImageButton) findViewById(R.id.aud2);
			 nextToHome.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) { 

				MediaPlayer mPlayer = MediaPlayer.create(getBaseContext(),R.raw.file2);
				mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
				try {
				mPlayer.prepare();
				} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				}
				mPlayer.start(); 
				}
			
			 });
			 
			 
			 TextView tv2 = (TextView) findViewById(R.id.txtIntro2);
				tv2.setText(
						"Bob: Mine is Bob" +
								System.getProperty ("line.separator")+
								"من باب استم \n" 
						
						);
				
				 nextToHome = (ImageButton) findViewById(R.id.aud3);
				 nextToHome.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) { 

					MediaPlayer mPlayer = MediaPlayer.create(getBaseContext(),R.raw.file3);
					mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
					try {
					mPlayer.prepare();
					} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					}
					mPlayer.start(); 
					}
				
				 });
				 
				 
				 TextView tv3 = (TextView) findViewById(R.id.txtIntro3);
					tv3.setText(
							"John: Where do you live?" +
									System.getProperty ("line.separator")+
									"کجا زندگی میکنید \n" 
							
							);
					
					TextView tv4 = (TextView) findViewById(R.id.txtIntro4);
					tv4.setText(
							"Bob: I live in Afghanistan, and you?" +
									System.getProperty ("line.separator")+
									"من درافغانستان زندگی میکنم، و شما؟ \n" 
							
							);
					
					TextView tv5 = (TextView) findViewById(R.id.txtIntro5);
					tv5.setText(
							"John: I live in Germany?" +
									System.getProperty ("line.separator")+
									"من در جرمنی زندگی میکنم؟ \n"
							
							);
					
					TextView tv6 = (TextView) findViewById(R.id.txtIntro6);
					tv6.setText(
							"Bob: It’s nice to meet you." +
									System.getProperty ("line.separator")+
									"از ملاقات تان خرسند شدم \n"
							);
					
					
					TextView tv7 = (TextView) findViewById(R.id.txtIntro7);
					tv7.setText(
							"John: It’s nice to meet you too." +
									System.getProperty ("line.separator")+
									" همچنان از ملاقات تان خرسندم \n"
							
							);
					
					
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.introduction, menu);
		return true;
	}

}
