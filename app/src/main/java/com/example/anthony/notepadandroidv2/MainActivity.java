package com.example.anthony.notepadandroidv2;

//Accueil de l'application


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*//creation de la BD et ouverture en ecriture
        SQLiteDatabase db = NotesDBOpenHelper.getNoteBDOpenHelper(getBaseContext()).getWritableDatabase();

        //creation de valeurs
        //note 1
        ContentValues values1 = new ContentValues();
        values1.put(NotesDBOpenHelper.COLUMN_TITRE, "Note 1");
        values1.put(NotesDBOpenHelper.COLUMN_CONTENU, "Voici une premiere note");
        values1.put(NotesDBOpenHelper.COLUMN_DATE, "25/03/2016");

        //note 2
        ContentValues values2 = new ContentValues();
        values2.put(NotesDBOpenHelper.COLUMN_TITRE, "Note 2");
        values2.put(NotesDBOpenHelper.COLUMN_CONTENU, "Voici une deuxieme note");
        values2.put(NotesDBOpenHelper.COLUMN_DATE, "25/03/2016");

        //note 3
        ContentValues values3 = new ContentValues();
        values3.put(NotesDBOpenHelper.COLUMN_TITRE, "Note 3");
        values3.put(NotesDBOpenHelper.COLUMN_CONTENU, "Voici une troisieme note");
        values3.put(NotesDBOpenHelper.COLUMN_DATE, "25/03/2016");

        //insert in DB
        long id = db.insert(NotesDBOpenHelper.DATABASE_TABLE, null, values1);
        id = db.insert(NotesDBOpenHelper.DATABASE_TABLE, null, values2);
        id = db.insert(NotesDBOpenHelper.DATABASE_TABLE, null, values3);

        String[] allColums = {NotesDBOpenHelper.COLUMN_TITRE, NotesDBOpenHelper.COLUMN_CONTENU, NotesDBOpenHelper.COLUMN_DATE};

        //Explorer la BD
        Cursor cursor = db.query(NotesDBOpenHelper.DATABASE_TABLE, allColums, null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Button bouton = new Button(this);
            bouton.setText(cursor.getString(0));
        }*/
        Date date = new Date();
        Notes note1 = new Notes("note 1", "Ceci est une premeire note", date);
        Notes note2 = new Notes("note 2", "Deuxieme note", date);


    }
}
