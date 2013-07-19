package com.example.etalkvone;


import android.app.SearchManager;

import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;



public class DatabaseTable {
	
	 

	    //The columns we'll include in English and Farsi tables.
	    public static final String COL_ID = BaseColumns._ID;
	    public static final String COL_WORD = SearchManager.SUGGEST_COLUMN_ICON_1;
	    //public static final String ENG_ID = "ENGID";
	    //public static final String DARI_ID = "DARIID";

	    
	 
	    

	   private final DatabaseOpenHelper mDatabaseOpenHelper;

	   public DatabaseTable(Context context) {
	        mDatabaseOpenHelper = new DatabaseOpenHelper(context);
	    }
	   

	    

	   /**
	    * 
	    * Returns a cursor over all English words that match the query.
	    * 
	    * @param query English word to search
	    * @param columns The column to include if null all column included.
	    * @return cursor over all words that match the query.
	    */
	    
	    public Cursor getEnglishWord(String query, String[] columns) {
	        String selection = COL_WORD + " MATCH ?";
	        String[] selectionArgs = new String[] {query+"*"};

	        return query(selection, selectionArgs, columns);
	    }
	    
	    /**
		    * 
		    * Returns a cursor over all Dari words that match the query(ID of the words).
		    * 
		    * @param query ID of the word to search
		    * @param columns The column to include if null all column included.
		    * @return cursor over all words that match the query.
		    */
	    
	    public Cursor getDariWords(String query, String[] columns) {
	        String selection = COL_ID + " MATCH ?";
	        String[] selectionArgs = new String[] {query+"*"};

	        return query1(selection, selectionArgs, columns);
	    }
	    
	    /**
	     * Performs a database query on English table.
	     * @param selection The selection clause
	     * @param selectionArgs Selection arguments for "?" components in the selection
	     * @param columns The columns to return
	     * @return A Cursor over all rows matching the query
	     */
	    

	    private Cursor query(String selection, String[] selectionArgs, String[] columns) {
	        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
	        builder.setTables(DatabaseOpenHelper.FTS_VIRTUAL_TABLE_ENG);
	        

	        Cursor cursor = builder.query(mDatabaseOpenHelper.getReadableDatabase(),
	                columns, selection, selectionArgs, null, null, null);

	        if (cursor == null) {
	            return null;
	        } else if (!cursor.moveToFirst()) {
	            cursor.close();
	            return null;
	        }
	        return cursor;
	    }
	    
	    /**
	     * Performs a database query on Dari table.
	     * @param selection The selection clause
	     * @param selectionArgs Selection arguments for "?" components in the selection
	     * @param columns The columns to return
	     * @return A Cursor over all rows matching the query
	     */
	    
	    private Cursor query1(String selection, String[] selectionArgs, String[] columns) {
	        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
	        builder.setTables(DatabaseOpenHelper.FTS_VIRTUAL_TABLE_DARI);
	        

	        Cursor cursor = builder.query(mDatabaseOpenHelper.getReadableDatabase(),
	                columns, selection, selectionArgs, null, null, null);

	        if (cursor == null) {
	            return null;
	        } else if (!cursor.moveToFirst()) {
	            cursor.close();
	            return null;
	        }
	        return cursor;
	    }
	    

	    /**
		    * 
		    * Returns a cursor over all Dari words that match the query.
		    * 
		    * @param query Dari word to search
		    * @param columns The column to include if null all column included.
		    * @return cursor over all words that match the query.
		    */
	    
	    public Cursor getDariWord(String query, String[] columns) {
	        String selection = COL_WORD + " MATCH ?";
	        String[] selectionArgs = new String[] {query+"*"};

	        return queryDari(selection, selectionArgs, columns);
	    }
	    
	    
	    /**
		    * 
		    * Returns a cursor over all English words that match the query(ID of English word).
		    * 
		    * @param query Eng word to search
		    * @param columns The column to include if null all column included.
		    * @return cursor over all words that match the query.
		    */
	    
	    public Cursor getEngWords(String query, String[] columns) {
	        String selection = COL_ID + " MATCH ?";
	        String[] selectionArgs = new String[] {query+"*"};

	        return queryEng(selection, selectionArgs, columns);
	    }
	    
	    /**
	     * Performs a database query on Dari table.
	     * @param selection The selection clause
	     * @param selectionArgs Selection arguments for "?" components in the selection
	     * @param columns The columns to return
	     * @return A Cursor over all rows matching the query
	     */

	    private Cursor queryDari(String selection, String[] selectionArgs, String[] columns) {
	        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
	        builder.setTables(DatabaseOpenHelper.FTS_VIRTUAL_TABLE_DARI);
	        

	        Cursor cursor = builder.query(mDatabaseOpenHelper.getReadableDatabase(),
	                columns, selection, selectionArgs, null, null, null);

	        if (cursor == null) {
	            return null;
	        } else if (!cursor.moveToFirst()) {
	            cursor.close();
	            return null;
	        }
	        return cursor;
	    }
	    
	    /**
	     * Performs a database query on Dari table.
	     * @param selection The selection clause
	     * @param selectionArgs Selection arguments for "?" components in the selection
	     * @param columns The columns to return
	     * @return A Cursor over all rows matching the query
	     */
	    
	    private Cursor queryEng(String selection, String[] selectionArgs, String[] columns) {
	        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
	        builder.setTables(DatabaseOpenHelper.FTS_VIRTUAL_TABLE_ENG);
	        

	        Cursor cursor = builder.query(mDatabaseOpenHelper.getReadableDatabase(),
	                columns, selection, selectionArgs, null, null, null);

	        if (cursor == null) {
	            return null;
	        } else if (!cursor.moveToFirst()) {
	            cursor.close();
	            return null;
	        }
	        return cursor;
	    }
	    
    
}
