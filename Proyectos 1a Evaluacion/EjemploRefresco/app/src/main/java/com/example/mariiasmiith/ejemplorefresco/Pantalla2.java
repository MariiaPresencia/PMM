package com.example.mariiasmiith.ejemplorefresco;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class Pantalla2 extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        final TextView saludo1 = (TextView)findViewById(R.id.miMensaje1);
        final TextView saludo2 = (TextView)findViewById(R.id.miMensaje2);
        final TextView saludo3 = (TextView)findViewById(R.id.miMensaje3);

        Bundle  miBundleRecoger = getIntent().getExtras();

        saludo1.setText(miBundleRecoger.getString("BEBIDA"));
        saludo2.setText(miBundleRecoger.getString("COMPLEMENTO"));
        saludo3.setText(miBundleRecoger.getString("VASO"));

        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));


        final Button miButton = (Button)findViewById(R.id.botonVolver);
        miButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent miIntent = new Intent(Pantalla2.this,MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}
