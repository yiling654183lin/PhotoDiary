package com.example.felicelin.photodiary;

import android.provider.CalendarContract;

import java.io.Serializable;
@SuppressWarnings("serial")

/**
 * Created by FeliceLin on 2016/12/12.
 */

public class Item implements Serializable {    //介面為物件序列化,可將物件變成二進位串流,就可儲存成檔案,也可以直接將物件丟進輸出入串流做傳送
    private long id;
    private String date;
    private String content_1;
    private String photo_1;
    private String content_2;
    private String photo_2;
    private String content_3;
    private String photo_3;
    private String place;
    private int layout;
    public Item(){
        this.content_1 = "";
        this.layout=1;
    }
    public Item(int id, String date, String content_1, String photo_1, String place, int layout){
        this.id=id;
        this.date=date;
        this.content_1=content_1;
        this.photo_1=photo_1;
        this.place=place;
        this.layout=layout;
    }
    public Item(int id, String date, String content_1, String photo_1, String content_2, String photo_2, String place, int layout){
        this.id=id;
        this.date=date;
        this.content_1=content_1;
        this.photo_1=photo_1;
        this.content_2=content_2;
        this.photo_2=photo_2;
        this.place=place;
        this.layout=layout;
    }
    public Item(int id, String date, String content_1, String photo_1, String content_2, String photo_2, String content_3, String photo_3, String place, int layout){
        this.id=id;
        this.date=date;
        this.content_1=content_1;
        this.photo_1=photo_1;
        this.content_2=content_2;
        this.photo_2=photo_2;
        this.content_3=content_3;
        this.photo_3=photo_3;
        this.place=place;
        this.layout=layout;
    }
    public void setId(long id){
        this.id=id;
    }
    public long getId(){
        return this.id;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getDate(){
        return this.date;
    }
    public void setContent_1(String content_1){
        this.content_1=content_1;
    }
    public String getContent_1(){
        return this.content_1;
    }
    public void setPhoto_1(String photo_1){
        this.photo_1=photo_1;
    }
    public String getPhoto_1(){
        return this.photo_1;
    }
    public void setContent_2(String content_2){
        this.content_2=content_2;
    }
    public String getContent_2(){
        return this.content_2;
    }
    public void setPhoto_2(String photo_2){
        this.photo_2=photo_2;
    }
    public String getPhoto_2(){
        return this.photo_2;
    }
    public void setContent_3(String content_3){
        this.content_3=content_3;
    }
    public String getContent_3(){
        return this.content_3;
    }
    public void setPhoto_3(String photo_3){
        this.photo_3=photo_3;
    }
    public String getPhoto_3(){
        return this.photo_3;
    }
    public void setPlace(String place){
        this.place=place;
    }
    public String getPlace(){
        return this.place;
    }
    public void setLayout(int layout){
        this.layout=layout;
    }
    public int getLayout(){
        return this.layout;
    }


}
