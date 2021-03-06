package com.jerry.KangFuRoad.provider.Contract;

import android.provider.BaseColumns;

public final class RecordContract{
	public RecordContract(){}
	
	public static abstract class RegularColumns implements BaseColumns {
		public static final String TABLE_NAME = "regular";
		public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_BI_ZHONG = "bi_zhong";
        public static final String COLUMN_NAME_DAN_BAN = "dan_bai";
        public static final String COLUMN_NAME_QIAN_XUE = "qian_xue";
        public static final String COLUMN_NAME_HONG_XI_BAO = "hong_xi_bao";
        public static final String COLUMN_NAME_PH = "ph";
	}
	
	public static abstract class TweentyFourHoursColumns implements BaseColumns {
		public static final String TABLE_NAME = "tweentyFour";
		public static final String COLUMN_NAME_ENTRY_ID = "entryid";
		public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_VALUE = "value";

	}
	
	public static abstract class BlookColumns implements BaseColumns {
		public static final String TABLE_NAME = "blood";
		public static final String COLUMN_NAME_ENTRY_ID = "entryid";
		public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_VALUE = "value";

	}
}
