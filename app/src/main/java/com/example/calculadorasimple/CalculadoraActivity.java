package com.example.calculadorasimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    EditText num1, num2;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // NO TENGO ACCESO AL XML
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("mechi", "CalculadoraActivity onCreate");

        // TENGO ACCESO AL XML
        boton = findViewById(R.id.boton);
        num1 = findViewById(R.id.primer_numero);
        num2 = findViewById(R.id.segundo_numero);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ESTO SE EJECUTA AL CLICK
                Integer suma;
                Integer num1int = Integer.parseInt(num1.getText().toString());
                Integer num2int = Integer.parseInt(num2.getText().toString());
                suma = num1int + num2int;
                Toast.makeText(getApplicationContext(), "El resultado de la suma es " + suma.toString(), Toast.LENGTH_LONG).show();
                boton.setText(getResources().getText(R.string.boton_listo));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("mechi", "CalculadoraActivity onDestroy");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("mechi", "CalculadoraActivity onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("mechi", "CalculadoraActivity onPause");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("mechi", "CalculadoraActivity onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("mechi", "CalculadoraActivity onStart");

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("mechi", "CalculadoraActivity onRestart");
    }

}