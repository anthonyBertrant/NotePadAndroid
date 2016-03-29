package com.example.anthony.notepadandroidv2;

import java.util.Date;

/**
 * Created by anthony on 25/03/16.
 */

public class Note {
    private String titre;   //titre de la note
    private String contenu; //contenue de la note
    private Date date;      //date de creation
    private String adresse;

    public Note(String titre, String contenu, Date date, String adresse){
        super();
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.adresse = adresse;
    }

    public String getTitre(){
        return titre;
    }

    public String getContenu(){
        return contenu;
    }

    public String getDate(){
        return date.toString();
    }

    public String getAdresse(){
        return adresse;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setContenu(String contenu){
        this.contenu = contenu;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
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
