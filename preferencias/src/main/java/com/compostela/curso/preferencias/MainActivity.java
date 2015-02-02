package com.compostela.curso.preferencias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias a Views
        final View saludar = findViewById(R.id.btnSaludar);

        saludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombre = (EditText) findViewById(R.id.txtNombre);

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String saludo = preferences.getString(getResources().getString(R.string.key_prefijo ), "")
                        + nombre.getText().toString()
                        + preferences.getString(getResources().getString(R.string.key_sufijo), "");

                Toast.makeText(MainActivity.this, saludo, Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = null;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            intent = new Intent(this, PreferenciasManualActivity.class);

        }else if(id==R.id.action_settingsauto){
            intent = new Intent(this, PreferenciasAutomaticasActivity.class);
        }
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}
