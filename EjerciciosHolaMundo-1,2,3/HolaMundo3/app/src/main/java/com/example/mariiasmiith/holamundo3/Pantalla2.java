package com.example.mariiasmiith.holamundo3;


import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo = (TextView)findViewById(R.id.miMensaje);
        final Button volverBtn = (Button)findViewById(R.id.miVolver);
        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));
        final String completarSaludo = miBundleRecoger.getString("TEXTO");
        volverBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent vueltaIntent = new Intent();
                Bundle vueltaBundle= new Bundle();
                String mensajeDevuelto = "Devuelvo a principal "+completarSaludo;
                vueltaBundle.putString("DEVUELTO ",mensajeDevuelto);
                vueltaIntent.putExtras(vueltaBundle);
                setResult(RESULT_OK,vueltaIntent);
                finish();
            }
        });
        }
}
