package com.example.mariiasmiith.listatitulares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.*;
import android.view.*;

public class main_titular extends AppCompatActivity {

    ListView listView;
    final static String semana[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_titular);
        String mensaje;
        listView = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, semana);
        listView.setAdapter(miAdaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "";
                mensaje = "Item seleccionado " + semana[position];
                showToast(mensaje);

            }
        });
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }


}
