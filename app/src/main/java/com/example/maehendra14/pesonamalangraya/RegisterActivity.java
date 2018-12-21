package com.example.maehendra14.pesonamalangraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity
{
    DataHelperLogin dbHelper;
    Button btn_register;
    EditText username,password,retypepassword;
    String user,pass,retypepass;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DataHelperLogin(this);

        username = (EditText) findViewById(R.id.editTextUsername);
        password = (EditText) findViewById(R.id.editTextPassword);
        retypepassword = (EditText) findViewById(R.id.editTextPasswordRetype);

        btn_register = (Button) findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                user = username.getText().toString();
                pass = password.getText().toString();
                retypepass = retypepassword.getText().toString();

                if (user.equals("") || pass.equals("") || retypepass.equals("")) //mengecek apakah field sudah diisi
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty!", Toast.LENGTH_LONG).show();
                }
                else
                    {
                    if (pass.equals(retypepass)) //cek password sama dengan retrypassword
                    {
                        Boolean userExist = dbHelper.isUsernameExist(user);
                        if (userExist == true) //cek username sudah atau belum ada agar bisa digunakan
                        {
                            Boolean insert = dbHelper.insert(user,pass);
                            if (insert == true)
                            {
                                Toast.makeText(getApplicationContext(), "Registration Success!", Toast.LENGTH_LONG).show(); //notifikasi registrasi berhasil
                                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }
                        else
                            {
                            Toast.makeText(getApplicationContext(), "Username already exist!", Toast.LENGTH_LONG).show(); //notifikasi username sudah terpakai/sudah ada
                            }
                    }
                    else
                        {
                        Toast.makeText(getApplicationContext(), "Password doesn't match !", Toast.LENGTH_LONG).show();
                        }
                }
            }
        });
    }
}
