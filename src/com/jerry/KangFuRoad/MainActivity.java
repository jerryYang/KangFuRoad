package com.jerry.KangFuRoad;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jerry.KangFuRoad.provider.Contract.RecordContract.RegularColumns;
import com.jerry.KangFuRoad.provider.Contract.TableContract.TableItem;
import com.jerry.KangFuRoad.provider.model.Table;

public class MainActivity extends Activity {

	private TextView text = null;  
    private Button button = null;  
    private int mYear;  
    private int mMonth;  
    private int mDay;  
    static final int DATE_DIALOG_ID = 0;  
    /** Called when the activity is first created. */  
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView)findViewById(R.id.new_record_date);  
		text.setOnClickListener(new OnClickListener() {  
			@Override  
            public void onClick(View v) {  
            	showDatePickerDialog(); 
            }  
        });  
        final Calendar currentDate = Calendar.getInstance();  
        mYear = currentDate.get(Calendar.YEAR);  
        mMonth = currentDate.get(Calendar.MONTH);  
        mDay = currentDate.get(Calendar.DAY_OF_MONTH);  
        text.setText(new StringBuilder()  
                    .append(mYear).append("年")  
                    .append(mMonth + 1).append("月")
                    .append(mDay).append("日"));  
        
        Table table = Table.getTableByName(RegularColumns.TABLE_NAME, this);
        ListView list = (ListView) this.findViewById(R.id.new_items_container);
        list.setAdapter(new RecordAdapter(this, R.layout.item, table.getItems()));
        
        ImageView imageView = (ImageView) findViewById(R.id.attach_Image);
        imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
        
	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListener =new OnDateSetListener() {  
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {  
            mYear = year;  
            mMonth = monthOfYear;  
            mDay = dayOfMonth;  
            text.setText(new StringBuilder()  
                        .append(mYear).append("年")  
                        .append(mMonth + 1).append("月")
                        .append(mDay).append("日"));  
        }
    };  

	private void showDatePickerDialog(){
		DatePickerDialog datePickerDialog = new DatePickerDialog(this,mDateSetListener,mYear, mMonth, mDay);
		datePickerDialog.show();
	}
	
	public static class RecordAdapter extends ArrayAdapter<TableItem>{
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
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_new_item, menu);
		return true;
	}

}
