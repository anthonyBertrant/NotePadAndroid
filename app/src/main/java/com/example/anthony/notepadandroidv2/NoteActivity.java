package com.example.anthony.notepadandroidv2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NoteActivity extends AppCompatActivity {

    protected EditText inputTitre;
    protected EditText inputVille;
    protected EditText inputContenu;
    final private int REQUEST_CODE_ASK_PERMISSION = 123;

    Note oldNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newnote);
        inputTitre = (EditText) findViewById(R.id.zoneTitre);
        inputVille = (EditText) findViewById(R.id.zoneVille);
        inputContenu = (EditText) findViewById(R.id.zoneTexte);
        oldNote = (Note) getIntent().getSerializableExtra(MainActivity.EXTRA_MSG_NOTE);
        if (oldNote != null) {
            inputTitre.setText(oldNote.getTitre());
            inputVille.setText(oldNote.getVille());
            inputContenu.setText(oldNote.getContenu());
        }
    }


    protected void getCoordonates(){
        Geocoder geocoder;
        String bestProvider;
        List<Address> user = null;
        double lat;
        double lng;
        try{
            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            bestProvider = lm.getBestProvider(criteria, false);
            Location location = lm.getLastKnownLocation(bestProvider);

            if(location == null){
                Toast.makeText(getApplicationContext(), "Location not found", Toast.LENGTH_LONG).show();
            }else{

                geocoder = new Geocoder(getApplicationContext());
                try {
                    user = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    lat=(double)user.get(0).getLatitude();
                    lng=(double)user.get(0).getLongitude();
                    System.out.println(" DDD lat: " +lat+",  longitude: "+lng);

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }catch(SecurityException e){
            e.printStackTrace();
        }
    }

    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults){
        switch(requestCode){
            case REQUEST_CODE_ASK_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //permission granted
                    getCoordonates();
                }else{
                    //permission denied
                    Toast.makeText(this, "ACCES GPS DENIED", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    public void enregistrer(View view) {
        /**
         * verifier que l'on a bien rempli tout les champs
         *
         * ajouter la note dans la bd
         */
        String titre = inputTitre.getText().toString();
        String ville = inputVille.getText().toString();
        String contenu = inputContenu.getText().toString();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = format1.format(cal.getTime());

        if (!titre.equals("") && !ville.equals("") && !contenu.equals("")) {
            //TODO recuper coordonnees gps

            int hasAccessLocationPermission = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
            if(hasAccessLocationPermission != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_ASK_PERMISSION);
                return;
            } //controle des permissions
            getCoordonates(); //recuperer les coordonnées gps


            //fin recup coordonnées gps

            Note note = null;
            NoteDB noteDB = new NoteDB(getApplicationContext());

            //si on creer une note
            if(oldNote == null) {
                note = new Note(titre, contenu, date,ville);
                //on ajoute dans la base la nouvelle note
                noteDB.addNewNote(note);
            }
            //sinon si on edite une note existante
            else if(oldNote.getId() >= 0){
                note = new Note(oldNote.getId(), titre, contenu, date, ville);
                //on met a jour la note
                noteDB.updateNote(note);
            }

            //revenir a MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            //TODO afficher un message d'erreur
            Toast toast = Toast.makeText(getApplicationContext(), "Mauvaise saisie...", Toast.LENGTH_SHORT);
            toast.show();
        }
        finish();
    }//enregistrer(View view)

    public void annuler(View view){
        /**
         * revenir a l'activite precedente
         */
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }//annuler(View view)
}
