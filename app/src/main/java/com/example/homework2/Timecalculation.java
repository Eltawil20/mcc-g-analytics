package com.example.homework2;

import android.util.Log;

public class Timecalculation {
    public  static long timecalculation(long startTimer,long endTimer) {
        long screenOnTime;
        endTimer = System.currentTimeMillis();
        screenOnTime = endTimer - startTimer;
        screenOnTime = (screenOnTime / 60) / 10;
        Log.d("khaled", screenOnTime + "");
    return screenOnTime;
    }
}