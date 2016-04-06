package com.example.anthony.notepadandroidv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by anthony on 25/03/16.
 */
public class NoteDBOpenHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "notesDataBase.db";
    final static String DATABASE_TABLE_NOTE = "NOTES";
    private final static int DATABASE_VERSION = 1;
    private static NoteDBOpenHelper instance = null;

    //Champs de la base
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TITRE = "TITRE";
    public static final String COLUMN_VILLE = "VILLE";
    public static final String COLUMN_CONTENU = "CNTENU";
    public static final String COLUMN_DATE = "DATE";

    //ligne creation de la base
    private static final String DATABASE_CREATE = "create table " + DATABASE_TABLE_NOTE + " ("
                                                        + COLUMN_ID + " INTEGER PRIMARY KEY   AUTOINCREMENT, "
                                                        + COLUMN_TITRE + " text NOT NULL, "
                                                        + COLUMN_VILLE + " text NOT NULL, "
                                                        + COLUMN_CONTENU + " text NOT NULL, "
                                                        + COLUMN_DATE + " text NOT NULL);" ;

    //singleton
    public static NoteDBOpenHelper getNoteBDOpenHelper(Context context){
        //TODO: Singleton
        if(instance == null){
            new NoteDBOpenHelper(context);
        }
        return instance;
    }

    private NoteDBOpenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        instance = this;
    }

    //creation de la base
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    //mise a jour d'une nouvelle version de la base
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(NoteDBOpenHelper.class.getName(), "Upgrading database from version " + oldVersion + " to "
        + newVersion + ", which will destroy all data");
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NOTE);
        onCreate(db);
    }
}
