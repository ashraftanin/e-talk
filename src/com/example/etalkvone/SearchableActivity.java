package com.example.etalkvone;


import android.os.Bundle;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;



public class SearchableActivity extends Activity {


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchable);
		
		
		
		Button nextToHome = (Button) findViewById(R.id.btnHome);;
		
			
		nextToHome.setOnClickListener(new View.OnClickListener() {
	          public void onClick(View v) {
			
	        	  Intent intent = new Intent(getApplicationContext(), Home.class);
	        	  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	  intent.putExtra("EXIT", true);
	        	  startActivity(intent);

	          }   
	       });
		
		
					DatabaseTable db = new DatabaseTable(this);
		
					//pattern to match english word
					String pattern = "^[A-Za-z0-9. ]+$";
		
		
	
					Intent intent = getIntent();
					if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
					String query = intent.getStringExtra(SearchManager.QUERY);
	        
	        
	        
					TextView word = (TextView) findViewById(R.id.word);
					TextView meaning = (TextView) findViewById(R.id.def);
					TextView dari = (TextView) findViewById(R.id.textView1);

		
					
					//If user input is English
	        
					 if (query.matches(pattern)){
	        
						 Cursor cursor = db.getEnglishWord(query, null);
	        
						 if(cursor == null){
	        				word.setText(getString(R.string.no_result));
	        				meaning.setText("");
	        				dari.setText("");
						 }
	        
						 else{
	        	
	        				int iIndex =  cursor.getColumnIndexOrThrow(DatabaseTable.COL_ID);
	        				String id  = cursor.getString(iIndex);
	        					//System.out.print(id);
		       	
		       
	        				Cursor cursor1 = db.getDariWords(id, null);
	        						//process Cursor and display result

	        				int wIndex = cursor.getColumnIndexOrThrow(DatabaseTable.COL_WORD);
	        				int dIndex = cursor1.getColumnIndexOrThrow(DatabaseTable.COL_WORD);

		         

	        				word.setText(cursor.getString(wIndex));
	        				String[] str = new String[cursor1.getCount()];
	        				cursor1.moveToFirst();
	        				
	            
	        				for(int i=0;i<str.length;i++)
	        				{ 
	            		
	        					str[i] = cursor1.getString(dIndex);
	        					//System.out.println(uname);
	        					cursor1.moveToNext();
	                
	        				}
	          
	        				
	        				String all = "";
	            	
	        				for(int i=0;i<str.length;i++)
	        				{ 
	        					all += str[i];
	        					if(i != (str.length - 1))
	        						all += ", ";             
	        				}
	            	
		        
	        				
	        					meaning.setText(all);
	        					dari.setText("");
	        					//cursor1.close();
	        					
	        	
						 }
	       
					 }        
	       	
	        // If the input is Farsi
	       	
					 else{

						 Cursor cursor = db.getDariWord(query, null);
						 
	       		
						 if(cursor == null){
							 dari.setText(getString(R.string.no_result1));
							 meaning.setText("");
							 word.setText("");
						 }
	       			
						 else{
		        
							 int iIndex =  cursor.getColumnIndexOrThrow(DatabaseTable.COL_ID);
							 String id  = cursor.getString(iIndex);
							 //System.out.print(id);
		       			       
							 Cursor cursor1 = db.getEngWords(id, null);
							 //process Cursor and display results
		        
		
			       			//TextView word = (TextView) findViewById(R.id.word);
			       			//TextView meaning = (TextView) findViewById(R.id.def);
		
			       			int wIndex = cursor.getColumnIndexOrThrow(DatabaseTable.COL_WORD);
			       			int dIndex = cursor1.getColumnIndexOrThrow(DatabaseTable.COL_WORD);
		
				         
		
			       			dari.setText(cursor.getString(wIndex));
			       			meaning.setText(cursor1.getString(dIndex));
							 word.setText("");

		
			       			//cursor1.close();
			       		
						 }
						 	
						 	
					 
					 }
					 
			}
					 
	}
		     

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dictionary, menu);
		 // Get the SearchView and set the searchable configuration
	    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
	    SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
	    // Assumes current activity is the searchable activity
	    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
	    searchView.setIconifiedByDefault(false);
		
		
		return true;
	}
	
	

}
