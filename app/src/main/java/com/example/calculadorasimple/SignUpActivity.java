package com.example.calculadorasimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText username, password;

    Button singup;

    ImageButton close;

    public static String SESSION_KEY = "sesion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findViewById(R.id.cb_keep_session).setVisibility(View.GONE);
        findViewById(R.id.login_btn).setVisibility(View.GONE);

        singup = findViewById(R.id.sing_up_btn);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);

        close = findViewById(R.id.btn_close);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shouldSignUp()) {
                    SharedPreferences preferences = getSharedPreferences(SESSION_KEY, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString(username.getText().toString(), password.getText().toString());
                    editor.apply();
                    Log.i("user", "Creamos el usuario username : " + username.getText().toString() + ", password: " + password.getText().toString());
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Completa los datos", Toast.LENGTH_LONG).show();
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                // PODRÍA SER TAMBIEN
//                onBackPressed();
            }
        });



    }

    private Boolean shouldSignUp() {
        String usr = username.getText().toString();
        String pass = password.getText().toString();

        if (!usr.equals("") && !pass.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}