package com.example.maehendra14.pesonamalangraya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.maehendra14.pesonamalangraya.adapter.WahanaAdapter;
import com.example.maehendra14.pesonamalangraya.model.Wahana;

import java.util.ArrayList;
import java.util.List;

public class WahanaActivity extends AppCompatActivity {

    Button bthome, btfasilitas, btdeskripsi, btanggota, btwahana;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<Wahana> mWahanas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wahana);

        button();
        mRecyclerView = (RecyclerView) findViewById(R.id.rvWahana);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        dummyData();
        mAdapter = new WahanaAdapter(mWahanas,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void button(){
        Button bthome = (Button) findViewById(R.id.bthome);
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WahanaActivity.this, Home.class);
                startActivity(i);
                finish();
            }
        });

        Button btfasilitas = (Button) findViewById(R.id.btfasilitas);
        btfasilitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WahanaActivity.this, FasilitasActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btdeskripsi = (Button) findViewById(R.id.btdesc);
        btdeskripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WahanaActivity.this, DeskripsiActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btanggota = (Button) findViewById(R.id.btanggota);
        btanggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WahanaActivity.this, AnggotaActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void dummyData() {
        Wahana fasilitas= new Wahana(R.drawable.hallentrance,getString(R.string.title_hallentrance),getString(R.string.whn_hallentrance));
        mWahanas.add(fasilitas);

        fasilitas= new Wahana(R.drawable.hallfame,getString(R.string.title_hallfame),getString(R.string.whn_hallfame));
        mWahanas.add(fasilitas);

        fasilitas= new Wahana(R.drawable.science,getString(R.string.title_science),getString(R.string.whn_science));
        mWahanas.add(fasilitas);

        fasilitas= new Wahana(R.drawable.checkup,getString(R.string.title_medical),getString(R.string.whn_medical));
        mWahanas.add(fasilitas);

        fasilitas= new Wahana(R.drawable.cadavar,getString(R.string.title_cadaver),getString(R.string.whn_cadaver));
        mWahanas.add(fasilitas);

        fasilitas= new Wahana(R.drawable.zonatubuh,getString(R.string.title_zona),getString(R.string.whn_zona));
        mWahanas.add(fasilitas);
    }

}
