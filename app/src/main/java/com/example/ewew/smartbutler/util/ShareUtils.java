package com.example.ewew.smartbutler.util;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtils {

    public static final  String NAME="config";

    //键值
    public static void putString(Context mContext,String key,String value)
    {
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }

    //默认键值
    public static String getString(Context mContext,String key,String devalue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getString(key,devalue);
    }

    //键值
    public static void putInt(Context mContext,String key,int value)
    {
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }

    //默认键值
    public static int getInt(Context mContext,String key,int devalue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getInt(key,devalue);
    }

    //键值
    public static void putBoolean(Context mContext,String key,Boolean value)
    {
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }

    //默认键值
    public static Boolean getBoolean(Context mContext,String key,Boolean devalue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(key,devalue);
    }

    //删除单个
    public static void deleShare(Context mContext,String key){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }

    //删除全部
    public static void deleAll(Context mContext){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }
}
