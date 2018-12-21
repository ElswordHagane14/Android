package com.example.maehendra14.pesonamalangraya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.maehendra14.pesonamalangraya.adapter.FasilitasAdapter;
import com.example.maehendra14.pesonamalangraya.model.Fasilitas;

import java.util.ArrayList;
import java.util.List;

public class FasilitasActivity extends AppCompatActivity {

    Button bthome, btfasilitas, btdeskripsi, btanggota, btwahana;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<Fasilitas> mFasilities = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasilitas);
        button();

        mRecyclerView = (RecyclerView) findViewById(R.id.rvFasilitas);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        dummyData();
        mAdapter = new FasilitasAdapter(mFasilities,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void button(){
        Button bthome = (Button) findViewById(R.id.bthome);
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FasilitasActivity.this, Home.class);
                startActivity(i);
                finish();
            }
        });

        Button btdeskripsi = (Button) findViewById(R.id.btdesc);
        btdeskripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FasilitasActivity.this, DeskripsiActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btanggota = (Button) findViewById(R.id.btanggota);
        btanggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FasilitasActivity.this, AnggotaActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btwahana = (Button) findViewById(R.id.btwahana);
        btwahana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FasilitasActivity.this, WahanaActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void dummyData() {
        Fasilitas fasilitas= new Fasilitas(R.drawable.screenshot_2);
        mFasilities.add(fasilitas);

        fasilitas= new Fasilitas(R.drawable.screenshot_3);
        mFasilities.add(fasilitas);

        fasilitas= new Fasilitas(R.drawable.screenshot_4);
        mFasilities.add(fasilitas);

        fasilitas= new Fasilitas(R.drawable.screenshot_5);
        mFasilities.add(fasilitas);

        fasilitas= new Fasilitas(R.drawable.screenshot_6);
        mFasilities.add(fasilitas);

        fasilitas= new Fasilitas(R.drawable.screenshot_7);
        mFasilities.add(fasilitas);

        fasilitas= new Fasilitas(R.drawable.screenshot_8);
        mFasilities.add(fasilitas);
    }
}
