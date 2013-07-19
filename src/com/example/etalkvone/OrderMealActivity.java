package com.example.etalkvone;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class OrderMealActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_meal);
		
		TextView tv =(TextView) findViewById(R.id.txtorderMeal);
		tv.setText(
				"Bob: What do you want for lunch?" +
				System.getProperty ("line.separator")+
				"به چاشت چه میخواهید؟ \n" +
				System.getProperty ("line.separator")+
				"John: What are my choices?" +
				System.getProperty ("line.separator")+
				"پسند من چه است؟ \n" +
				System.getProperty ("line.separator")+
				"Bob: I could make sandwiches." +
				System.getProperty ("line.separator")+
				"من ساندویچ آماده کرده میتوانم \n" +
				System.getProperty ("line.separator")+
				"John: What more?" +
				System.getProperty ("line.separator")+
				"دیگر چه؟ \n" +
				System.getProperty ("line.separator")+
				"Bob: I could make spaghetti" +
				System.getProperty ("line.separator")+
				".من ماکارونی آماده کرده میتوانم \n" +
				System.getProperty ("line.separator")+
				"John: Hmm, I don’t know" +
				System.getProperty ("line.separator")+
				"!امم، نمیدانم \n" +
				System.getProperty ("line.separator")+
				"Bob: Or, we could go to McDonalds." +
				System.getProperty ("line.separator")+
				" یا ما میتوانیم که به مک دونالد برویم \n" +
				System.getProperty ("line.separator")+
				"John: I’ll drive. " +
				System.getProperty ("line.separator")+
				"من رانندگی میکنم \n"+
				System.getProperty ("line.separator")
				 
				);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.order_meal, menu);
		return true;
	}

}