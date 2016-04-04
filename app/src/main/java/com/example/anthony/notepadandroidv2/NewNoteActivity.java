package com.example.anthony.notepadandroidv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewNoteActivity extends AppCompatActivity {

    protected EditText inputTitre;
    protected EditText inputVille;
    protected EditText inputContenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newnote);
        inputTitre = (EditText)findViewById(R.id.zoneTitre);
        inputVille = (EditText)findViewById(R.id.zoneVille);
        inputContenu = (EditText)findViewById(R.id.zoneTexte);
    }


    public void enregistrer(View view){
        /**
         * verifier que l'on a bien rempli tout les champs
         *
         * ajouter la note dans la bd
         */
        String titre = inputTitre.getText().toString(); //TODO recuperer le contenu des inputs dans le xml
        String ville = inputVille.getText().toString();
        String contenu = inputContenu.getText().toString();
        Calendar cal = Calendar.getInstance(); //TODO recuperer la date presente
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = format1.format(cal.getTime());

        if(!titre.equals("") && !ville.equals("") && !contenu.equals("")){
            Log.v("Titre: ", titre);
            Log.v("Ville: ", ville);
            Log.v("Contenu: ", contenu);
            Log.v("Date: ", date);
            //TODO recuper coordonnees gps

            //TODO ajouter dans la base la nouvelle note
            Note note = new Note(titre, contenu, date,ville);

            //TODO revenir a MainActivity
        }
        else{
            //TODO afficher un message d'erreur
        }
    }

    public void annuler(View view){
        /**
         * revenir a l'activite precedente
         */
        //TODO revenir a MainActivity
    }
}
