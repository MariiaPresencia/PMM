package com.example.mariiasmiith.recopilatoriofinal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;


public class Usuarios extends AppCompatActivity{

    public Spinner mySpinner;
    public TextView t1,t2,t3;
    public Button b1 , b2;
    String t,t4,t5;

    private Usuarios1[] usuario = new Usuarios1[]{
        
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_usuarios);




        class AdaptadorUsuario extends ArrayAdapter<Usuarios1> {
            public Activity AdaptadorUsu;
            public AdaptadorUsuario(Activity AdaptadorUsu) {
                super(AdaptadorUsu, R.layout.spinner_lista_usu, usuario);
                this.AdaptadorUsu = AdaptadorUsu;
            }
            public View getDropDownView (int position, View convertView, ViewGroup parent) {
                View vistaDesplegada = getView(position, convertView, parent);
                return vistaDesplegada;
            }
            public  View getView (int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = AdaptadorUsu.getLayoutInflater();
                View item=inflater.inflate(R.layout.spinner_lista_usu, null);
                t1 = (TextView) item.findViewById(R.id.usu);
                t2 = (TextView) item.findViewById(R.id.direccion);
                t3 = (TextView) item.findViewById(R.id.email);

                t1.setText(usuario[position].getUsuario());
                t2.setText(String.valueOf(usuario[position].getDireccion()));
                t3.setText(String.valueOf(usuario[position].getEmail()));

                return item;
            }

        }

        mySpinner = (Spinner) findViewById(R.id.myspinner);
        AdaptadorUsuario adaptador = new AdaptadorUsuario(this);
        mySpinner.setAdapter(adaptador);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                t = usuario[position].getUsuario();
                t4 = usuario[position].getDireccion();
                t5 = usuario[position].getEmail();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                t = "No ha seleccionado ningun ordenador";
            }
        });
    }


}
