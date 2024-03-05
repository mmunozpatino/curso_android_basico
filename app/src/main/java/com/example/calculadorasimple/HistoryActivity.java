package com.example.calculadorasimple;

import static androidx.activity.result.contract.ActivityResultContracts.*;

import static com.example.calculadorasimple.CalculadoraActivity.KEY_OPERADOR_1;
import static com.example.calculadorasimple.CalculadoraActivity.KEY_OPERADOR_2;
import static com.example.calculadorasimple.CalculadoraActivity.KEY_RESULTADO;
import static com.example.calculadorasimple.CalculadoraActivity.RESULTADO_SUMA_OK;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.calculadorasimple.historyList.Operation;
import com.example.calculadorasimple.historyList.OperationAdapter;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView miListaDeHistorico;

    OperationAdapter operacionesAdapter;

    ImageButton botonSumar;


    ActivityResultLauncher<Intent> iniciadorCalculadora = registerForActivityResult(
            new StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult resultado) {
                    // escucho
                    if (resultado.getResultCode() == Activity.RESULT_CANCELED) {
                        Log.i("ActivityResult", " onActivityResult CANCELED");
                    }
                    if (resultado.getResultCode() == RESULTADO_SUMA_OK) {
                        Operation sumaNueva = new Operation();
                        String operador1 = resultado.getData().getStringExtra(KEY_OPERADOR_1);
                        sumaNueva.setOperator1(operador1);
                        String operador2 = resultado.getData().getStringExtra(KEY_OPERADOR_2);
                        sumaNueva.setOperator2(operador2);
                        String resultadoNuevo = resultado.getData().getStringExtra(KEY_RESULTADO);
                        sumaNueva.setResult(resultadoNuevo);
                        Log.i("ActivityResult", "La suma nueva es : " + resultadoNuevo);
                        operacionesAdapter.agregarCalculoNuevo(sumaNueva);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        miListaDeHistorico = findViewById(R.id.list);
        botonSumar = findViewById(R.id.boton_sumar);

        // CONFIGURAMOS EL RECYCLERVIEW
        operacionesAdapter = new OperationAdapter();
        // uso la lista larga
//        operacionesAdapter.setList(crearLista());
        // arranco con una lista vacía
        operacionesAdapter.setList(new ArrayList<>());
        miListaDeHistorico.setAdapter(operacionesAdapter);
        // CONFIGURAMOS CÓMO SE ORDENA LA LISTA, VERTICALMENTE EN ESTE CASO
        RecyclerView.LayoutManager miLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        miListaDeHistorico.setLayoutManager(miLayoutManager);


        // ABRO LA CALCULADORA
        botonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCalculadora = new Intent(getApplicationContext(), CalculadoraActivity.class);
//                startActivity(intentCalculadora);
                iniciadorCalculadora.launch(intentCalculadora);
            }
        });
    }

    private List<Operation> crearLista() {
        ArrayList<Operation> operacionesLista = new ArrayList<>();
        operacionesLista.add(new Operation("5", "3", "2"));
        operacionesLista.add(new Operation("10", "5", "5"));
        operacionesLista.add(new Operation("5", "3", "2"));
        operacionesLista.add(new Operation("10", "5", "5"));
        operacionesLista.add(new Operation("5", "3", "2"));
        operacionesLista.add(new Operation("10", "5", "5"));
        operacionesLista.add(new Operation("5", "3", "2"));
        operacionesLista.add(new Operation("10", "5", "5"));
        operacionesLista.add(new Operation("5", "3", "2"));
        operacionesLista.add(new Operation("10", "5", "5"));
        operacionesLista.add(new Operation("5", "3", "2"));
        operacionesLista.add(new Operation("10", "5", "5"));
        operacionesLista.add(new Operation("5", "3", "2"));
        operacionesLista.add(new Operation("10", "5", "5"));
        operacionesLista.add(new Operation("5", "3", "2"));
        operacionesLista.add(new Operation("10", "5", "5"));
        operacionesLista.add(new Operation("5", "3", "2"));
        operacionesLista.add(new Operation("10", "5", "5"));

        return operacionesLista;
    }

}