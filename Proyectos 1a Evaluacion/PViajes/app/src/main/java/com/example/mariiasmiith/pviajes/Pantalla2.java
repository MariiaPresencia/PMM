package com.example.mariiasmiith.pviajes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MariiaSmiith on 8/11/15.
 */
public class Pantalla2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        final TextView otroSaludo1= (TextView)findViewById(R.id.miMensaje1);
        final TextView otroSaludo2= (TextView)findViewById(R.id.miMensaje2);
        final TextView otroSaludo3= (TextView)findViewById(R.id.miMensaje3);
        final ImageView imagen = (ImageView)findViewById(R.id.imageView2);

        Bundle  miBundleRecoger = getIntent().getExtras();
        otroSaludo1.setText(miBundleRecoger.getString("ZONA"));
        otroSaludo2.setText(miBundleRecoger.getString("PESO"));
        otroSaludo3.setText(miBundleRecoger.getString("SELECCION"));
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        imagen.setBackgroundDrawable(getResources().getDrawable(miBundleRecoger.getInt("IMAGEN")));


        final Button miButton = (Button)findViewById(R.id.botonVolver);
        miButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent miIntent = new Intent(Pantalla2.this,MainActivity.class);
                startActivity(miIntent);
            }
        });
    }
}
