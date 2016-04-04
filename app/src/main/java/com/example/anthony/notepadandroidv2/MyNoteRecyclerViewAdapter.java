package com.example.anthony.notepadandroidv2;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;


public class MyNoteRecyclerViewAdapter extends RecyclerView.Adapter<MyNoteRecyclerViewAdapter.ViewHolder> {

    private final List<Note> notes;
    private final OnListFragmentInteractionListener mListener;

    public MyNoteRecyclerViewAdapter(List<Note> notes, OnListFragmentInteractionListener listener) {
        this.notes = notes;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.v(">>>>>>>>>>>>POSITION: ", ""+position);
        holder.note = notes.get(position);
        holder.titre.setText(notes.get(position).getTitre());
        holder.ville.setText(notes.get(position).getVille());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.note);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView titre;
        public final TextView ville;
        public Note note;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            titre = (TextView) view.findViewById(R.id.titre);
            ville = (TextView) view.findViewById(R.id.ville);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + titre.getText() + "'";
        }
    }
}
