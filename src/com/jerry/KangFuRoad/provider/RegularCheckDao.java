package com.jerry.KangFuRoad.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.jerry.KangFuRoad.provider.Contract.RecordContract;
import com.jerry.KangFuRoad.provider.Contract.RecordContract.RegularColumns;
import com.jerry.KangFuRoad.provider.model.Regular;

public class RegularCheckDao extends RecordDbHelper{
	
	public static String[] REGULAR_CHECK_ALL_COLUMN = new String[]{
		RegularColumns._ID,
		RegularColumns.COLUMN_NAME_DATE,
		RegularColumns.COLUMN_NAME_BI_ZHONG,
		RegularColumns.COLUMN_NAME_DAN_BAN,
		RegularColumns.COLUMN_NAME_HONG_XI_BAO,
		RegularColumns.COLUMN_NAME_PH,
		RegularColumns.COLUMN_NAME_QIAN_XUE
	};

	public RegularCheckDao(Context context) {
		super(context);
	}
	
	public void save(Map<String, String> regularMap){
		ContentValues values = new ContentValues();

		for(Map.Entry<String, String> entry: regularMap.entrySet()){
			String id = entry.getKey();
			String value = entry.getValue();
			values.put(id, value);
		}
		getWritableDatabase().insertOrThrow(RecordContract.RegularColumns.TABLE_NAME,
				null, values);
	}
	
	public void save(Regular regular){
		ContentValues values = new ContentValues();
		values.put(RegularColumns.COLUMN_NAME_BI_ZHONG, regular.getBiZhong());
		values.put(RegularColumns.COLUMN_NAME_DAN_BAN, regular.getDanBai());
		values.put(RegularColumns.COLUMN_NAME_DATE, regular.getDate());
		values.put(RegularColumns.COLUMN_NAME_HONG_XI_BAO, regular.getHongXiBao());
		values.put(RegularColumns.COLUMN_NAME_PH, regular.getPh());
		values.put(RegularColumns.COLUMN_NAME_QIAN_XUE, regular.getQianXue());
		getWritableDatabase().insertOrThrow(RecordContract.RegularColumns.TABLE_NAME,
				null, values);
		
	}
	
	public Regular getRegularById(String id){
		Regular regular = new Regular();
		Cursor cursor = null;
		
		try{
			cursor = getWritableDatabase().query(RecordContract.RegularColumns.TABLE_NAME, null, 
					RecordContract.RegularColumns._ID + "=?", new String[]{id}, null , null, null, "1");
			if(cursor != null){
				cursor.moveToFirst();
				
				regular.setBiZhong(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_BI_ZHONG)));
				regular.setDanBai(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_DAN_BAN)));
				regular.setDate(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_DATE)));
				regular.setHongXiBao(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_HONG_XI_BAO)));
				regular.setPh(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_PH)));
				regular.setQianXue(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_QIAN_XUE)));
				
			}
		} finally {
			if(cursor != null){
				cursor.close();	
			}
		}
		
		return regular;
	}
	
	public ArrayList<Regular> getAllRegular(){
		ArrayList<Regular> regulars = new ArrayList<Regular>();
		Cursor cursor = null;
		
		try{
			cursor = getWritableDatabase().query(RecordContract.RegularColumns.TABLE_NAME, null, 
					null, null, null , null, null);
			if(cursor != null){
				while(cursor.moveToNext()){
					Regular regular = new Regular();
					regular.setBiZhong(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_BI_ZHONG)));
					regular.setDanBai(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_DAN_BAN)));
					regular.setDate(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_DATE)));
					regular.setHongXiBao(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_HONG_XI_BAO)));
					regular.setPh(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_PH)));
					regular.setQianXue(cursor.getString(cursor.getColumnIndex(RecordContract.RegularColumns.COLUMN_NAME_QIAN_XUE)));
					regulars.add(regular);
				}
			}
		} finally {
			if(cursor != null){
				cursor.close();	
			}
		}
		
		return regulars;
	}
	
}
