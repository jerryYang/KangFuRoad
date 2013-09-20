package com.jerry.KangFuRoad.provider.Contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.provider.BaseColumns;
import android.util.Log;

import com.jerry.KangFuRoad.provider.Contract.RecordContract.RegularColumns;

public final class TableContract{
	public static ArrayList<String> tables = new ArrayList<String>();
	public static Map<String, ArrayList<TableItem>> tableMaps = new HashMap<String, ArrayList<TableItem>>();
	
	public TableContract(){}
	
	static {
		// add table and default values here
		tables.add(RegularColumns.TABLE_NAME);
		ArrayList<TableItem> items = new ArrayList<TableContract.TableItem>();
		items.add(new TableItem(RegularColumns.COLUMN_NAME_BI_ZHONG,"±ÈÖØ","1.005 - 1.030",
				true, 1.005, 1.030, ""));
		items.add(new TableItem(RegularColumns.COLUMN_NAME_DAN_BAN,"µ°°×","ÒõÐÔ"));
		items.add(new TableItem(RegularColumns.COLUMN_NAME_PH,"PHÖµ","5.0 £­ 7.0",
				true, 5.0, 7.0, ""));
		items.add(new TableItem(RegularColumns.COLUMN_NAME_HONG_XI_BAO,"ºìÏ¸°û","0 £­ 3",
				true, 0, 3, ""));
		items.add(new TableItem(RegularColumns.COLUMN_NAME_QIAN_XUE,"Ç±Ñª","ÒõÐÔ"));
		tableMaps.put(RegularColumns.TABLE_NAME, items);
	}
	
	public static class TableItem{
		public TableItem(){}
		
		public TableItem(String id, String text, String default_value){
			this.id = id;
			this.text = text;
			this.defaultValue = default_value;
			this.isRange = false;
			this.maxValue = 0;
			this.minValue = 0;
			this.unit = "";
		}
		
		public TableItem(String id, String text, String default_value,
				boolean isRange, double max_value, double min_value, String unit){
			this.id = id;
			this.text = text;
			this.defaultValue = default_value;
			this.isRange = isRange;
			this.maxValue = max_value;
			this.minValue = min_value;
			this.unit = unit;
		}
		
		public String id;
		public String text;
		public String defaultValue;
		public boolean isRange;
		public double maxValue;
		public double minValue;
		public String unit;
	}
	
	public static abstract class TableEntry implements BaseColumns {
		public static final String TABLE_NAME = "tabless";
		public static final String COLUMN_NAME_TABLE = "name_table";
        public static final String COLUMN_NAME_TEXT = "text";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_DEFAULT_VALUE = "default_value";
        public static final String COLUMN_NAME_IS_RANGE = "is_range";
        public static final String COLUMN_NAME_MAX_VALUE = "max_value";
        public static final String COLUMN_NAME_MIN_VALUE = "min_value";
        public static final String COLUMN_NAME_UNIT = "unit";
	}
	
	
}
