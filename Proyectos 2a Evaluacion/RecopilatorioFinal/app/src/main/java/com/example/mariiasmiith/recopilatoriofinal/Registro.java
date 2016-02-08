package com.example.mariiasmiith.recopilatoriofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.widget.*;
import android.database.sqlite.SQLiteDatabase;
import android.content.*;
import android.view.*;
import android.app.*;
import com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias.MiCuenta;

public class Registro extends AppCompatActivity {

    EditText e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_registro);
        final Button b1 = (Button) findViewById(R.id.button4);
        e1 = (EditText) findViewById(R.id.usua1);
        e2 = (EditText) findViewById(R.id.dir1);
        e3 = (EditText) findViewById(R.id.correo1);
        e4 = (EditText) findViewById(R.id.contra1);

        //al pulsar el boton llama al metodo insetar con los datos escritos
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usu = e1.getText().toString();
                String dir = e2.getText().toString();
                String cor = e3.getText().toString();
                String con = e4.getText().toString();




                insertarUsuario(usu, dir, cor, con);

                Intent in = new Intent(Registro.this,MainActivity.class);
                startActivity(in);
            }
        });

    }

    //metodo para introducir los datos del EditText en la Tabla de la base de datos
    public void insertarUsuario(String usuario, String direccion, String email, String contrasenya) {

        BaseDeDatos ad = new BaseDeDatos(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = ad.getWritableDatabase();

        ContentValues registro = new ContentValues();


        registro.put("usuario", usuario);
        registro.put("direccion", direccion);
        registro.put("email", email);
        registro.put("contrasenya", contrasenya);

        db.insert("clientes", null, registro);

        db.close();




        Toast.makeText(this, "Creado correctamente", Toast.LENGTH_SHORT).show();


    }
}