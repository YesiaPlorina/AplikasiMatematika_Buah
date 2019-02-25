package com.example.yesiaplorina.aplikasimatematika;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TODO 1 Deklarasi widget yang ingin digubakan

    Button btnHitung;
    EditText edtPanjang, edtLebar, edtTinggi;
    TextView tvHasil;

    //deklarasi menjaga data ketika dirotate
    public static final String STATE_DATA = "STATE";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 2 casting view/ hubungkan dengan id masing-masing

        btnHitung = findViewById(R.id.btn_hitung);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtLebar = findViewById(R.id.edt_lebar);
        edtTinggi = findViewById(R.id.edt_tinggi);
        tvHasil = findViewById(R.id.tv_hasil);

        btnHitung.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_DATA);
            tvHasil.setText(result);
        }
    }

    //TODO 7 funcion / method untuk jaga data
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_DATA, tvHasil.getText().toString().trim());
    }

    @Override
    public void onClick(View v) {

        //TODO 3 cara ambil inputan user dari idet text
        String panjang = edtPanjang.getText().toString().trim();
        String lebar = edtLebar.getText().toString().trim();
        String tinggi = edtTinggi.getText().toString().trim();

        boolean isEmpty = false;
        boolean inValidNumber = false;

        if (TextUtils.isEmpty(panjang)) {
            isEmpty = true;
            edtPanjang.setError(getString(R.string.is_empty));
        } else if (!isDouble(panjang)) {
            inValidNumber = true;
            edtPanjang.setError(getString(R.string.valid_number));
        }
        if (TextUtils.isEmpty(lebar)) {
            isEmpty = true;
            edtLebar.setError(getString(R.string.is_empty));
        } else if (!isDouble(lebar)) {
            inValidNumber = true;
            edtLebar.setError(getString(R.string.valid_number));
        }
        if (TextUtils.isEmpty(tinggi)) {
            isEmpty = true;
            edtTinggi.setError(getString(R.string.is_empty));
        } else if (!isDouble(tinggi)) {
            inValidNumber = true;
            edtTinggi.setError(getString(R.string.valid_number));
        }
        //TODO 6 kalkulasi hitungan
        if (!isEmpty && !inValidNumber) {

            //parsing type data ke double dari string

            double p = Double.parseDouble(panjang);
            double l = Double.parseDouble(lebar);
            double t = Double.parseDouble(tinggi);

            //kalikan
            double result = p * l * t;

            //tampilkan dalam text view
            tvHasil.setText(String.valueOf(result));

        }

    }

    // TODO 5 create function / method untuk value double

    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }











}
