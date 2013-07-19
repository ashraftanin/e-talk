package com.example.etalkvone;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class ShoppingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shopping);
		
		TextView tv = (TextView) findViewById(R.id.txtShopping);
		tv.setText(
				"Bob: Pardon me. Could you help me?" + 
				System.getProperty ("line.separator")+
				"ببخشید، برای من کمک کرده میتوانید؟ \n" +
				System.getProperty ("line.separator")+
				"John: Of course. How can I help you?"+
				System.getProperty ("line.separator")+
				"البته، به چه کمک شما ضرورت دارید؟ \n"+
				System.getProperty ("line.separator")+
				"Bob: I am looking for a jacket." +
				System.getProperty ("line.separator")+
				"من میخواهم که یک جاکت بگیرم \n"+
				System.getProperty ("line.separator")+
				"John: What size do you wear?" +
				System.getProperty ("line.separator")+
				"کدام اندازه را شما استفاده میکنید؟ \n"+
				System.getProperty ("line.separator")+
				"Bob: Medium, I think." +
				System.getProperty ("line.separator")+
				"متوسط، فکر میکنم \n"+
				System.getProperty ("line.separator")+
				"John: How do you like this one?" +
				System.getProperty ("line.separator")+
				"چطور این را میپسندید؟ \n"+
				System.getProperty ("line.separator")+
				"Bob: It's pretty. Can I try it on? " +
				System.getProperty ("line.separator")+
				" بسیار زیباست، پوشیده/امتحان کرده میتوانم؟ \n"+
				System.getProperty ("line.separator")+
				"John: You can try it on in the fitting room over there."+
				System.getProperty ("line.separator")+
				"در انجا اطاق امتحان است شما پوشیده میتوانید \n"+
				System.getProperty ("line.separator")
				);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.takingacab, menu);
		return true;
	}

}