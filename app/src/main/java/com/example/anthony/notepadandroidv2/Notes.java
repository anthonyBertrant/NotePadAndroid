package com.example.anthony.notepadandroidv2;

import java.util.Date;

/**
 * Created by anthony on 25/03/16.
 */
public class Notes {
    private String titre;   //titre de la note
    private String contenu; //contenue de la note
    private Date date;      //date de creation

    public Notes(String titre, String contenu, Date date){
        super();
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
    }
}
