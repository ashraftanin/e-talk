package com.example.etalkvone;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Takingacab extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_takingacab);
		Button nextToHome;
		
		
		nextToHome = (Button) findViewById(R.id.btnHome);
		nextToHome.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {         
            	Intent myIntent = new Intent(view.getContext(), Home.class);
                startActivityForResult(myIntent, 0);
				}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.takingacab, menu);
		return true;
	}

}
