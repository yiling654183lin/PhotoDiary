package com.example.felicelin.photodiary;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ViewLayout1 extends AppCompatActivity {

    private String date, ID;
    private TextView date_layout, place, content1;
    private ImageView photo1;
    private Test_Data test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_layout1);
        Intent intent = this.getIntent();
        //取得傳遞過來的資料
        date = intent.getStringExtra("date");
        ID = intent.getStringExtra("ID");
        //Toast.makeText( this , date + " Layout 1", Toast.LENGTH_SHORT).show();
        getViews();
        Item result = test.get_trip(Long.parseLong(ID));

        photo1.setImageURI(Uri.parse(result.getPhoto_1()));
        date_layout.setText(result.getDate());
        place.setText(result.getPlace());
        content1.setText(result.getContent_1());
    }

    private void getViews()
    {
        date_layout = (TextView) this.findViewById(R.id.vl1_date);
        place = (TextView) this.findViewById(R.id.vl1_place);
        content1 = (TextView) this.findViewById(R.id.vl1_content1);
        photo1 = (ImageView) this.findViewById(R.id.vl1_photo1);
        test=new Test_Data(ViewLayout1.this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
            Intent intent = new Intent();
            intent.setClass(ViewLayout1.this, ViewEventList.class);
            intent.putExtra("date",date);
            startActivity(intent);
            ViewLayout1.this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
