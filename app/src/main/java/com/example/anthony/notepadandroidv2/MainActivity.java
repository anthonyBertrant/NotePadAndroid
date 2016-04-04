package com.example.anthony.notepadandroidv2;

//Accueil de l'application


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener{
    Fragment[] fragments;
    NoteFragsPagerAdapter fragsPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = new Fragment[1];
        fragments[0] = NoteListFragment.newInstance(1);
        fragsPagerAdapter = new NoteFragsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(fragsPagerAdapter);
    }

    public void createNewNote(View view){
        //TODO creer une nouvelle note
        Intent intent = new Intent(this, NewNoteActivity.class);
        startActivity(intent);
    }

    @Override
    public void onListFragmentInteraction(Note note) {

    }

    public class NoteFragsPagerAdapter extends FragmentStatePagerAdapter {
        public NoteFragsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {return fragments[i];}

        @Override
        public int getCount() {return fragments.length ;}

        @Override
        public CharSequence getPageTitle(int position) {return "OBJECT " + (position + 1);}
    }
}
