package com.jerry.KangFuRoad;

import java.util.ArrayList;
import java.util.Calendar;

import com.jerry.KangFuRoad.provider.Contract.RecordContract.RegularColumns;
import com.jerry.KangFuRoad.provider.Contract.TableContract;
import com.jerry.KangFuRoad.provider.model.Table;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
