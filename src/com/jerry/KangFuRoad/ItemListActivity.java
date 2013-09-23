package com.jerry.KangFuRoad;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jerry.KangFuRoad.provider.Contract.TableContract.TableItem;
import com.jerry.KangFuRoad.provider.model.Regular;

public class ItemListActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_list);
	}
	
	

	@Override
	protected void onResume() {
		loadList();

		super.onResume();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_item_list, menu);
		MenuItem item = menu.findItem(R.id.menu_item_list_new_item);
		item.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				navigateToNewItemActivity();
				return false;
			}
		});
		
		
		return true;
	}
	
	private void loadList(){
		ArrayList<Regular> regulars = Regular.getAllRegular(this);
		
        ListView list = (ListView) this.findViewById(R.id.item_list);
		TextView emptyView = (TextView) findViewById(R.id.item_list_empty);
		emptyView.setVisibility(View.VISIBLE);
		emptyView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				navigateToNewItemActivity();
				
			}
		});
	}

	
	private void navigateToNewItemActivity(){
		Intent intent= new Intent(this, NewItemActivity.class);
		startActivity(intent);
	}
	
	public static class RecordAdapter extends ArrayAdapter<Regular>{
		private int mResourceId;
		private final Context mContext;

		public RecordAdapter(Context context, int textViewResourceId, ArrayList<Regular> items) {
			super(context, textViewResourceId, items);
			mResourceId = textViewResourceId;
			mContext = context;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Regular item = getItem(position);
			LinearLayout layout = null;
			
			if(convertView == null || convertView.getTag() == null){
				LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				layout = (LinearLayout) inflater.inflate(mResourceId, null);
				layout.setTag(layout);
			} else {
				layout = (LinearLayout) convertView.getTag();
			}
			
			TextView text = (TextView) layout.findViewById(R.id.item_key);
		//	text.setText(item.text);
			EditText edit = (EditText) layout.findViewById(R.id.item_value);
		//	edit.setHint(item.defaultValue);
			return layout;
		}
	
	}
}
