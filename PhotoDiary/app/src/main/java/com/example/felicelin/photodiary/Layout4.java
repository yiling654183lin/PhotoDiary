package com.example.felicelin.photodiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class Layout4 extends AppCompatActivity {

    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout4);

        Intent intent = this.getIntent();
        //取得傳遞過來的資料
        date = intent.getStringExtra("date");
        Toast.makeText( this , date , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
            Intent intent = new Intent();
            intent.setClass(Layout4.this, ChooseLayout.class);
            intent.putExtra("date",date);
            startActivity(intent);
            Layout4.this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
