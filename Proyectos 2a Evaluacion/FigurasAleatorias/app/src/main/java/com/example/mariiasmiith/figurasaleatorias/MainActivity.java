package com.example.mariiasmiith.figurasaleatorias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchDibujo1(View clickedButton) {
        Intent activityIntent =
                new Intent(this, Dibujo1.class);
        startActivity(activityIntent);
    }
    public void launchDibujo2(View clickedButton) {
        Intent activityIntent =
                new Intent(this, Dibujo2.class);
        startActivity(activityIntent);
    }
    public void launchDibujo3(View clickedButton) {
        Intent activityIntent =
                new Intent(this, Dibujo3.class);
        startActivity(activityIntent);
    }
}
