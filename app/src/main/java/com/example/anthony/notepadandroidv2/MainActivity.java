package com.example.anthony.notepadandroidv2;

//Accueil de l'application


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        Button[] mesBouton = new Button[5];
        for(int index = 0; index < 5; index++){
            mesBouton[index] = new Button(this);
            mesBouton[index].setText("Button# " + index);

        }*/


    }

    public void createNewNote(View view){
        //TODO creer une nouvelle note
        Intent intent = new Intent(this, NewNoteActivity.class);
        startActivity(intent);
    }
}
