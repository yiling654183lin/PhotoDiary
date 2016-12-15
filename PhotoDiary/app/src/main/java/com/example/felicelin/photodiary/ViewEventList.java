package com.example.felicelin.photodiary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ViewEventList extends AppCompatActivity {

    private TextView t01;
    private LinearLayout evenetList;
    private String date;
    private ImageButton btnGreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event_list);

        Intent intent = this.getIntent();
        //取得傳遞過來的資料
        date = intent.getStringExtra("date");
        Toast.makeText( this , date , Toast.LENGTH_SHORT).show();

        //getViews
        t01=(TextView) this.findViewById(R.id.t01);
        evenetList=(LinearLayout) this.findViewById(R.id.eventList);

        // 建立資料庫物件
        Test_Data test=new Test_Data(ViewEventList.this);
        // 如果資料庫是空的，就建立一些範例資料
        // 這是為了方便測試用的，完成應用程式以後可以拿掉
        if (test.getCount_trip() == 0) {
            test.sample();
        }
        t01.setText("Test測試:\n");
        //取得資料數
        t01.append("目前資料庫裡有"+String.valueOf(test.getCount_trip()).toString()+"筆資料\n");
        // 取得所有記事資料
        List<Item> items=test.getAll_trip();

        for(Item i:items){
            /*
            t01.append("\n第"+String.valueOf(i.getId()).toString()+"筆聊天紀錄\n");
            t01.append("該玩家number為="+i.getDate()+"\n");
            t01.append("name為="+i.getContent_1()+"\n");
            t01.append("content為="+i.getPhoto_1()+"\n");
            t01.append("文字color為="+i.getPlace()+"\n");
            */
            btnGreen = new ImageButton(this);
            btnGreen = new ImageButton(this);
            btnGreen.setImageResource(R.drawable.event_button);
            btnGreen.setOnClickListener(ClickListener);
            btnGreen.setBackgroundColor(Color.TRANSPARENT);
            btnGreen.setTag(Integer.toString(i.getLayout()));
            btnGreen.setId(Integer.parseInt(String.valueOf(i.getId())));

            evenetList.addView(btnGreen);
        }
        test.close();

        Button Add = (Button)findViewById(R.id.NewEvent);
        Add.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(ViewEventList.this, ChooseLayout.class);
                intent.putExtra("date",date);
                startActivity(intent);
                ViewEventList.this.finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
            Intent intent = new Intent();
            intent.setClass(ViewEventList.this, MainActivity.class);
            intent.putExtra("date",date);
            startActivity(intent);
            ViewEventList.this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    private View.OnClickListener ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tag=(String)v.getTag();
            Intent intent = new Intent();
            switch (tag) {
                case "1":
                    intent.setClass(ViewEventList.this, ViewLayout1.class);
                    break;
                case "2":
                    intent.setClass(ViewEventList.this, ViewLayout2.class);
                    break;
                case "3":
                    intent.setClass(ViewEventList.this, ViewLayout3.class);
                    break;
                case "4":
                    intent.setClass(ViewEventList.this, ViewLayout4.class);
                    break;

            }
            intent.putExtra("date",date);
            startActivity(intent);
            ViewEventList.this.finish();
        }
    };
}
