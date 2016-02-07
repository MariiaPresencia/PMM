package com.example.mariiasmiith.recopilatoriofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.*;
import android.view.*;

import com.example.mariiasmiith.recopilatoriofinal.PantallasFinales.Resultados;
import com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias.AcercaDe;
import com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias.DibujoApp;

public class MainActivity extends AppCompatActivity {
    public Button b1,b2,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button1);
        b4 = (Button)findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Clientes.class);
                startActivity(i);
            }
        });


        b2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent inte = new Intent(MainActivity.this,Registro.class);
                startActivity(inte);
            }
        });

        b4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent inten = new Intent(MainActivity.this,Resultados.class);
                startActivity(inten);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.opcion1:
                startActivity(new Intent(this,DibujoApp.class));
                return true;
            case R.id. opcion2:
                startActivity(new Intent(this,AcercaDe.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
