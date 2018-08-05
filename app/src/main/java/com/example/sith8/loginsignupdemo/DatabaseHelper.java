package com.example.sith8.loginsignupdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String TABLE_NAME="User";
    public static final String FULL_NAME="Full_name";
    public static final String EMAIL="Email";
    public static final String USERNAME="UserName";
    public static final String PASSWORD="Password";
    public static final String CONFIRM_PASSWORD="Confirm_Password";

    public static final String DATABASE_NAME="test.db";
    public static final int DATABASE_VERSION=1;



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query="create table "+TABLE_NAME+"( "+FULL_NAME+" text, "+EMAIL+" text,"+USERNAME+" text,"+PASSWORD+" text, "+CONFIRM_PASSWORD+" text unique)";
        sqLiteDatabase.rawQuery(query,null);
    }

    public void insert_user(UserModel model){
        SQLiteDatabase writableDatabase=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(FULL_NAME,model.getFull_name());
        contentvalues.put(EMAIL,model.getEmail());
        contentvalues.put(USERNAME,model.getUser_name());
        contentvalues.put(PASSWORD,model.getPassword());
        contentvalues.put(CONFIRM_PASSWORD,model.getConfirm_password());
        writableDatabase.insert(TABLE_NAME,null,contentvalues);
    }

    String validate(String username,String password){
        SQLiteDatabase db= this.getReadableDatabase();
        String fullname=null;
        String query1="select " +FULL_NAME+" from " +TABLE_NAME+ " where USERNAME='" +username+ "' AND PASSWORD='" +password+ "'";

        Cursor c= db.rawQuery(query1,null);
        //query("select FULL_NAME from"+TABLE_NAME+"where USERNAME='+username+'"+"AND PASSWORD='+password+'";);
        if(c.getCount()>0)
        {
            c.moveToFirst();
            fullname=c.getString(c.getColumnIndex(FULL_NAME));
        }
        return fullname;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
    }
}
