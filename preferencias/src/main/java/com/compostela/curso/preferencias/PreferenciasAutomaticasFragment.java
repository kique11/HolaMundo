package com.compostela.curso.preferencias;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by mañá on 02/02/2015.
 */
public class PreferenciasAutomaticasFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferencias);
    }
}
