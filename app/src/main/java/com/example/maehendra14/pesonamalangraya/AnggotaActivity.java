package com.example.maehendra14.pesonamalangraya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.maehendra14.pesonamalangraya.adapter.KomentarAdapter;
import com.example.maehendra14.pesonamalangraya.model.Komentar;

import java.util.ArrayList;
import java.util.List;

public class AnggotaActivity extends AppCompatActivity {

    Button bthome, btfasilitas, btdeskripsi, btanggota, btwahana;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<Komentar> mKomentars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anggota);

        Button();
        mRecyclerView = (RecyclerView) findViewById(R.id.rvKomentar);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        dummyData();
        mAdapter = new KomentarAdapter(mKomentars,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void Button() {
        Button bthome = (Button) findViewById(R.id.bthome);
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AnggotaActivity.this, Home.class);
                startActivity(i);
                finish();
            }
        });

        Button btfasilitas = (Button) findViewById(R.id.btfasilitas);
        btfasilitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AnggotaActivity.this, FasilitasActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btdeskripsi = (Button) findViewById(R.id.btdesc);
        btdeskripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AnggotaActivity.this, DeskripsiActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btwahana = (Button) findViewById(R.id.btwahana);
        btwahana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AnggotaActivity.this, WahanaActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    //data komentar
    private void dummyData() {
        Komentar komentar = new Komentar(getResources().getString(R.string.comment1));
        mKomentars.add(komentar);

        komentar = new Komentar(getResources().getString(R.string.comment2));
        mKomentars.add(komentar);

        komentar = new Komentar(getResources().getString(R.string.comment3));
        mKomentars.add(komentar);

        komentar = new Komentar(getResources().getString(R.string.comment4));
        mKomentars.add(komentar);

        komentar = new Komentar(getResources().getString(R.string.comment5));;
        mKomentars.add(komentar);

    }
}