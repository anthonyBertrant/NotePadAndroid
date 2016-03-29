package com.example.anthony.notepadandroidv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newnote);
    }


    protected void enregistrer(){
        /**
         * verifier que l'on a bien rempli tout les champs
         *
         * ajouter la note dans la bd
         */
    }

    protected void annuler(){
        /**
         * revenir a l'activite precedente
         */
    }
}
