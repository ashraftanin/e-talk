package com.example.etalkvone;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Button nextToDailyconversation;
		Button nextToDictionary;
		Button nextToGames;
		Button nextToAboutUs;
		

			nextToDailyconversation = (Button) findViewById(R.id.btnDailyConversation);
			nextToDailyconversation.setOnClickListener(new View.OnClickListener() {
   				public void onClick(View view) {         
	            	Intent myIntent = new Intent(view.getContext(), Dailyconversation.class);
	                startActivityForResult(myIntent, 0);
   				}
	        });
			nextToDictionary = (Button) findViewById(R.id.btnDictionary);
			nextToDictionary.setOnClickListener(new View.OnClickListener() {
   				public void onClick(View view) {         
	            	Intent myIntent = new Intent(view.getContext(), Dictionary.class);
	                startActivityForResult(myIntent, 0);
   				}
	        });
			nextToGames = (Button) findViewById(R.id.btnGames);
			nextToGames.setOnClickListener(new View.OnClickListener() {
   				public void onClick(View view) {         
	            	Intent myIntent = new Intent(view.getContext(), Games.class);
	                startActivityForResult(myIntent, 0);
   				}
	        });
			nextToAboutUs = (Button) findViewById(R.id.btnAboutUs);
			nextToAboutUs.setOnClickListener(new View.OnClickListener() {
   				public void onClick(View view) {         
	            	Intent myIntent = new Intent(view.getContext(), Aboutus.class);
	                startActivityForResult(myIntent, 0);
   				}
	        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
