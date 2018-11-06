package com.example.lebronjames.savemoney.src.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tools {
    //自動產生時間
    public static String automaticGenerationTime(){
        Calendar calendar = Calendar.getInstance() ;//取得當下時間//先行定義時間格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//取得現在時間
        Date dt=new Date();//透過SimpleDateFormat的format方法將Date轉為字串
        return sdf.format(dt);
    }
}
