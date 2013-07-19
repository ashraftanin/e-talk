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
		 	Button btn_shopping = (Button) findViewById(R.id.btnShopping);
			Button btn_orderMeal = (Button) findViewById(R.id.btn_orderMeal);
			Button btn_intro = (Button) findViewById(R.id.btn_intro);

				// open shopping activity
				btn_shopping.setOnClickListener(new View.OnClickListener() {
			          public void onClick(View v) {
					
			        	  Intent i = new Intent(Dailyconversation.this,ShoppingActivity.class);
					
						startActivity(i);
			          }   
			       });
			
				// open orederMeal activity
			  btn_orderMeal.setOnClickListener(new View.OnClickListener() {
		          public void onClick(View v) {
				
				Intent i = new Intent(Dailyconversation.this,OrderMealActivity.class);
				
					startActivity(i);
		          }   
		       });
			  
			  
			// open Introduction activity
			  btn_intro.setOnClickListener(new View.OnClickListener() {
		          public void onClick(View v) {
				
		        	  Intent i = new Intent(Dailyconversation.this,IntroductionActivity.class);
				
					startActivity(i);
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
