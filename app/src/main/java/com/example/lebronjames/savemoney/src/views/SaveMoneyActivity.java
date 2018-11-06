package com.example.lebronjames.savemoney.src.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lebronjames.savemoney.R;
import com.example.lebronjames.savemoney.src.database.DBHelper;
import com.example.lebronjames.savemoney.src.utils.Tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SaveMoneyActivity extends AppCompatActivity {



    //返回上一頁
    private void backToMainActivity(){
        setResult(0);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //通知訊息
        Log.i("ACT_DEMO","onCreate() 事件被觸發");

        setContentView(R.layout.savemoney);

        InitialComponent();
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

    //
    private View.OnClickListener btnOK_click = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            //自動產生時間
            String date = Tools.automaticGenerationTime();

           DBHelper dbHelper = MainActivity.Instance._dbHelper();
            boolean isInserted = dbHelper.insertData(Integer.parseInt(etSaving.getText().toString()),date);

            //顯是提式訊息
            if(isInserted)
                Toast.makeText(SaveMoneyActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(SaveMoneyActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

        }
    };

    //返回上一頁
    private View.OnClickListener btnBack_click = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            backToMainActivity();

        }
    };

    private void InitialComponent() {
        etSaving=findViewById(R.id.etSaving);
        btnOK=findViewById(R.id.btnOK);
        btnOK.setOnClickListener(btnOK_click);
        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(btnBack_click);
    }
    private Button btnOK;
    private EditText etSaving;
    private Button btnBack;
}
