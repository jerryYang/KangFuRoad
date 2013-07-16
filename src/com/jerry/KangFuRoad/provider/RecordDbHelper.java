package com.jerry.KangFuRoad.provider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jerry.KangFuRoad.provider.Constants.DbConstants;
import com.jerry.KangFuRoad.provider.contract.RecordContract.RegularEntry;

public class RecordDbHelper extends SQLiteOpenHelper{
	// If you change the database schema, you must increment the database version.
   
    private static final String TEXT_TYPE = " TEXT";
    private static final String TEXT_NOT_NULL_TYPE = " TEXT NOT NULL";
    private static final String COMMA_SEP = ",";
    
    private static final String SQL_CREATE_REGULAR_CHECK =
        "CREATE TABLE " + RegularEntry.TABLE_NAME + " (" +
		RegularEntry._ID + " INTEGER PRIMARY KEY," +
		RegularEntry.COLUMN_NAME_DATE + TEXT_NOT_NULL_TYPE + COMMA_SEP +
		RegularEntry.COLUMN_NAME_DAN_BAN + TEXT_TYPE + COMMA_SEP +
        RegularEntry.COLUMN_NAME_QIAN_XUE + TEXT_TYPE + COMMA_SEP +
		RegularEntry.COLUMN_NAME_BI_ZHONG+ TEXT_TYPE + COMMA_SEP +
        RegularEntry.COLUMN_NAME_HONG_XI_BAO + TEXT_TYPE + COMMA_SEP +
        RegularEntry.COLUMN_NAME_PH + TEXT_TYPE +
        " )";

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + RegularEntry.TABLE_NAME;


	public RecordDbHelper(Context context) {
		super(context, DbConstants.DATABASE__NAME, null, DbConstants.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_REGULAR_CHECK);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_DELETE_ENTRIES);
		this.onCreate(db);
	}
	
	public void closerCursor(Cursor cursor){
		if(cursor != null){
			cursor.close();
		}
	}

}
