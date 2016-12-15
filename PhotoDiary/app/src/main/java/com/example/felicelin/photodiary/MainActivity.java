package com.example.felicelin.photodiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CalendarView cv;
    private TextView tv;
    private Button bt;
    int Myear,Mmonth,Mday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();

        //抓今天的日期
        Calendar c=Calendar.getInstance();//建立抓日期物件c
        Myear=c.get(Calendar.YEAR);//年
        Mmonth=c.get(Calendar.MONTH);//月
        Mday=c.get(Calendar.DAY_OF_MONTH);//日

        tv.setText(new StringBuilder().append(Myear).append("-").append(Mmonth+1).append("-").append(Mday));

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
               {
                   @Override
                   public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth)
                   {
                       // TODO Auto-generated method stub
                       Myear = year;
                       Mmonth = month;
                       Mday = dayOfMonth;

                       tv.setText(new StringBuilder().append(Myear).append("-").
                               append(Mmonth+1).append("-").append(Mday));

                       //StringBuilder可以將字串連續的加入

                   }
               }
        );
        bt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
            // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ViewEventList.class);
                intent.putExtra("date",tv.getText().toString());
                startActivity(intent);
                MainActivity.this.finish();
            }
        });

    }

    private void getViews()
    {
        tv=(TextView)findViewById(R.id.textView2);
        cv=(CalendarView)findViewById(R.id.calendarView2);
        bt=(Button)findViewById(R.id.Show);
    }
}
