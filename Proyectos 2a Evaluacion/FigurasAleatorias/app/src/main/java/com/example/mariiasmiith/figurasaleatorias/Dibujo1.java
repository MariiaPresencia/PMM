package com.example.mariiasmiith.figurasaleatorias;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Dibujo1 extends Activity {
    private static RandomDibujo rDibujo;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo1);
        rDibujo = (RandomDibujo) findViewById(R.id.drawing_area);
    }

    /**
     * Handles events for the button. Redraws the ShapeView.
     */
    public void redraw(View clickedButton) {
        rDibujo.invalidate();
    }
}
