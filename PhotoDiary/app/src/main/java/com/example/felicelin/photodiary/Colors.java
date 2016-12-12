package com.example.felicelin.photodiary;

/**
 * Created by FeliceLin on 2016/12/12.
 */

import android.graphics.Color;
public enum Colors {
    //能在列舉內實作幾個物件
    LIGHTGREY("#D3D3D3"), BLUE("#33B5E5"), PURPLE("#AA66CC"),
    GREEN("#99CC00"), ORANGE("#FFBB33"), RED("#FF4444");
    private String code;
    private Colors(String code) {    //建構子設為private因為只在物件內實作出物件
        this.code = code;
    }
    public String getCode() {    //取得顏色的String
        return code;
    }
    public int parseColor() {    //使用Color解析code
        return Color.parseColor(code);
    }
}

