package com.compostela.curso.holamundo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SecondaryActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        String dato = getIntent().getExtras().getString("dato");

        TextView tv = (TextView)findViewById(R.id.lb_saludo);
        tv.setText(dato);
    }
}
