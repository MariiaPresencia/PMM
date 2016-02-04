package com.example.mariiasmiith.comunicacionesmariapresencia;

/**
 * Created by MariiaSmiith on 4/2/16.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Pagina extends AppCompatActivity {

    private EditText urlField;
    private TextView data;
    String link = "http://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlField = (EditText)findViewById(R.id.editText1);
        data = (TextView)findViewById(R.id.textView2);
    }


    public void download(View view){

        String url = "http://" + urlField.getText().toString();
        MainActivity paginaWeb=new MainActivity(this,data);

        paginaWeb.execute(url);
    }

}