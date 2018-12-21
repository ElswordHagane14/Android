package com.example.maehendra14.pesonamalangraya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeskripsiActivity extends AppCompatActivity {

    Button bthome, btfasilitas, btdeskripsi, btanggota, btwahana;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);

        textView = (TextView) findViewById(R.id.deskripsi_text);
        textView.setMovementMethod(new ScrollingMovementMethod());
        //menggunakan button yang terintent ke layout lain
        Button bthome = (Button) findViewById(R.id.bthome);
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeskripsiActivity.this, Home.class);
                startActivity(i);
                finish();
            }
        });

        Button btfasilitas = (Button) findViewById(R.id.btfasilitas);
        btfasilitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeskripsiActivity.this, FasilitasActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btanggota = (Button) findViewById(R.id.btanggota);
        btanggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeskripsiActivity.this, AnggotaActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btwahana = (Button) findViewById(R.id.btwahana);
        btwahana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DeskripsiActivity.this, WahanaActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
