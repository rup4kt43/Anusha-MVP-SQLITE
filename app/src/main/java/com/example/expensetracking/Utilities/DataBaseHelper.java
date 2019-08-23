package com.example.expensetracking.Utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
   private static final String DATABASE_NAME="userDetail.db";
   private static final String TABLE_NAME="table_user";
   private static  final String COL_ID="id";
   private static final String COL_USERNAME="username";
   private static final String COL_EMAIL="email";
   private static final String COL_PASSWORD="passsword";
   private static final String COL_PHONE="phone";

    public static final String CREATE_TABLE_USER = "CREATE TABLE " +
            TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + COL_USERNAME + " TEXT, "
            + COL_EMAIL + " TEXT, " + COL_PASSWORD + " TEXT, " + COL_PHONE + " INTEGER  )";


    public DataBaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
      onCreate(db);

    }

    public long insert(String username, String email,String password, String phone){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_USERNAME, username);
        cv.put(COL_EMAIL, email);
        cv.put(COL_PASSWORD, password);
        cv.put(COL_PHONE, phone);
        long result = db.insert(TABLE_NAME, null, cv);
        return  result;
    }
}
