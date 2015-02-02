package com.compostela.curso.preferencias;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PreferenciasManualActivity extends ActionBarActivity implements View.OnClickListener {
    public static final String KEY_PREFIJO = "prefijo";
    public static final String KEY_SUFIJO = "sufijo";
    public static final String DEFAULT_PREFIJO = "Hola ";
    public static final String DEFAULT_SUFIJO = " !!!!!!!!";
    private EditText tp;
    private EditText ts;
    private SharedPreferences preferences = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Establecer Layout
        setContentView(R.layout.activity_preferencias_manual);
        //Referenciar componentes visuales a manejar
        tp = (EditText)findViewById(R.id.txtPrefijo);
        ts = (EditText)findViewById(R.id.txtSufijo);
        Button btn = (Button)findViewById(R.id.btnGuardar);
        //Establecer los valores de los componentes visuales
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        tp.setText(preferences.getString(KEY_PREFIJO, DEFAULT_PREFIJO));
        ts.setText(preferences.getString(KEY_SUFIJO, DEFAULT_SUFIJO));

        //Establecer los Listeners de los eventos
        btn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferencias_manual, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        final SharedPreferences.Editor edit = preferences.edit();
        edit.putString(KEY_PREFIJO, tp.getText().toString());
        edit.putString(KEY_SUFIJO, ts.getText().toString());
        edit.commit();

    }
}
