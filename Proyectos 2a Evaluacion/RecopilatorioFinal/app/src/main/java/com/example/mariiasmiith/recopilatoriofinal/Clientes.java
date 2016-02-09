package com.example.mariiasmiith.recopilatoriofinal;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import android.widget.Button;
import android.database.sqlite.*;
import android.database.*;
import android.widget.*;

import com.example.mariiasmiith.recopilatoriofinal.Clases.Usuarios1;


public class Clientes extends AppCompatActivity{

    public EditText e1,e2;
    public Button b1;
    Usuarios1[] listaClientes;
    int id;
    String cliente3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_usuarios);

        e1 = (EditText)findViewById(R.id.usua1);
        e2 = (EditText)findViewById(R.id.contra1);
        b1 = (Button) findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cliente = e1.getText().toString();
                String contra = e2.getText().toString();

                Usuarios1[] cliente1 = clientes();

                boolean existe = false;

                for (Usuarios1 cliente2 : cliente1) {
                    if (cliente2.getUsuario().equals(cliente) && cliente2.getContraseña().equals(contra)) {
                        existe = true;
                        id = cliente2.getId();
                        cliente3 = cliente2.getUsuario();
                    }
                }
                comprobar(existe);

            }
        });

    }

    public void comprobar(boolean b){
        if(b == false) {
            Toast.makeText(this, "No se ha encontrado, registrate", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Clientes.this,Registro.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Existe", Toast.LENGTH_SHORT).show();
            Bundle mibundle = new Bundle();
            mibundle.putInt("ID", id);
            mibundle.putString("CLIENTE", cliente3);

            Intent in = new Intent(Clientes.this, MainClientes.class);
            in.putExtras(mibundle);
            startActivity(in);
        }

    }

    public Usuarios1[] clientes(){
        BaseDeDatos db = new BaseDeDatos(this, "DBUsuarios", null, 1);
        SQLiteDatabase bd = db.getReadableDatabase();

        Cursor c = bd.rawQuery("SELECT * FROM clientes", null);
        int contador = c.getCount();
        int i = 0;
        listaClientes = new Usuarios1[contador];

        if(c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String usu = c.getString(1);
                String contra = c.getString(4);

                listaClientes[i] = new Usuarios1(id, usu, contra);
                i++;
            } while (c.moveToNext());
        }
        c.close();
        bd.close();
        return listaClientes;
    }
}
