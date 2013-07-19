package com.example.etalkvone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
	
	 private static final String TAG = "DatabaseTable";

	
	 //The columns we'll include in English and Farsi tables.
    public static final String COL_ID = BaseColumns._ID;
    public static final String COL_WORD = SearchManager.SUGGEST_COLUMN_ICON_1;
    //public static final String ENG_ID = "ENGID";
    //public static final String DARI_ID = "DARIID";

    
    //Database and Tables name.
    private static final String DATABASE_NAME = "EngtoDarione";
    public static final String FTS_VIRTUAL_TABLE_ENG = "Eng_words";
    public static final String FTS_VIRTUAL_TABLE_DARI = "Farsi_words";
    //private static final String FTS_VIRTUAL_TABLE_REL = "Relations";
    

    private static final int DATABASE_VERSION = 2;
    private final Context mHelperContext;
    private SQLiteDatabase mDatabase;
    int idGenerator = 0;
    //int idGenerator_DA = 0;
    
    

    private static final String FTS_TABLE_CREATE_ENG =
          "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE_ENG +
          " USING fts3 (" +
          COL_ID + ", " +
          COL_WORD + ")";

    private static final String FTS_TABLE_CREATE_DARI =
      "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE_DARI +
      " USING fts3 (" +
      COL_ID + ", " +
      COL_WORD + ")";


    DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mHelperContext = context;
    }


	@Override
    public void onCreate(SQLiteDatabase db) {
        mDatabase = db;
        mDatabase.execSQL(FTS_TABLE_CREATE_ENG);
        mDatabase.execSQL(FTS_TABLE_CREATE_DARI);
        //mDatabase.execSQL(FTS_TABLE_CREATE_REL);
        loadDictionary();
        
    }
    
    
    /**
     * start the thread to load database tables.
     */
    
    private void loadDictionary() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    loadWords();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private void loadWords() throws IOException {
	    final Resources resources = mHelperContext.getResources();
	    InputStream inputStream = resources.openRawResource(R.raw.words);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

	    try {
      	 String line;
      	 	while ((line = reader.readLine()) != null) {
            String[] strings = TextUtils.split(line, ":");
            if (strings.length < 2) continue;
            
    		String[] dariMeanings = strings[1].split("،");
    		String[] fullArray = new String[15];
    		
    		for(int j=0; j< (dariMeanings.length) + 1; j++){
    			if(j == 0)
    				fullArray[j] = strings[j].trim();
    			else if(j>=10) 
    				continue;
    			else
    				fullArray[j] = dariMeanings[j-1].trim();
    		}
    		
  			insertIntoDatabase(fullArray);
            
        }
    } finally {
        reader.close();
    }
  }

  /**
  * add words in database
  * @param fullArray array contains English word with all Farsi translations
  */

    private void insertIntoDatabase(String[] fullArray) {
  	// TODO Auto-generated method stub
  	
    	for(int i =0; i < fullArray.length && (fullArray[i] !=null) ; i++){
    		if(i==0){
    			long engID = addEngWord(idGenerator, fullArray[i]);
    			idGenerator++;

  			if (engID < 0) {
                Log.e(TAG, "unable to add word: " + fullArray[i].trim());
            }
  		}
  		else{
  			addDariWord((idGenerator-1), fullArray[i]);
  			//addRelations(idGenerator, idGenerator);
  			
  		}
  		
  	}
  	
  }


  /**
  * add word into the English table
  * @param id
  * @param word
  * @return 
  */

    public long addEngWord(int id, String word) {
	    ContentValues initialValues = new ContentValues();
	    initialValues.put(DatabaseTable.COL_ID, id);
	    initialValues.put(DatabaseTable.COL_WORD, word);

	    return mDatabase.insert(FTS_VIRTUAL_TABLE_ENG, null, initialValues);
  }


	  /**
	  * add word into the Farsi table
	  * @param id
	  * @param word
	  * @return 
	  */

	  public long addDariWord(int id, String word) {
	    ContentValues initialValues = new ContentValues();
	    initialValues.put(COL_ID, id);
	    initialValues.put(COL_WORD, word);
	
	    return mDatabase.insert(FTS_VIRTUAL_TABLE_DARI, null, initialValues);
	  }


	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
	  }
	  
}