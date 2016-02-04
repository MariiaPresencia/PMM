package com.example.mariiasmiith.recopilatoriofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.*;


public class BaseDeDatos extends SQLiteOpenHelper{
    String tablaUsuarios = "CREATE TABLE 'clientes' (" +
            //"  id INTEGER NOT NULL PRIMARY KEY,"+
            "  'usuario' TEXT NOT NULL UNIQUE," +
            "  'direccion' TEXT NOT NULL,"+
            "  'email' TEXT NOT NULL,"+
            "  'contrasenya' TEXT NOT NULL,"+
            "  );";

    String createPedidos = "CREATE TABLE IF NOT EXISTS pedidos (" +
            "  id INTEGER NOT NULL PRIMARY KEY," +
            "  usuarioIdentificador TEXT NOT NULL," +
            "  farmaco TEXT NOT NULL," +
            "  dosis TEXT NOT NULL," +
            "  extra TEXT NOT NULL," +
            "  unidades INTEGER NOT NULL," +
            "  precio INTEGER NOT NULL," +
            "  imagen INTEGER NOT NULL," +
            "   FOREIGN KEY(usuarioIdentificador) REFERENCES clientes(id) ON DELETE CASCADE" +
            "  );";

    public BaseDeDatos(Context contexto, String nombreBD, CursorFactory basededatos, int version){
        super(contexto, nombreBD, basededatos, version);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaUsuarios);
        //db.execSQL(createPedidos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Eliminamos la version anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS 'clientes'");
        //db.execSQL("DROP TABLE IF EXISTS pedidos");
        //Creamos la nueva versi�n de la tabla
        db.execSQL(tablaUsuarios);
        //db.execSQL(createPedidos);
    }
}

