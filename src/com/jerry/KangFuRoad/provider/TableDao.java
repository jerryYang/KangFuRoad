package com.jerry.KangFuRoad.provider;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;

import com.jerry.KangFuRoad.provider.Contract.TableContract;
import com.jerry.KangFuRoad.provider.Contract.TableContract.TableItem;
import com.jerry.KangFuRoad.provider.model.Table;

public class TableDao extends RecordDbHelper{

	public TableDao(Context context) {
		super(context);
	}
	
	public Table getTableByName(String tableName){
		Table table = new Table();
		Cursor cursor = null;
		ArrayList<TableItem> items = new ArrayList<TableContract.TableItem>();
		
		table.setTable(tableName);	
		table.setItems(items);
		try{
			cursor = getWritableDatabase().query(TableContract.TableEntry.TABLE_NAME, null, 
					TableContract.TableEntry.COLUMN_NAME_TABLE + "=?", new String[]{tableName}, null, null, TableContract.TableEntry._ID + " ASC");
			if(cursor != null){
				while(cursor.moveToNext()){
					TableItem item = new TableItem();
					item.id = cursor.getString(cursor.getColumnIndex(TableContract.TableEntry.COLUMN_NAME_ID));
					item.text = cursor.getString(cursor.getColumnIndex(TableContract.TableEntry.COLUMN_NAME_TEXT));
					item.defaultValue = cursor.getString(cursor.getColumnIndex(TableContract.TableEntry.COLUMN_NAME_DEFAULT_VALUE));
					item.isRange = Boolean.valueOf(cursor.getString(cursor.getColumnIndex(TableContract.TableEntry.COLUMN_NAME_IS_RANGE)));
					item.maxValue = Double.valueOf(cursor.getString(cursor.getColumnIndex(TableContract.TableEntry.COLUMN_NAME_MAX_VALUE)));
					item.minValue = Double.valueOf(cursor.getString(cursor.getColumnIndex(TableContract.TableEntry.COLUMN_NAME_MIN_VALUE)));
					item.unit = cursor.getString(cursor.getColumnIndex(TableContract.TableEntry.COLUMN_NAME_UNIT));
					items.add(item);
				}
			}
		} finally {
			if(cursor != null){
				cursor.close();	
			}
		}
		
		return table;
	}

}
