package com.example.felicelin.photodiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ChooseLayout extends AppCompatActivity {

    private String date;
    private ImageButton layout1;
    private ImageButton layout2;
    private ImageButton layout3;
    private ImageButton layout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_layout);

        Intent intent = this.getIntent();
        //取得傳遞過來的資料
        date = intent.getStringExtra("date");
        //Toast.makeText( this , date , Toast.LENGTH_SHORT).show();

        //getViews
        layout1 = (ImageButton)findViewById(R.id.Layout_1);
        layout2 = (ImageButton)findViewById(R.id.Layout_2);
        layout3 = (ImageButton)findViewById(R.id.Layout_3);
        layout4 = (ImageButton)findViewById(R.id.Layout_4);

        //setOnClickListeners
        layout1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(ChooseLayout.this, Layout1.class);
                intent.putExtra("date",date);
                startActivity(intent);
                ChooseLayout.this.finish();
            }
        });
        layout2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(ChooseLayout.this, Layout2.class);
                intent.putExtra("date",date);
                startActivity(intent);
                ChooseLayout.this.finish();
            }
        });
        layout3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(ChooseLayout.this, Layout3.class);
                intent.putExtra("date",date);
                startActivity(intent);
                ChooseLayout.this.finish();
            }
        });
        layout4.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(ChooseLayout.this, Layout4.class);
                intent.putExtra("date",date);
                startActivity(intent);
                ChooseLayout.this.finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
            Intent intent = new Intent();
            intent.setClass(ChooseLayout.this, ViewEventList.class);
            intent.putExtra("date",date);
            startActivity(intent);
            ChooseLayout.this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
