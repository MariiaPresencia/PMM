package com.example.mariiasmiith.recopilatoriofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.*;

import com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias.MiCuenta;
import com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias.Pedir;
import com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias.Resultados;

public class MainClientes extends AppCompatActivity {
    int id;
    String nombre, titulo;
    TextView t1;
    Button b1 , b2 , b3 , b4;

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
        b4 = (Button)findViewById(R.id.buttonCerrar);

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
                Intent in = new Intent(MainClientes.this,MiCuenta.class);
                Bundle envio2 = new Bundle();
                envio2.putInt("IDC",id);
                envio2.putString("Nombre", nombre);
                in.putExtras(envio2);
                startActivity(in);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(MainClientes.this, Resultados.class);
                Bundle envio1 = new Bundle();
                envio1.putString("NOMBRE",nombre);
                envio1.putInt("IDC",id);
                inte.putExtras(envio1);
                startActivity(inte);
            }

        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainClientes.this,MainActivity.class);
                startActivity(i1);
            }
        });

    }
}
