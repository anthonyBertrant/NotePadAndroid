package com.example.anthony.notepadandroidv2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class NoteListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ArrayList<Note> notes;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NoteListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NoteListFragment newInstance(int columnCount) {
        NoteListFragment fragment = new NoteListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        notes = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            /* */
            notes.add(new Note("A", "......", "04/04/16", "Aix-en-Provence"));
            notes.add(new Note("B", "......", "04/04/16", "Marseille"));
            notes.add(new Note("C", "......", "04/04/16", "Nice"));
            notes.add(new Note("D", "......", "04/04/16", "Avignon"));
            notes.add(new Note("E", "......", "04/04/16", "Toulon"));
            notes.add(new Note("F", "......", "04/04/16", "Gap"));
            notes.add(new Note("A", "......", "04/04/16", "Aix-en-Provence"));
            notes.add(new Note("B", "......", "04/04/16", "Marseille"));
            notes.add(new Note("C", "......", "04/04/16", "Nice"));
            notes.add(new Note("D", "......", "04/04/16", "Avignon"));
            notes.add(new Note("E", "......", "04/04/16", "Toulon"));
            notes.add(new Note("F", "......", "04/04/16", "Gap"));
            notes.add(new Note("A", "......", "04/04/16", "Aix-en-Provence"));
            notes.add(new Note("B", "......", "04/04/16", "Marseille"));
            notes.add(new Note("C", "......", "04/04/16", "Nice"));
            notes.add(new Note("D", "......", "04/04/16", "Avignon"));
            notes.add(new Note("E", "......", "04/04/16", "Toulon"));
            notes.add(new Note("F", "......", "04/04/16", "Gap"));

            Log.v(">>>>>>>>> NOTES: ", notes.toString());
            /* */

            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyNoteRecyclerViewAdapter(notes, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
