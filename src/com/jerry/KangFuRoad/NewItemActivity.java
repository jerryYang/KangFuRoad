package com.jerry.KangFuRoad;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jerry.KangFuRoad.adapter.RecordAdapter;
import com.jerry.KangFuRoad.provider.Contract.RecordContract.RegularColumns;
import com.jerry.KangFuRoad.provider.model.Regular;
import com.jerry.KangFuRoad.provider.model.Table;

public class NewItemActivity extends Activity {

	private TextView mDateTextView = null;  
    private Button button = null;  
    private int mYear;  
    private int mMonth;  
    private int mDay;  
    static final int DATE_DIALOG_ID = 0;  
    /** Called when the activity is first created. */  
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_item);
		mDateTextView = (TextView)findViewById(R.id.new_record_date);  
		mDateTextView.setOnClickListener(new OnClickListener() {  
			@Override  
            public void onClick(View v) {  
            	showDatePickerDialog(); 
            }  
        });  
        final Calendar currentDate = Calendar.getInstance();  
        mYear = currentDate.get(Calendar.YEAR);  
        mMonth = currentDate.get(Calendar.MONTH);  
        mDay = currentDate.get(Calendar.DAY_OF_MONTH);  
        mDateTextView.setText(new StringBuilder()  
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
            mDateTextView.setText(new StringBuilder()  
                        .append(mYear).append("年")  
                        .append(mMonth + 1).append("月")
                        .append(mDay).append("日"));  
        }
    };  

	private void showDatePickerDialog(){
		DatePickerDialog datePickerDialog = new DatePickerDialog(this,mDateSetListener,mYear, mMonth, mDay);
		datePickerDialog.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_new_item, menu);
		MenuItem item = menu.findItem(R.id.menu_new_item_save);
		item.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				saveItem();
				return false;
			}
		});
		return true;
	}


	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
	
	private void saveItem(){
        ListView list = (ListView) this.findViewById(R.id.new_items_container);
        int count = list.getChildCount();
        
        Calendar date = Calendar.getInstance();
        date.set(mYear, mMonth, mDay);
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("date", date.toString());
        for(int i = 0; i < count; ++i){
        	View view = list.getChildAt(i);
        	RecordAdapter adapter = (RecordAdapter) list.getAdapter();
        	EditText editTextView = (EditText) view.findViewById(R.id.item_value);
        	String text = editTextView.getText().toString();
        	if(TextUtils.isEmpty(text)){
        		text = (String) editTextView.getHint();
        	}
        	String id = adapter.getId(i);
        	
        	map.put(id, text);
        }
        Regular.save(map, this);
        finish();
	}
	
}
