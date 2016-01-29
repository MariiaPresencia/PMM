package com.example.mariiasmiith.recopilatoriomariapresencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainRecopilatorio extends AppCompatActivity {

    public Spinner mySpinner;
    private farmacos[] farmaco = new farmacos[
            new farmacos("Aspirina",3.4,R.drawable.aspirina),
            new farmacos("Ibuprofeno",4.6,R.drawable.ibuprofeno),
            new farmacos("Flumucil", 6.7,R.drawable.flumucil);
    ]
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recopilatorio);
    }
}
