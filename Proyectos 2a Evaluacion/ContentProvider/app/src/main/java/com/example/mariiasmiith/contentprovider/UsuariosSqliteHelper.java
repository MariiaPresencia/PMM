package com.example.mariiasmiith.contentprovider;

/**
 * Created by MariiaSmiith on 25/1/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSqliteHelper extends SQLiteOpenHelper{
    //Sentencia SQL para crear la tabla de Usuarios
    String sql = "CREATE TABLE Usuarios " +
            "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "usuario TEXT, " +
            "password TEXT, " +
            "email TEXT )";

    public UsuariosSqliteHelper(Context contexto, String nombre, CursorFactory almacen, int version) {
        super(contexto, nombre, almacen, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Ejecutamos la sentencia para crear la tabla
        db.execSQL(sql);

        //Introducimos 10 usuarios de ejemplo
        for (int i=1; i<=10; i++) {
            //Creamos los datos
            String usuario = "usuario" + i;
            String password = "passw" + i;
            String email = "email" + i + "@cefire.com";
            //Introducimos los datos en la tabla Usuarios
            db.execSQL("INSERT INTO Usuarios (usuario, password, email) " +
                    " VALUES ('" + usuario + "', '" + password + "', '" +
                    email + "')");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //Eliminamos la versiÛn anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        //Creamos la nueva versiÛn de la tabla
        db.execSQL(sql);
    }
}
