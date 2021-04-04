package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class Deatil extends AppCompatActivity {
    long startTimer;
    FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatil);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        startTimer = System.currentTimeMillis();        int id=getIntent().getIntExtra("id",0);
        TextView textView2=findViewById(R.id.textView2);
        TextView textView3=findViewById(R.id.textView3);
        ImageView imageView=findViewById(R.id.imageView);
        textView2.setText(getIntent().getStringExtra("name"));
        textView3.setText(getIntent().getStringExtra("deatil"));
        imageView.setImageResource (getResources ().getIdentifier (getIntent().getStringExtra("image"),"drawable",getPackageName () ));



    }

    void trackscreen(long screentime) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, "products");
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "Products");
        bundle.putString("time",screentime+"");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        long timescreen= Timecalculation.timecalculation(startTimer ,System.currentTimeMillis());
        trackscreen(timescreen);
    }
}