package com.jerry.KangFuRoad.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jerry.KangFuRoad.provider.Constants.DbConstants;
import com.jerry.KangFuRoad.provider.Contract.TableContract;
import com.jerry.KangFuRoad.provider.Contract.RecordContract.RegularColumns;
import com.jerry.KangFuRoad.provider.Contract.TableContract.TableEntry;
import com.jerry.KangFuRoad.provider.Contract.TableContract.TableItem;

public class RecordDbHelper extends SQLiteOpenHelper{
	// If you change the database schema, you must increment the database version.
   
    private static final String TEXT_TYPE = " TEXT";
    private static final String TEXT_NOT_NULL_TYPE = " TEXT NOT NULL";
    private static final String COMMA_SEP = ",";
    
    private static final String SQL_CREATE_REGULAR_CHECK =
        "CREATE TABLE " + RegularColumns.TABLE_NAME + " (" +
		RegularColumns._ID + " INTEGER PRIMARY KEY," +
		RegularColumns.COLUMN_NAME_DATE + TEXT_NOT_NULL_TYPE + COMMA_SEP +
		RegularColumns.COLUMN_NAME_DAN_BAN + TEXT_TYPE + COMMA_SEP +
        RegularColumns.COLUMN_NAME_QIAN_XUE + TEXT_TYPE + COMMA_SEP +
		RegularColumns.COLUMN_NAME_BI_ZHONG+ TEXT_TYPE + COMMA_SEP +
        RegularColumns.COLUMN_NAME_HONG_XI_BAO + TEXT_TYPE + COMMA_SEP +
        RegularColumns.COLUMN_NAME_PH + TEXT_TYPE +
        " );";
    
    private static final String SQL_CREATE_TABLES =
            "CREATE TABLE " + TableEntry.TABLE_NAME + " (" +
            TableEntry._ID + " INTEGER PRIMARY KEY," +
            TableEntry.COLUMN_NAME_TABLE + TEXT_NOT_NULL_TYPE + COMMA_SEP +
            TableEntry.COLUMN_NAME_ID + TEXT_NOT_NULL_TYPE + COMMA_SEP +
            TableEntry.COLUMN_NAME_TEXT + TEXT_NOT_NULL_TYPE + COMMA_SEP + 
            TableEntry.COLUMN_NAME_DEFAULT_VALUE + TEXT_NOT_NULL_TYPE  + COMMA_SEP +
            TableEntry.COLUMN_NAME_IS_RANGE + TEXT_NOT_NULL_TYPE + COMMA_SEP +
            TableEntry.COLUMN_NAME_MAX_VALUE + TEXT_NOT_NULL_TYPE + COMMA_SEP +
            TableEntry.COLUMN_NAME_MIN_VALUE + TEXT_NOT_NULL_TYPE + COMMA_SEP +
            TableEntry.COLUMN_NAME_UNIT + TEXT_NOT_NULL_TYPE +
            " );";
        

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + RegularColumns.TABLE_NAME;


	public RecordDbHelper(Context context) {
		super(context, DbConstants.DATABASE__NAME, null, DbConstants.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// create tables and default values db
		db.execSQL(SQL_CREATE_TABLES);
		Log.d("create table ", SQL_CREATE_TABLES);
		
		// create regular check db
		db.execSQL(SQL_CREATE_REGULAR_CHECK);
		Log.d("create table ", SQL_CREATE_REGULAR_CHECK);
		
		// init talbes and default values
		initDB(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(SQL_DELETE_ENTRIES);
		Log.d("delete table ", SQL_DELETE_ENTRIES);
		
		this.onCreate(db);
	}
	
	private void initDB(SQLiteDatabase db){
		// to initialize tables and default values for table columns
		for(String table :TableContract.tables){
			for(TableItem item: TableContract.tableMaps.get(table)){
				ContentValues values = new ContentValues();
				values.put(TableContract.TableEntry.COLUMN_NAME_TABLE, table);
				values.put(TableContract.TableEntry.COLUMN_NAME_ID, item.id);
				values.put(TableContract.TableEntry.COLUMN_NAME_TEXT, item.text);
				values.put(TableContract.TableEntry.COLUMN_NAME_DEFAULT_VALUE, item.defaultValue);
				values.put(TableContract.TableEntry.COLUMN_NAME_IS_RANGE, String.valueOf(item.isRange));
				values.put(TableContract.TableEntry.COLUMN_NAME_MAX_VALUE, String.valueOf(item.maxValue));
				values.put(TableContract.TableEntry.COLUMN_NAME_MIN_VALUE, String.valueOf(item.minValue));
				values.put(TableContract.TableEntry.COLUMN_NAME_UNIT, item.unit);
				db.insertOrThrow(TableContract.TableEntry.TABLE_NAME, null, values);	
			}
			Log.d("dabatase initialization for table ", table);
		}
	}
	
	public void closerCursor(Cursor cursor){
		if(cursor != null){
			cursor.close();
		}
	}
}