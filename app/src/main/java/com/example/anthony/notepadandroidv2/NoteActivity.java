package com.example.anthony.notepadandroidv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NoteActivity extends AppCompatActivity {

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
        String titre = inputTitre.getText().toString();
        String ville = inputVille.getText().toString();
        String contenu = inputContenu.getText().toString();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = format1.format(cal.getTime());

        if(!titre.equals("") && !ville.equals("") && !contenu.equals("")){
            Log.v("Titre: ", titre);
            Log.v("Ville: ", ville);
            Log.v("Contenu: ", contenu);
            Log.v("Date: ", date);

            //TODO recuper coordonnees gps


            Note note = new Note(titre, contenu, date,ville);

            //ajouter dans la base la nouvelle note
            NoteDBOpenHelper dbOpenHelper = NoteDBOpenHelper.getNoteBDOpenHelper(getApplicationContext());
            dbOpenHelper.addNewNote(note);

            //revenir a MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            //TODO afficher un message d'erreur
            Toast toast = Toast.makeText(getApplicationContext(), "Mauvaise saisie...", Toast.LENGTH_SHORT);
            toast.show();
        }
    }//enregistrer(View view)

    public void annuler(View view){
        /**
         * revenir a l'activite precedente
         */
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }//annuler(View view)
}
