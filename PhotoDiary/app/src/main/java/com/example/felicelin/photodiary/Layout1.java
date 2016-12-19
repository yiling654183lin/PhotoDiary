package com.example.felicelin.photodiary;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Layout1 extends AppCompatActivity {

    private String date;
    private ImageButton photo1;
    private String photo1_addr;
    private TextView content1, date_layout, place;
    private Button save;
    private final static int PHOTO = 99;
    private Test_Data test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout1);

        Intent intent = this.getIntent();
        //取得傳遞過來的資料
        date = intent.getStringExtra("date");
        //Toast.makeText( this , date , Toast.LENGTH_SHORT).show();
        getViews();

        date_layout.setText(date);

        photo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PHOTO);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item item = new Item(0, date_layout.getText().toString(), content1.getText().toString(), photo1_addr, place.getText().toString(), 1);
                test.insert_trip(item);
                Intent intent = new Intent();
                intent.setClass(Layout1.this, ViewEventList.class);
                intent.putExtra("date",date);
                startActivity(intent);
                Layout1.this.finish();
            }
        });
    }

    private void getViews()
    {
        photo1 = (ImageButton)this.findViewById(R.id.l1_photo1);
        content1 = (TextView) this.findViewById(R.id.l1_content1);
        save = (Button) this.findViewById(R.id.l1_save);
        date_layout = (TextView) this.findViewById(R.id.l1_date);
        place = (TextView) this.findViewById(R.id.l1_place);
        test=new Test_Data(Layout1.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        // 有選擇檔案
        if ( resultCode == RESULT_OK )
        {
            // 取得檔案的 Uri
            Uri uri = data.getData();
            if( uri != null )
            {
                // 利用 Uri 顯示 ImageView 圖片
                photo1.setImageURI( uri );
                photo1_addr=uri.toString();
                //setTitle( uri.toString() );
                Toast.makeText( this , uri.toString() , Toast.LENGTH_SHORT).show();
            }
            else
            {
                //setTitle("無效的檔案路徑 !!");
                Toast.makeText( this , "無效的檔案路徑 !!" , Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            //setTitle("取消選擇檔案 !!");
            Toast.makeText( this , "取消選擇檔案 !!" , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
            Intent intent = new Intent();
            intent.setClass(Layout1.this, ChooseLayout.class);
            intent.putExtra("date",date);
            startActivity(intent);
            Layout1.this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
