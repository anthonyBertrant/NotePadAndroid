package com.example.anthony.notepadandroidv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class NoteViewActivity extends AppCompatActivity {
    Note note;
    TextView titre;
    TextView contenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view);
        note = (Note)getIntent().getSerializableExtra(MainActivity.EXTRA_MSG_NOTE);

        titre = (TextView)findViewById(R.id.titre);
        contenu = (TextView)findViewById(R.id.contenu);
        titre.setText(note.getTitre());
        contenu.setText(note.getContenu());
    }

    public void editNote(View view){
        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra(MainActivity.EXTRA_MSG_NOTE, note);
        startActivity(intent);
        finish();
    }
}
