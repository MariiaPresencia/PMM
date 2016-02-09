package com.example.mariiasmiith.recopilatoriofinal.PantallasSecundarias;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import android.content.*;
import com.example.mariiasmiith.recopilatoriofinal.BaseDeDatos;
import com.example.mariiasmiith.recopilatoriofinal.Clases.Usuarios1;
import com.example.mariiasmiith.recopilatoriofinal.Clases.UsuariosCompleto;
import com.example.mariiasmiith.recopilatoriofinal.MainClientes;
import com.example.mariiasmiith.recopilatoriofinal.R;


public class MiCuenta extends AppCompatActivity {
    int id;
    EditText t1 , t2 , t3 ,t4;
    String usur , dir , con, cor;
    Button b1 , b2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_micuenta);
        Bundle coger = getIntent().getExtras();
        id = coger.getInt("IDC");

        b1 = (Button) findViewById(R.id.button4);
        b2 = (Button)findViewById(R.id.button11);
        t1 = (EditText)findViewById(R.id.usua1);
        t2 = (EditText)findViewById(R.id.dir1);
        t3 = (EditText)findViewById(R.id.correo1);
        t4 = (EditText)findViewById(R.id.contra1);

        UsuariosCompleto[] usu = mostrar();

        for(UsuariosCompleto usu1 : usu){
            usur = usu1.getNombre();
            dir =  usu1.getDireccion();
            cor = usu1.getContraseña();
            con = usu1.getContraseña();
        }
        t1.setText(usur);
        t2.setText(dir);
        t3.setText(cor);
        t4.setText(con);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usur = t1.getText().toString();
                dir = t2.getText().toString();
                cor = t3.getText().toString();
                con = t4.getText().toString();
                modificarUsuario(usur,dir,cor,con);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MiCuenta.this, MainClientes.class);
                startActivity(i);
            }
        });
    }
    BaseDeDatos bd = new BaseDeDatos(this, "DBUsuarios", null, 1);

    UsuariosCompleto[] usuario;

    public void modificarUsuario(String usuario, String direccion, String email, String contrasenya){
        final SQLiteDatabase b = bd.getReadableDatabase();
        ContentValues c = new ContentValues();

        c.put("usuario", usuario);
        c.put("direccion", direccion);
        c.put("email", email);
        c.put("contrasenya", contrasenya);

        b.update("clientes",c,"id = "+id , null);

        b.close();
        Toast.makeText(this,"Cliente modificado",Toast.LENGTH_SHORT).show();
    }


    public UsuariosCompleto[] mostrar(){
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
        return usuario;
    }

}
