package com.example.anthony.notepadandroidv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by anthony on 25/03/16.
 */
public class NotesDBOpenHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "notesDataBase.db";
    final static String DATABASE_TABLE = "notes";
    private final static int DATABASE_VERSION = 1;
    private static NotesDBOpenHelper instance = null;

    //Champs de la base
    public static final String COLUMN_TITRE = "titre";
    public static final String COLUMN_CONTENU = "contenu";
    public static final String COLUMN_DATE = "date";

    //ligne creation de la base
    private static final String DATABASE_CREATE = "create table " + DATABASE_TABLE + "(" + COLUMN_TITRE + "text not null," +
            COLUMN_CONTENU + " text not null, " + COLUMN_DATE + ", text not null);" ;

    //singleton
    public static NotesDBOpenHelper getNoteBDOpenHelper(Context context){
        //TODO: Singleton
        if(instance == null){
            new NotesDBOpenHelper(context);
        }
        return instance;
    }

    private NotesDBOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creation de la base
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    //mise a jour d'une nouvelle version de la base
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(NotesDBOpenHelper.class.getName(), "Upgrading database from version " + oldVersion + " to "
        + newVersion + ", which will destroy all data");
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }
}
