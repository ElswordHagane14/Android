package com.example.maehendra14.pesonamalangraya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
{
    Button btnlogout, btnjtp1, btMaps, btnedit;
    ImageView iv1;
    Intent i;
    SessionManagement sessionManagement;
    private final int requestCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = (ImageView)findViewById(R.id.iv1);
        String imageUri = "https://yt3.ggpht.com/a-/AN66SAwj4DQetslcEvvmmzUXrUEaZ3rYMLX6yhKOpw=s900-mo-c-c0xffffffff-rj-k-no";
        Picasso.with(this).load(imageUri).resize(100,100).into(iv1);
        Button btnlogout = (Button) findViewById(R.id.btnlogout);
        Button btnjtp1 = (Button) findViewById(R.id.btnjtp1);
        Button btMaps = (Button) findViewById(R.id.bt_baru);
        Button btnedit = (Button) findViewById(R.id.btneditbiodata);
        sessionManagement = new SessionManagement(this);

        Intent user = getIntent();
        final String username = user.getStringExtra("username");
        btMaps.setOnClickListener(new View.OnClickListener() { //cara membuat button untuk mengarah ke mapsActivity
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManagement.logoutUser();
                finish();
            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() { //cara membuat button untuk mengarah ke mapsActivity
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EditBiodata.class);
                i.putExtra("username",username);
                startActivity(i);
                finish();
            }
        });

        btnjtp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Home.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //maps
        btMaps = (Button) findViewById(R.id.bt_baru);

        btMaps.setOnClickListener(new View.OnClickListener() { //cara membuat button untuk mengarah ke mapsActivity
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
