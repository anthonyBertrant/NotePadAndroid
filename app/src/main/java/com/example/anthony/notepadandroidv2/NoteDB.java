package com.example.anthony.notepadandroidv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by timothee on 06/04/16.
 */
public class NoteDB {
    SQLiteDatabase dbWritable;
    SQLiteDatabase dbReadable;

    public NoteDB(Context context){
        this.dbWritable = NoteDBOpenHelper.getNoteBDOpenHelper(context).getWritableDatabase();
        this.dbReadable = NoteDBOpenHelper.getNoteBDOpenHelper(context).getReadableDatabase();
    }

    public void addNewNote(Note note){
        ContentValues values = new ContentValues();
        values.put(NoteDBOpenHelper.COLUMN_TITRE, note.getTitre());
        values.put(NoteDBOpenHelper.COLUMN_VILLE, note.getVille());
        values.put(NoteDBOpenHelper.COLUMN_CONTENU, note.getContenu());
        values.put(NoteDBOpenHelper.COLUMN_DATE, note.getDate());
        dbWritable.insert(NoteDBOpenHelper.DATABASE_TABLE_NOTE, null,values);
    }

    public ArrayList<Note> getNotes(){
        ArrayList<Note> notes = new ArrayList<>();
        String[] columns = {NoteDBOpenHelper.COLUMN_TITRE
                    , NoteDBOpenHelper.COLUMN_VILLE
                    , NoteDBOpenHelper.COLUMN_CONTENU
                    , NoteDBOpenHelper.COLUMN_DATE};
        Cursor cursor = dbReadable.query(NoteDBOpenHelper.DATABASE_TABLE_NOTE, columns
                                        , null ,null , null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            String titre = cursor.getString(0);
            String ville = cursor.getString(1);
            String contenu = cursor.getString(2);
            String date = cursor.getString(3);
            notes.add(new Note(titre, contenu, date, ville));
        }

        return notes;
    }
}
