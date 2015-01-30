package com.compostela.curso.holamundo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

/**
 * Created by mañá on 29/01/2015.
 * Clase qeu podría pasarse al evento OnCLick ya que hereda de OnClickListener
 */
public class NavegacionOnClickListener implements View.OnClickListener {
    //Ejemplo e Inyección de Dependencias por COnstrtuctor

    private Activity activity;

    public NavegacionOnClickListener(Activity a){
        this.activity = a;
    }
    @Override
    public void onClick(View v) {
    }
}
