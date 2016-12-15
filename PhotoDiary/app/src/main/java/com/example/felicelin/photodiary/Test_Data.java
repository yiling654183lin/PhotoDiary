package com.example.felicelin.photodiary;

/**
 * Created by FeliceLin on 2016/12/12.
 */
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

// 資料功能類別
public class Test_Data {

    //////----------TRIP VARIABLE--------////////
    // 表格名稱
    public static final String TABLE_NAME = "Diary";
    // 編號表格欄位名稱，固定不變
    public static final String KEY_ID = "_id";
    // 其它表格欄位名稱
    public static final String DATE_COLUMN = "date";
    public static final String CONTENT_COLUMN_1 = "content_1";
    public static final String PHOTO_COLUMN_1 = "photo_1";
    public static final String CONTENT_COLUMN_2 = "content_2";
    public static final String PHOTO_COLUMN_2 = "photo_2";
    public static final String CONTENT_COLUMN_3 = "content_3";
    public static final String PHOTO_COLUMN_3 = "photo_3";
    public static final String PLACE_COLUMN = "place";
    public static final String LAYOUT_COLUMN = "layout";

    // 使用上面宣告的變數建立表格的SQL指令
    public static final String CREATE_TABLE_TRIP =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DATE_COLUMN + " TEXT NOT NULL, " +
                    CONTENT_COLUMN_1 + " TEXT NOT NULL, " +
                    PHOTO_COLUMN_1 + " TEXT NOT NULL, " +
                    CONTENT_COLUMN_2 + " TEXT, " +
                    PHOTO_COLUMN_2 + " TEXT, " +
                    CONTENT_COLUMN_3 + " TEXT, " +
                    PHOTO_COLUMN_3 + " TEXT, " +
                    PLACE_COLUMN + " TEXT NOT NULL, " +
                    LAYOUT_COLUMN + " INTEGER NOT NULL" +
                    ")";

    // 資料庫物件
    private SQLiteDatabase db;
    // 建構子，一般的應用都不需要修改
    public Test_Data(Context context){
        db = MyDBHelper.getDatabase(context);
    }
    // 關閉資料庫，一般的應用都不需要修改
    public void close() {
        db.close();
    }

    //////----------TRIP TABLE--------////////

    // 新增參數指定的物件
    public Item insert_trip(Item item) {
        // 建立準備新增資料的ContentValues物件
        ContentValues cv = new ContentValues();
        // 加入ContentValues物件包裝的新增資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        cv.put(DATE_COLUMN, item.getDate());
        cv.put(CONTENT_COLUMN_1, item.getContent_1());
        cv.put(PHOTO_COLUMN_1, item.getPhoto_1());
        cv.put(CONTENT_COLUMN_2, item.getContent_2());
        cv.put(PHOTO_COLUMN_2, item.getPhoto_2());
        cv.put(CONTENT_COLUMN_3, item.getContent_3());
        cv.put(PHOTO_COLUMN_3, item.getPhoto_3());
        cv.put(PLACE_COLUMN, item.getPlace());
        cv.put(LAYOUT_COLUMN, item.getLayout());
        // 新增一筆資料並取得編號
        // 第一個參數是表格名稱
        // 第二個參數是沒有指定欄位值的預設值
        // 第三個參數是包裝新增資料的ContentValues物件
        long id = db.insert(TABLE_NAME, null, cv);
        // 設定編號
        item.setId(id);
        // 回傳結果
        return item;
    }
    // 修改參數指定的物件
    public boolean update_trip(Item item) {
        // 建立準備修改資料的ContentValues物件
        ContentValues cv = new ContentValues();
        // 加入ContentValues物件包裝的修改資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        cv.put(DATE_COLUMN, item.getDate());
        cv.put(CONTENT_COLUMN_1, item.getContent_1());
        cv.put(PHOTO_COLUMN_1, item.getPhoto_1());
        cv.put(CONTENT_COLUMN_2, item.getContent_2());
        cv.put(PHOTO_COLUMN_2, item.getPhoto_2());
        cv.put(CONTENT_COLUMN_3, item.getContent_3());
        cv.put(PHOTO_COLUMN_3, item.getPhoto_3());
        cv.put(PLACE_COLUMN, item.getPlace());
        cv.put(LAYOUT_COLUMN, item.getLayout());
        // 設定修改資料的條件為編號
        // 格式為「欄位名稱＝資料」
        String where = KEY_ID + "=" + item.getId();
        // 執行修改資料並回傳修改的資料數量是否成功
        return db.update(TABLE_NAME, cv, where, null) > 0;
    }
    // 刪除參數指定編號的資料
    public boolean delete_trip(long id){
        // 設定條件為編號，格式為「欄位名稱=資料」
        String where = KEY_ID + "=" + id;
        // 刪除指定編號資料並回傳刪除是否成功
        return db.delete(TABLE_NAME, where , null) > 0;
    }
    // 讀取所有記事資料
    public List<Item> getAll_trip() {
        List<Item> result = new ArrayList<Item>();
        //游標指向該資料表
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        //將所有資料轉成Item並添加進List
        while (cursor.moveToNext()) {
            result.add(getRecord_trip(cursor));
        }
        //關閉游標
        cursor.close();
        return result;
    }
    // 取得指定編號的資料物件
    public Item get_trip(long id) {
        // 準備回傳結果用的物件
        Item item = null;
        // 使用編號為查詢條件
        String where = KEY_ID + "=" + id;
        // 執行查詢
        Cursor result = db.query(TABLE_NAME, null, where, null, null, null, null, null);
        // 如果有查詢結果
        if (result.moveToFirst()) {
            // 讀取包裝一筆資料的物件
            item = getRecord_trip(result);
        }
        // 關閉Cursor物件
        result.close();
        // 回傳結果
        return item;
    }
    // 把游標Cursor取得的資料轉換成目前的資料包裝為物件
    public Item getRecord_trip(Cursor cursor) {
        // 準備回傳結果用的物件
        Item result = new Item();
        result.setId(cursor.getInt(0));
        result.setDate(cursor.getString(1));
        result.setContent_1(cursor.getString(2));
        result.setPhoto_1(cursor.getString(3));
        result.setContent_2(cursor.getString(4));
        result.setPhoto_2(cursor.getString(5));
        result.setContent_3(cursor.getString(6));
        result.setPhoto_3(cursor.getString(7));
        result.setPlace(cursor.getString(8));
        result.setLayout(cursor.getInt(9));
        return result;
    }

    // 取得資料數量
    public int getCount_trip() {
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        if (cursor.moveToNext()) {
            result = cursor.getInt(0);
        }
        return result;
    }

    // 建立範例資料
    public void sample() {
        Item item = new Item(0,"abc", "def", "ghi", "1", "2", "3", "4", "where?", 3);
        Item item1 = new Item(0,"hello", "from", "here", "where?", 1);
        insert_trip(item);
        insert_trip(item1);
    }
}
