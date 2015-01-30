package com.compostela.curso.holamundo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.ConnectionReuseStrategy;


public class MainActivity extends ActionBarActivity {
    public static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se crea el árbol de objetos que representa la vista
        setContentView(R.layout.activity_main);

        //Referencia al objeto. Debe ir siempre después del método anterior
        Button v = (Button)findViewById(R.id.bt_navegar);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                intent.putExtra("dato", "kq");
               startActivity(intent);//Es un método de la clase externa. MainActivity.this.startActivity()
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void abrirSecundaria(View view) {
        Intent intent = new Intent(this, ConResultadoActivitiy.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        String dato = "";
        switch(requestCode){
            case REQUEST_CODE:
                if(resultCode == Activity.RESULT_OK) {
                    dato = data.getStringExtra("dato");
                    Toast.makeText(this, "Valor: " + dato, Toast.LENGTH_LONG).show();
                }
                break;
            default:
                Toast.makeText(this, "salida defecto", Toast.LENGTH_SHORT).show();

        }
    }
}
