package com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mariiasmiith.recopilatoriofinal.BaseDeDatos;
import com.example.mariiasmiith.recopilatoriofinal.Clases.UsuariosCompleto;
import com.example.mariiasmiith.recopilatoriofinal.R;


public class MiCuenta extends AppCompatActivity {
    int id;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_micuenta);
        Bundle coger = getIntent().getExtras();
        id = coger.getInt("ID");
        mostrar();

    }
    UsuariosCompleto[] usuario;

    public void mostrar(){
        BaseDeDatos b = new BaseDeDatos(this, "DBUsuarios", null, 1);
        SQLiteDatabase bd = b.getReadableDatabase();
        if(bd != null) {
            Cursor c = bd.rawQuery("SELECT * FROM clientes WHERE id = "+id, null);
            int cont = c.getCount();
            int i = 0;
            usuario = new UsuariosCompleto[cont];
            if(c.moveToFirst()){
                do {
                    String nombre = c.getString(1);
                    String direccion = c.getString(2);
                    String correo = c.getString(3);
                    String contraseña = c.getString(4);

                    usuario[i] = new UsuariosCompleto(nombre,direccion,correo,contraseña);
                    i++;
                } while (c.moveToNext());
            }
            c.close();
            bd.close();
        }
    }
}
