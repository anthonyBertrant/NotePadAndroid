package com.example.anthony.notepadandroidv2;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by anthony on 25/03/16.
 */

public class Note implements Serializable{
    private int id;
    private String titre;   //titre de la note
    private String contenu; //contenue de la note
    private String date;      //date de creation
    private String ville;

    public Note(String titre, String contenu, String date, String ville){
        super();
        this.id = -1;
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.ville = ville;
    }

    public Note(int id, String titre, String contenu, String date, String ville){
        super();
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.ville = ville;
    }

    public int getId(){
        return id;
    }

    public String getTitre(){
        return titre;
    }

    public String getContenu(){
        return contenu;
    }

    public String getDate(){
        return date;
    }

    public String getVille(){
        return ville;
    }

    @Override
    public String toString() {
        return "Note{" +
                "titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' +
                ", date=" + date +
                '}';
    }
}
