package com.example.anthony.notepadandroidv2;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by anthony on 25/03/16.
 */

public class Note {
    private String titre;   //titre de la note
    private String contenu; //contenue de la note
    private String date;      //date de creation
    private String ville;

    public Note(String titre, String contenu, String date, String ville){
        super();
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.ville = ville;
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

    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setContenu(String contenu){
        this.contenu = contenu;
    }

    public void setVille(String ville){
        this.ville = ville;
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
