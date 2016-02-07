package com.example.mariiasmiith.recopilatoriofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.*;
import com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias.ModificacionUsuario;
import com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias.Pedir;

public class MainClientes extends AppCompatActivity {
    int id;
    String nombre, titulo;
    TextView t1;
    Button b1 , b2 , b3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_clientes);

        Bundle recogido = getIntent().getExtras();
        id = recogido.getInt("ID");
        nombre = recogido.getString("CLIENTE");



        titulo = "Hola "+nombre+".Bienvenido";
        t1 = (TextView)findViewById(R.id.tit);
        b1 = (Button)findViewById(R.id.buttonMod);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.buttonListar);

        t1.setText(titulo);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle envio = new Bundle();
                envio.putInt("IDCLIENTE", id);
                Intent i = new Intent(MainClientes.this, Pedir.class);
                i.putExtras(envio);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainClientes.this,ModificacionUsuario.class);
                startActivity(in);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
