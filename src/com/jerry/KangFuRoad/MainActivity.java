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
    //�������������գ�  
    private int mYear;  
    private int mMonth;  
    private int mDay;  
    //����һ����һ�޶��ı�ʶ������ΪҪ��ʾDatePicker��Dialog��ID��  
    static final int DATE_DIALOG_ID = 0;  
    /** Called when the activity is first created. */  
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView)findViewById(R.id.new_record_date);  
     //   button = (Button)findViewById(R.id.new_pick_date);  
        //��button����¼���������  
		text.setOnClickListener(new OnClickListener() {  
              
            @SuppressWarnings("deprecation")
			@Override  
            public void onClick(View v) {  
                //����Activity��ķ�������ʾDialog:�����������������Activity�����Dialog���������ڣ�  
                //������� onCreateDialog(int)�ص�����������һ��Dialog  
                showDialog(DATE_DIALOG_ID);  
            }  
        });  
        //��õ�ǰ�����ڣ�  
        final Calendar currentDate = Calendar.getInstance();  
        mYear = currentDate.get(Calendar.YEAR);  
        mMonth = currentDate.get(Calendar.MONTH);  
        mDay = currentDate.get(Calendar.DAY_OF_MONTH);  
        //�����ı������ݣ�  
        text.setText(new StringBuilder()  
                    .append(mYear).append("��")  
                    .append(mMonth + 1).append("��")//�õ����·�+1����Ϊ��0��ʼ  
                    .append(mDay).append("��"));  
	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListener =new OnDateSetListener() {  
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {  
            mYear = year;  
            mMonth = monthOfYear;  
            mDay = dayOfMonth;  
            //�����ı������ݣ�  
            text.setText(new StringBuilder()  
                        .append(mYear).append("��")  
                        .append(mMonth + 1).append("��")//�õ����·�+1����Ϊ��0��ʼ  
                        .append(mDay).append("��"));  
        }  
    };  
	/** 
	 * ��Activity����showDialog����ʱ�ᴥ���ú����ĵ��ã� 
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
