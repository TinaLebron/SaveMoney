package com.example.lebronjames.savemoney.src.views;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.example.lebronjames.savemoney.src.database.DBHelper;
import com.example.lebronjames.savemoney.src.model.PersonalAccount;

import java.util.ArrayList;
import java.util.List;

public class HistoricalRecordActivity extends ListActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(dbHelper == null)
            dbHelper = MainActivity.Instance._dbHelper();

        Cursor cursor = dbHelper.selectDataFromPiggyBank();

        List<String> personalAccounts = new ArrayList<>();

        //把資料庫所需要的欄位的所有資料,放進personalAccounts
        while (cursor.moveToNext()) {

            String history = cursor.getString(
                    cursor.getColumnIndex(DBHelper.MyPiggyBank.COLUMN_NAME_DATE))
                    +"   $"
                    + cursor.getInt(cursor.getColumnIndex(DBHelper.MyPiggyBank.COLUMN_NAME_SAVING));

            personalAccounts.add(history);

        }

        ListAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                personalAccounts
        );

        setListAdapter(adapter);

    }
}
