package com.jerry.KangFuRoad.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jerry.KangFuRoad.R;
import com.jerry.KangFuRoad.provider.Contract.TableContract.TableItem;

public class RecordAdapter extends ArrayAdapter<TableItem>{
	private int mResourceId;
	private final Context mContext;

	public RecordAdapter(Context context, int textViewResourceId, ArrayList<TableItem> items) {
		super(context, textViewResourceId, items);
		mResourceId = textViewResourceId;
		mContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TableItem item = getItem(position);
		LinearLayout layout = null;
		
		if(convertView == null || convertView.getTag() == null){
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = (LinearLayout) inflater.inflate(mResourceId, null);
			layout.setTag(layout);
		} else {
			layout = (LinearLayout) convertView.getTag();
		}
		
		TextView text = (TextView) layout.findViewById(R.id.item_key);
		text.setText(item.text);
		EditText edit = (EditText) layout.findViewById(R.id.item_value);
		edit.setHint(item.defaultValue);
		return layout;
	}
	
	public String getId(int position){
		TableItem item = getItem(position);
		String id = item.id;
		
		return id;
	}
}