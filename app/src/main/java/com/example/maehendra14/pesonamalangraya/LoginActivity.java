package com.example.maehendra14.pesonamalangraya;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    ImageView gambar;
    EditText username,password;
    Button btn_login, btn_take;
    TextView btn_register;
    Intent i;
    DataHelperLogin dbHelper;
    Cursor cursor;
    SessionManagement sessionManagement;
    private final int requestCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DataHelperLogin(this);

        username = (EditText) findViewById(R.id.editTextUsername);
        password = (EditText) findViewById(R.id.editTextPassword);
        sessionManagement = new SessionManagement(this);
        btn_register = (TextView) findViewById(R.id.btn_register);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_take = (Button) findViewById(R.id.take_picture);

        if (sessionManagement.isLoggedIn())
        {
            goToActivity();
        }

        btn_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

        gambar = (ImageView) findViewById(R.id.capture);
        btn_take = (Button) findViewById(R.id.take_picture);

        btn_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, 1);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                Boolean login = dbHelper.checkLogin(user,pass);

                if (user.equals("") || pass.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty!", Toast.LENGTH_LONG).show();
                }
                else
                    {
                    if (login == true)
                    {
                        i = new Intent(getApplicationContext(),MainActivity.class);
                        i.putExtra("username",user);
                        sessionManagement.createLoginSession(user, pass);
                        goToActivity();
                        finish();
                    }
                    else
                        {
                            Toast.makeText(getApplicationContext(), "Username or password wrong!", Toast.LENGTH_LONG).show();
                        }

                }
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.requestCode == requestCode && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            gambar.setImageBitmap(bitmap);
        }
    }
    private void goToActivity() {
        Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
        mIntent.putExtra("username", username.getText().toString());
        mIntent.putExtra("password", username.getText().toString());
        startActivity(mIntent);
    }

}
