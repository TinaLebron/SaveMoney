package com.example.lebronjames.savemoney.src.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lebronjames.savemoney.R;
import com.example.lebronjames.savemoney.src.database.DBHelper;
import com.example.lebronjames.savemoney.src.model.PersonalAccount;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    //資料庫
    private DBHelper dbHelper;

    //個人帳戶List
    private List<PersonalAccount> personalAccounts = new ArrayList<PersonalAccount>();

    public static MainActivity Instance;

    private int total;

    //UI屬性
    private TextView tvTitle;
    private Button btnList;
    private Button btnSaving;
    private Button btnReset;

    //做DBHelper入口點給外部class使用,不需再實體化DBHelper
    public DBHelper _dbHelper(){
        if(dbHelper == null)
            dbHelper = new DBHelper(this);
        return dbHelper;
    }

    //顯示首頁的總存款
    public void showTotal(){

        tvTitle.setText(total + "");
    }

    //計算總餘額
    private void calculateMoney(){
        if(total > 0)
            total = 0;

        for (PersonalAccount c : personalAccounts) {
            total += c.getSaving();
        }
    }

    //將讀取回來的資料set進model
    private void setSqlDataToModel(){
        Cursor cursor = dbHelper.selectDataFromPiggyBank();

        if(personalAccounts.size() > 0)
            personalAccounts.clear();

        if(cursor != null) {
            if(cursor.getCount() > 0 ) {
                //取得資料庫,所需要的所有欄位的資料
                while (cursor.moveToNext()) {
                    int saving = cursor.getInt(
                            cursor.getColumnIndex(DBHelper.MyPiggyBank.COLUMN_NAME_SAVING));
                    String date = cursor.getString(
                            cursor.getColumnIndex(DBHelper.MyPiggyBank.COLUMN_NAME_DATE));

                    //把資料庫資料set進model
                     personalAccounts.add(new PersonalAccount(saving, date));

                }
                cursor.close();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //通知訊息
        Log.i("ACT_DEMO","onCreate() 事件被觸發");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        Instance = this;

        InitialComponent();
        //new DB
        dbHelper = new DBHelper(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        //通知訊息
        Log.i("ACT_DEMO","onStart() 事件被觸發");
    }

    @Override
    protected void onResume() {
        super.onResume();

        //通知訊息
        Log.i("ACT_DEMO","onResume() 事件被觸發");

        //將讀取回來的資料set進model
        setSqlDataToModel();
        calculateMoney();
        showTotal();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //通知訊息
        Log.i("ACT_DEMO","onRestart() 事件被觸發");
    }

    @Override
    protected void onPause() {
        super.onPause();

        //通知訊息
        Log.i("ACT_DEMO","onPause() 事件被觸發");

    }

    @Override
    protected void onStop() {
        super.onStop();

        //通知訊息
        Log.i("ACT_DEMO","onStop() 事件被觸發");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //通知訊息
        Log.i("ACT_DEMO","onDestroy() 事件被觸發");
    }

    //歷史紀錄按鈕事件
    private View.OnClickListener btnList_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new  Intent(MainActivity.this,HistoricalRecordActivity.class);
            startActivity(intent);
        }
    };

    //存錢按鈕事件
    private View.OnClickListener btnSaving_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,SaveMoneyActivity.class);
            startActivity(intent);
        }
    };

    //重置按鈕,按下會跳出視窗,做確認
    private View.OnClickListener btnReset_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.btnReset){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("警告！！！")  //設定dialog 的title顯示內容
                        .setIcon(null) //設定dialog 的ICON
                        .setMessage("此按鈕為重置,請確認是否要重新紀錄！！！")//設定dialog 的主要訊息內容
                        .setCancelable(false) //關閉 Android 系統的主要功能鍵(menu,home等...)
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // 按下"是"要刪除資料庫,總價歸零
                                dbHelper.removeAll();
                                tvTitle.setText("0");
                            }

                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // 按下"取消"不作動

                            }
                        }).show();

            }

        }
    };

    private void InitialComponent() {
        tvTitle=findViewById(R.id.tvTitle);
        btnList=findViewById(R.id.btnList);
        btnList.setOnClickListener(btnList_click);
        btnSaving=findViewById(R.id.btnSaving);
        btnSaving.setOnClickListener(btnSaving_click);
        btnReset=findViewById(R.id.btnReset);
        btnReset.setOnClickListener(btnReset_click);
    }


}
