package com.example.felicelin.photodiary;

import android.support.v7.app.AppCompatActivity;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t01=(TextView) this.findViewById(R.id.t01);
        // 建立資料庫物件
        Test_Data test=new Test_Data(MainActivity.this);
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
            t01.append("\n第"+String.valueOf(i.getId()).toString()+"筆聊天紀錄\n");
            t01.append("該玩家number為="+i.getDate()+"\n");
            t01.append("name為="+i.getContent_1()+"\n");
            t01.append("content為="+i.getPhoto_1()+"\n");
            t01.append("文字color為="+i.getPlace()+"\n");
        }
        test.close();
    }
}
