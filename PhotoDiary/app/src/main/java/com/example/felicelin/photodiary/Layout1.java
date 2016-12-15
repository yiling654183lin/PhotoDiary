package com.example.felicelin.photodiary;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Layout1 extends AppCompatActivity {

    private String date;
    private ImageButton photo1;
    private TextView content1;
    private final static int PHOTO = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout1);

        Intent intent = this.getIntent();
        //取得傳遞過來的資料
        date = intent.getStringExtra("date");
        Toast.makeText( this , date , Toast.LENGTH_SHORT).show();

        photo1 = (ImageButton)this.findViewById(R.id.l1_photo1);
        content1 = (TextView) this.findViewById(R.id.l1_content1);

        photo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, PHOTO);
            }
        });
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

                setTitle( uri.toString() );
            }
            else
            {
                setTitle("無效的檔案路徑 !!");
            }
        }
        else
        {
            setTitle("取消選擇檔案 !!");
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
