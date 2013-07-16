package com.jerry.KangFuRoad;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView text = null;  
    private Button button = null;  
    //用来保存年月日：  
    private int mYear;  
    private int mMonth;  
    private int mDay;  
    //声明一个独一无二的标识，来作为要显示DatePicker的Dialog的ID：  
    static final int DATE_DIALOG_ID = 0;  
    /** Called when the activity is first created. */  
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView)findViewById(R.id.new_record_date);  
     //   button = (Button)findViewById(R.id.new_pick_date);  
        //给button添加事件监听器：  
		text.setOnClickListener(new OnClickListener() {  
              
            @SuppressWarnings("deprecation")
			@Override  
            public void onClick(View v) {  
                //调用Activity类的方法来显示Dialog:调用这个方法会允许Activity管理该Dialog的生命周期，  
                //并会调用 onCreateDialog(int)回调函数来请求一个Dialog  
                showDialog(DATE_DIALOG_ID);  
            }  
        });  
        //获得当前的日期：  
        final Calendar currentDate = Calendar.getInstance();  
        mYear = currentDate.get(Calendar.YEAR);  
        mMonth = currentDate.get(Calendar.MONTH);  
        mDay = currentDate.get(Calendar.DAY_OF_MONTH);  
        //设置文本的内容：  
        text.setText(new StringBuilder()  
                    .append(mYear).append("年")  
                    .append(mMonth + 1).append("月")//得到的月份+1，因为从0开始  
                    .append(mDay).append("日"));  
	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListener =new OnDateSetListener() {  
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {  
            mYear = year;  
            mMonth = monthOfYear;  
            mDay = dayOfMonth;  
            //设置文本的内容：  
            text.setText(new StringBuilder()  
                        .append(mYear).append("年")  
                        .append(mMonth + 1).append("月")//得到的月份+1，因为从0开始  
                        .append(mDay).append("日"));  
        }  
    };  
	/** 
	 * 当Activity调用showDialog函数时会触发该函数的调用： 
	 */  
	@Override  
	protected Dialog onCreateDialog(int id) {  
	       switch (id) {  
	        case DATE_DIALOG_ID:  
	            return new DatePickerDialog(this,mDateSetListener,mYear, mMonth, mDay);  
	        }  
	        return null;  
	}  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
