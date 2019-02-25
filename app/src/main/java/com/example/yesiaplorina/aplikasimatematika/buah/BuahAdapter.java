package com.example.yesiaplorina.aplikasimatematika.buah;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yesiaplorina.aplikasimatematika.R;

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.ViewHolder> {

    //deklarasi Context untuk penegasan bahwa kita berada dalam sebuah class BuahAdapter

    Context ctx;

    String namaBuah[] = {
            "Alpukat",
            "Apel",
            "Ceri",
            "Durian",
            "Jambu Air",
            "Manggis",
            "Strawberry"
    };

    int imagesBuah[] = {
            R.drawable.alpukat,
            R.drawable.apel,
            R.drawable.ceri,
            R.drawable.durian,
            R.drawable.jambuair,
            R.drawable.manggis,
            R.drawable.strawberry
    };

    //construktor

    public BuahAdapter(Context ctx) {
        this.ctx = ctx;
    }

    /**
     * function ini digunakan untuk menyisipkan sebuah layout
     * untuk menampung konten yang akan ditampilkan dalam recyclerview
     */

    @NonNull
    @Override
    public BuahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_buah, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    /**
     * function ini digunakan untuk set datanya kedalam contentnya
     * dan untuk get datanya sesuai dengan indexnya
     */

    @Override
    public void onBindViewHolder(@NonNull BuahAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvBuah.setText(namaBuah[i]);
        viewHolder.ivBuah.setImageResource(imagesBuah[i]);
    }

    /**
     * function ini digunakan untuk return data yang akan ditampilkan /looping
     */

    @Override
    public int getItemCount() {
        return imagesBuah.length;
    }

    /**
     * class ini digunakan untuk mendeklarasikan widget yang ingin digunakan
     */

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBuah;
        TextView tvBuah;

        //casting view/hubungkan dengan id masing-masing

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivBuah = itemView.findViewById(R.id.iv_buah);
            tvBuah = itemView.findViewById(R.id.tv_buah);
        }
    }
}
