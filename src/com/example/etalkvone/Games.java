package com.example.etalkvone;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Games extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_games);
		Button nextToHome;
		Button nextToAskForARoute;
		Button nextToOrderingInAResturant;
		Button nextToTakingACab;
		
			
		 nextToHome = (Button) findViewById(R.id.btnHome);
		 nextToHome.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
	            	Intent myIntent = new Intent(view.getContext(), Home.class);
	                startActivityForResult(myIntent, 0);
	            }
	        });
		 nextToAskForARoute = (Button) findViewById(R.id.btnSpellCheck);
		 nextToAskForARoute.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
	            	Intent myIntent = new Intent(view.getContext(), Spellcheck.class);
	                startActivityForResult(myIntent, 0);
	            }
	        });
		 nextToOrderingInAResturant = (Button) findViewById(R.id.btnSeekCorrectSentence);
		 nextToOrderingInAResturant.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
	            	Intent myIntent = new Intent(view.getContext(), Seekcorrectsentence.class);
	                startActivityForResult(myIntent, 0);
	            }
	        });
		 nextToTakingACab = (Button) findViewById(R.id.btnFindCorrectWord);
		 nextToTakingACab.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
	            	Intent myIntent = new Intent(view.getContext(), Findcorrectword.class);
	                startActivityForResult(myIntent, 0);
	            }
	        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.games, menu);
		return true;
	}

}
