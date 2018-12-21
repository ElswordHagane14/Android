package com.example.maehendra14.pesonamalangraya;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity
{
    Button bthome, btfasilitas, btdeskripsi, btanggota, btwahana,btnmaps,bthelp;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button bthome = (Button) findViewById(R.id.bthome);
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnmaps = findViewById(R.id.btn_maps);

        btnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/KZ4ovExZTcv"));
                startActivity(i);
            }
        });

        Button btfasilitas = (Button) findViewById(R.id.btfasilitas);
        btfasilitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, FasilitasActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btdeskripsi = (Button) findViewById(R.id.btdesc);
        btdeskripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, DeskripsiActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btanggota = (Button) findViewById(R.id.btanggota);
        btanggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, AnggotaActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btwahana = (Button) findViewById(R.id.btwahana);
        btwahana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, WahanaActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
