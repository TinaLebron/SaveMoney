package com.example.lebronjames.savemoney.src.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.provider.BaseColumns;
import android.util.Log;

import java.io.File;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    public static final String FILE_DIR = "MyPiggyDB";

   private static final String SQL_CREATE_MYPIGGYBANK =
           "CREATE TABLE " + MyPiggyBank.TABLE_NAME + " (" +
                   MyPiggyBank._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                   MyPiggyBank.COLUMN_NAME_SAVING + " INTEGER," +
                   MyPiggyBank.COLUMN_NAME_DATE + " TEXT)";
                   //MyPiggyBank.COLUMN_NAME_TOTAL + " INTEGER)";

   private static final String SQL_DELETE_MYPIGGYBANK =
           "DROP TABLE IF EXISTS " + MyPiggyBank.TABLE_NAME;


    public static class MyPiggyBank implements BaseColumns {
        public static final String DATABASE_NAME = "PiggyBank.db";
        public static final String TABLE_NAME = "myPiggyBank_table";
        public static final String COLUMN_NAME_SAVING = "SAVING";
        public static final String COLUMN_NAME_DATE = "DATE";
       // public static final String COLUMN_NAME_TOTAL = "TOTAL";
    }


    public DBHelper(Context context) {
//        super(context, Environment.getExternalStorageDirectory()
//                + File.separator + FILE_DIR
//                + File.separator + MyPiggyBank.DATABASE_NAME, null, 1);

        super(context, MyPiggyBank.DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
     Log.d("DBHelper","onCreate()");
     db.execSQL(SQL_CREATE_MYPIGGYBANK);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_MYPIGGYBANK);
        onCreate(db);
    }

    public boolean insertData(int saving,String date){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(MyPiggyBank.COLUMN_NAME_SAVING,saving);
        values.put(MyPiggyBank.COLUMN_NAME_DATE,date);

        long newRowId = db.insert(MyPiggyBank.TABLE_NAME,null,values);
        if(newRowId == -1)
            return false;
        else
            return true;
    }

    public Cursor selectDataFromPiggyBank(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                MyPiggyBank.COLUMN_NAME_SAVING,
                MyPiggyBank.COLUMN_NAME_DATE
        };

        Cursor cursor = db.query(
                MyPiggyBank.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
       return cursor;
    }


    public void removeAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(MyPiggyBank.TABLE_NAME, null, null);
    }


}












