package com.example.calculadorasimple;

import static com.example.calculadorasimple.LoginActivity.KEEP_KEY;
import static com.example.calculadorasimple.LoginActivity.SESSION_KEY;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class LandingActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        logo = findViewById(R.id.logo);

        logo.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        goToHistory();
                                    }
                                });
        login();
    }

    private void login() {
        // TODO vamos a pasar a la calculadora si ya tengo sesion activa
        SharedPreferences preferences = getSharedPreferences(SESSION_KEY, Context.MODE_PRIVATE);
        Boolean keep = preferences.getBoolean(KEEP_KEY, false);
        Log.i("preferences", "Estoy leyendo del preferences " + keep);

        if (keep) {
            // Pasar de largo a la pantalla de calculadora
            goToHistory();
        } else {
            // Me voy a quedar en la pantalla de login, no hago nada
            goToLogin();
        }
    }

    private void goToHistory() {
        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
        startActivity(intent);
    }

    private void goToLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}