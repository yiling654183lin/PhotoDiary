package com.example.felicelin.photodiary;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewLayout2 extends AppCompatActivity {

    private String date, ID;
    private TextView date_layout, place, content1, content2;
    private ImageView photo1, photo2;
    private Test_Data test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_layout2);
        Intent intent = this.getIntent();
        //取得傳遞過來的資料
        date = intent.getStringExtra("date");
        ID = intent.getStringExtra("ID");
        //Toast.makeText( this , date  + " Layout 2", Toast.LENGTH_SHORT).show();
        getViews();
        Item result = test.get_trip(Long.parseLong(ID));

        date_layout.setText(result.getDate());
        place.setText(result.getPlace());
        content1.setText(result.getContent_1());
        photo1.setImageURI(Uri.parse(result.getPhoto_1()));
        content2.setText(result.getContent_2());
        photo2.setImageURI(Uri.parse(result.getPhoto_2()));
    }

    private void getViews()
    {
        date_layout = (TextView) this.findViewById(R.id.vl2_date);
        place = (TextView) this.findViewById(R.id.vl2_place);
        content1 = (TextView) this.findViewById(R.id.vl2_content1);
        photo1 = (ImageView) this.findViewById(R.id.vl2_photo1);
        content2 = (TextView) this.findViewById(R.id.vl2_content2);
        photo2 = (ImageView) this.findViewById(R.id.vl2_photo2);
        test=new Test_Data(ViewLayout2.this);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
            Intent intent = new Intent();
            intent.setClass(ViewLayout2.this, ViewEventList.class);
            intent.putExtra("date",date);
            startActivity(intent);
            ViewLayout2.this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
