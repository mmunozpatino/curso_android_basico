package com.example.calculadorasimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    Integer count = 0;

    Boolean close = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("mechi", "LoginActivity OnClick");
//                Intent intent = new Intent(getApplicationContext(), CalculadoraActivity.class);
//                startActivity(intent);
                close= true;
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Log.i("mechi", "LoginActivity onBackPressed, count: " + count);
        if (close) {
            super.onBackPressed();
        } else {
            Toast.makeText(getApplicationContext(), "apreta en login", Toast.LENGTH_LONG).show();
//            count ++;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("mechi", "LoginActivity onDestroy");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("mechi", "LoginActivity onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("mechi", "LoginActivity onPause");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("mechi", "LoginActivity onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("mechi", "LoginActivity onStart");

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("mechi", "LoginActivity onRestart");
    }
}