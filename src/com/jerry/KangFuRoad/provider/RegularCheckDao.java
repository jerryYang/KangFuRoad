package com.jerry.KangFuRoad.provider;

import android.content.Context;

import com.jerry.KangFuRoad.provider.Contract.RecordContract.RegularColumns;

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
	
	
}
