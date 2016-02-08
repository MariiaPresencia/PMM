package com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.mariiasmiith.recopilatoriofinal.R;


public class MiCuenta extends AppCompatActivity {
    int idCliente;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_micuenta);
        Bundle reco = getIntent().getExtras();
        idCliente = reco.getInt("ID");

    }
}
