package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;

public class Products extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseAnalytics mFirebaseAnalytics;
    long startTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        int getid = getIntent().getIntExtra("id", 0);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        startTimer = System.currentTimeMillis();
        recyclerView = findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ArrayList<ProductModel> arrayList = new ArrayList();
        switch (getid) {
            case 1:
                arrayList.add(new ProductModel("aa", "aa", "a", 7));
                arrayList.add(new ProductModel("aa", "aa", "a", 8));
                arrayList.add(new ProductModel("aa", "aa", "a", 9));
                break;
            case 2:
                arrayList.add(new ProductModel("adfaa", "adsfaa", "adfa", 4));
                arrayList.add(new ProductModel("aasadf", "aadfa", "aaf", 5));
                arrayList.add(new ProductModel("aadsf", "adsfaa", "afa", 6));
                break;
            case 3:
                arrayList.add(new ProductModel("mobile not 8 pro", "image1", "Ceramic tile and porcelain tile are the foundation of our vast tile selection including subway tile, wood look tile and every tile in between.", 1));
                arrayList.add(new ProductModel("mobile not 9s", "image2", "Ceramic tile and porcelain tile are the foundation of our vast tile selection including subway tile, wood look tile and every tile in between.", 2));
                arrayList.add(new ProductModel("labtop hp cori7", "image3", "More everything. The Star LabTop Mk IV delivers up to a 67% performance increase with the optional Intel® Core® i7-10710u processor and even faster storage. With an improved trackpad, speakers and display, the extra power is even more usable.", 3));
                break;
        }


        recyclerView.setAdapter(new ProductAdapter(getApplicationContext(), arrayList));


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
