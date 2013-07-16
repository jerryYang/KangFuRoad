package com.jerry.KangFuRoad.provider;

import android.content.Context;

import com.jerry.KangFuRoad.provider.contract.RecordContract.RegularEntry;

public class RegularCheckDao extends RecordDbHelper{
	
	public static String[] REGULAR_CHECK_ALL_COLUMN = new String[]{
		RegularEntry._ID,
		RegularEntry.COLUMN_NAME_DATE,
		RegularEntry.COLUMN_NAME_BI_ZHONG,
		RegularEntry.COLUMN_NAME_DAN_BAN,
		RegularEntry.COLUMN_NAME_HONG_XI_BAO,
		RegularEntry.COLUMN_NAME_PH,
		RegularEntry.COLUMN_NAME_QIAN_XUE
	};

	public RegularCheckDao(Context context) {
		super(context);
	}

}
