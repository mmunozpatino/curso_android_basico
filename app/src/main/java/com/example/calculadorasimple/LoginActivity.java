package com.example.calculadorasimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn, singupBtn;

    EditText username, password;
    Integer count = 0;

    CheckBox shouldKeepSession;

    Boolean close = false;

    public static String SESSION_KEY = "sesion";
    public static String KEEP_KEY = "keep";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_close).setVisibility(View.GONE);

        loginBtn = findViewById(R.id.login_btn);
        shouldKeepSession = findViewById(R.id.cb_keep_session);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);

        singupBtn = findViewById(R.id.sing_up_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.i("mechi", "LoginActivity OnClick");

                if (shouldLogin()) {
                    SharedPreferences preferences = getSharedPreferences(SESSION_KEY, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    Boolean keep = shouldKeepSession.isChecked();

                    editor.putBoolean(KEEP_KEY, keep);
                    editor.apply();
                    Log.i("preferences", "Estoy abriendo la calculadora, keepSession = " + keep);
                    // Acá navego a la calculadora
                    login();
                } else {
                    Toast.makeText(getApplicationContext(), "Completa los datos", Toast.LENGTH_LONG).show();
                }

//                close= true;
//                onBackPressed();
            }
        });

        singupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSingUp();
            }
        });
    }

    private void login() {
        SharedPreferences preferences = getSharedPreferences(SESSION_KEY, Context.MODE_PRIVATE);

        String realPassword = preferences.getString(username.getText().toString(), "");
        String currentPassword = password.getText().toString();

        Log.i("user", "Se logea usuario: " + username.getText().toString() + ", contraseña ingresada: " + currentPassword + ", contraseña guardado: " + realPassword);
        if (!realPassword.isEmpty() && realPassword.equals(currentPassword)) {
            goToCalculadora();
        } else {
            Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }
    }

    private void goToSingUp() {
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

    private Boolean shouldLogin() {
        String usr = username.getText().toString();
        String pass = password.getText().toString();

        if (!usr.equals("") && !pass.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    private void goToCalculadora() {
        Intent intent = new Intent(getApplicationContext(), CalculadoraActivity.class);
        startActivity(intent);
        // Saco del stack de activities esta, entonces al hacer back no vuelvo nunca a esta act
        finish();
    }

    @Override
    public void onBackPressed() {
//        Log.i("mechi", "LoginActivity onBackPressed, count: " + count);
//        if (close) {
            super.onBackPressed();
//        } else {
//            Toast.makeText(getApplicationContext(), "apreta en login", Toast.LENGTH_LONG).show();
////            count ++;
//        }
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