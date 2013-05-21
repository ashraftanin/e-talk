package com.example.etalkvone;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Dailyconversation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dailyconversation);
		Button nextToHome;
		Button nextToAskForARoute;
		Button nextToOrderingInAResturant;
		Button nextToTakingACab;
		
			
		 nextToHome = (Button) findViewById(R.id.btnHome);
		 nextToHome.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
	                Intent intent = new Intent();
	                setResult(RESULT_OK, intent);
	                finish();
	            }
	        });
		 nextToAskForARoute = (Button) findViewById(R.id.btnAskingForARoute);
		 nextToAskForARoute.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
	                Intent intent = new Intent();
	                setResult(RESULT_OK, intent);
	                finish();
	            }
	        });
		 nextToOrderingInAResturant = (Button) findViewById(R.id.btnOrderingInAResturant);
		 nextToOrderingInAResturant.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
	                Intent intent = new Intent();
	                setResult(RESULT_OK, intent);
	                finish();
	            }
	        });
		 nextToTakingACab = (Button) findViewById(R.id.btnTakingACab);
		 nextToTakingACab.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
	                Intent intent = new Intent();
	                setResult(RESULT_OK, intent);
	                finish();
	            }
	        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dailyconversation, menu);
		return true;
	}

}
