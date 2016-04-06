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
    Note oldNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newnote);
        inputTitre = (EditText)findViewById(R.id.zoneTitre);
        inputVille = (EditText)findViewById(R.id.zoneVille);
        inputContenu = (EditText)findViewById(R.id.zoneTexte);
        oldNote = (Note)getIntent().getSerializableExtra(MainActivity.EXTRA_MSG_NOTE);
        if(oldNote != null){
            inputTitre.setText(oldNote.getTitre());
            inputVille.setText(oldNote.getVille());
            inputContenu.setText(oldNote.getContenu());
        }
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
            //TODO recuper coordonnees gps

            Note note = null;

            NoteDB noteDB = new NoteDB(getApplicationContext());

            //si on creer une note
            if(oldNote == null) {
                note = new Note(titre, contenu, date,ville);
                //on ajoute dans la base la nouvelle note
                noteDB.addNewNote(note);
            }
            //sinon si on edite une note existante
            else if(oldNote.getId() >= 0){
                note = new Note(oldNote.getId(), titre, contenu, date, ville);
                //on met a jour la note
                noteDB.updateNote(note);
            }

            //revenir a MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            //TODO afficher un message d'erreur
            Toast toast = Toast.makeText(getApplicationContext(), "Mauvaise saisie...", Toast.LENGTH_SHORT);
            toast.show();
        }
        finish();
    }//enregistrer(View view)

    public void annuler(View view){
        /**
         * revenir a l'activite precedente
         */
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }//annuler(View view)
}
