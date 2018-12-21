package com.example.maehendra14.pesonamalangraya;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelperLogin extends SQLiteOpenHelper
{
    private static final String DB_NAME = "login.db"; //membuat database bernama login
    private static final int DB_VERSION = 2; //menggunakan database versi 2
    SQLiteDatabase db = this.getWritableDatabase();
    public DataHelperLogin(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table user(username text primary key, password text)"); //membuat tabel bernama user
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists user"); //perintah menghapus tabel user jika sudah terdapat ebelumnya
    }

    public boolean insert(String username, String password)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long insert = db.insert("user",null,contentValues);
        if (insert == -1)
            return false;
        else
            return true;
    }

    public Boolean isUsernameExist(String username) //mengecek username sudah ada atau belum
    {
        Cursor cursor = db.rawQuery("Select * from user where username=?",new String[]{username});
        if (cursor.getCount() > 0)
            return false;
        else
            return true;
    }

    public Boolean checkLogin(String username,String password) //mengecek username dan password sudah terdaftar pada tabel user atau belum
    {
        Cursor cursor = db.rawQuery("Select * from user where username=? and password=?",new String[]{username,password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
