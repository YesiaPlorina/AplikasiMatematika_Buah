package com.example.yesiaplorina.aplikasimatematika.buah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yesiaplorina.aplikasimatematika.R;

public class BuahUtama extends AppCompatActivity {

    //deklarasi recyclerview

    RecyclerView rvBuah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah_utama);

        //casing view / hubungkan dengan idnya

        rvBuah = findViewById(R.id.recyclerview);


        // create function/method

        setUpList();
    }

    private void setUpList() {
        //cara menampilkann data yang mau ditampilkan
       // rvBuah.setLayoutManager(new LinearLayoutManager(this));//linear
        rvBuah.setLayoutManager(new GridLayoutManager(this,2));//vertical
        rvBuah.setHasFixedSize(true);// jika ada penambahan data ukurannya akan menyesuaikan

        //create objek dari adapter
        BuahAdapter adapter = new BuahAdapter(this);

        //set recyclerview nya kedalam adaptet
        rvBuah.setAdapter(adapter);
    }
}
