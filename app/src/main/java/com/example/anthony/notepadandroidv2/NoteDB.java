package com.example.anthony.notepadandroidv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by timothee on 06/04/16.
 */
public class NoteDB {
    SQLiteDatabase dbWritable;
    SQLiteDatabase dbReadable;
    public NoteDB(Context context){
        dbWritable = NoteDBOpenHelper.getNoteBDOpenHelper(context).getWritableDatabase();
        dbReadable = NoteDBOpenHelper.getNoteBDOpenHelper(context).getReadableDatabase();
    }

    public void addNewNote(Note note){
        ContentValues values = new ContentValues();
        values.put(NoteDBOpenHelper.COLUMN_TITRE, note.getTitre());
        values.put(NoteDBOpenHelper.COLUMN_VILLE, note.getVille());
        values.put(NoteDBOpenHelper.COLUMN_CONTENU, note.getContenu());
        values.put(NoteDBOpenHelper.COLUMN_DATE, note.getDate());
        dbWritable.insert(NoteDBOpenHelper.DATABASE_TABLE_NOTE, null,values);
    }//addNewNote(Note)

    public void updateNote(Note note){
        ContentValues cv = new ContentValues();
        cv.put(NoteDBOpenHelper.COLUMN_TITRE,note.getTitre());
        cv.put(NoteDBOpenHelper.COLUMN_VILLE,note.getVille());
        cv.put(NoteDBOpenHelper.COLUMN_CONTENU,note.getContenu());
        cv.put(NoteDBOpenHelper.COLUMN_DATE, note.getDate());
        String whereClause = NoteDBOpenHelper.COLUMN_ID +"="+note.getId(); // Where clause
        dbWritable.update(NoteDBOpenHelper.DATABASE_TABLE_NOTE, cv
                , whereClause, null);
    }//updateNote(Note)

    public ArrayList<Note> getNotes(){
        ArrayList<Note> notes = new ArrayList<>();
        String[] columns = {NoteDBOpenHelper.COLUMN_ID
                    ,NoteDBOpenHelper.COLUMN_TITRE
                    , NoteDBOpenHelper.COLUMN_VILLE
                    , NoteDBOpenHelper.COLUMN_CONTENU
                    , NoteDBOpenHelper.COLUMN_DATE};
        Cursor cursor = dbReadable.query(NoteDBOpenHelper.DATABASE_TABLE_NOTE, columns
                                        , null ,null , null, null, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String titre = cursor.getString(1);
            String ville = cursor.getString(2);
            String contenu = cursor.getString(3);
            String date = cursor.getString(4);
            notes.add(new Note(id, titre, contenu, date, ville));
            cursor.moveToNext();
        }

        return notes;
    }//getNotes()   returns ArrayList<Note>
}
