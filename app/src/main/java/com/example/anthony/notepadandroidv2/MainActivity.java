package com.example.anthony.notepadandroidv2;

//Accueil de l'application


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener
                                                                , OnFragmentInteractionListener{
    Fragment[] fragments;
    NoteFragsPagerAdapter fragsPagerAdapter;
    ViewPager mViewPager;
    public static final String EXTRA_MSG_NOTE = "note";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoteDBOpenHelper.getNoteBDOpenHelper(getBaseContext());

        //creation des fragments
        fragments = new Fragment[1];
        fragments[0] = NoteListFragment.newInstance(1);

        //affichage
        fragsPagerAdapter = new NoteFragsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(fragsPagerAdapter);
    }


    public void createNewNote(View view){
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

    @Override
    public void onListFragmentInteraction(Note note) {
        Intent intent = new Intent(this, NoteViewActivity.class);
        intent.putExtra(EXTRA_MSG_NOTE, note);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

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
