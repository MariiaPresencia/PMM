package com.example.mariiasmiith.mpresencia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AnalogClock;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MariiaSmiith on 9/11/15.
 */
public class Pantalla2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        final TextView otroSaludo1= (TextView)findViewById(R.id.miMensaje1);
        final TextView otroSaludo2= (TextView)findViewById(R.id.miMensaje2);
        final TextView otroSaludo3= (TextView)findViewById(R.id.miMensaje3);
        final TextView otroSaludo4= (TextView)findViewById(R.id.miMensaje4);
        final TextView otroSaludo5= (TextView)findViewById(R.id.miMensaje5);
        final ImageView imagen = (ImageView)findViewById(R.id.imageView2);
        final AnalogClock c1 = (AnalogClock)findViewById(R.id.analogClock);

        Bundle  miBundleRecoger = getIntent().getExtras();
        otroSaludo1.setText(miBundleRecoger.getString("PIZZA"));
        otroSaludo2.setText(miBundleRecoger.getString("PRECIO"));
        otroSaludo3.setText(miBundleRecoger.getString("EXTRA"));
        otroSaludo4.setText(miBundleRecoger.getString("UNIDAD"));
        otroSaludo5.setText(miBundleRecoger.getString("SELECCION"));
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        imagen.setBackgroundDrawable(getResources().getDrawable(miBundleRecoger.getInt("IMAGEN")));

    }
}
