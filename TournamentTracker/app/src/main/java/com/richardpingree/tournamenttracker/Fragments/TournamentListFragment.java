package com.richardpingree.tournamenttracker.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.richardpingree.tournamenttracker.R;
import com.richardpingree.tournamenttracker.TournamentAdapter;
import com.richardpingree.tournamenttracker.TournamentClass;

import java.util.ArrayList;

/**
 * Created by Richard Pingree APD2 1505 on 5/13/15.
 */
public class TournamentListFragment extends Fragment {

    private final String TAG = "TournamentListFragment.TAG";

    private TournamentListener mListener;
    private ArrayList<TournamentClass> mTourneyList;
    TournamentAdapter mAdapter;
    private int mItemSelected = -1;

    public interface TournamentListener{
        public void viewTournament(int position);
        public void deleteTournament(int position);
        public ArrayList<TournamentClass> getTournaments();
        public void addTournament();

    }

    public TournamentListFragment(){

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof TournamentListener){
            mListener = (TournamentListener) activity;
        }else{
            throw new IllegalArgumentException("Containing activity must implement TournamentListener interface");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tournamentlist, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);

        getActivity().getActionBar().setTitle(R.string.title_section2);

        ListView tourneyListView = (ListView) getView().findViewById(R.id.tourneyList);
        mAdapter = new TournamentAdapter(getActivity(), mListener.getTournaments());
        tourneyListView.setAdapter(mAdapter);

        tourneyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // mListener.viewTournament(position);
                mListener.deleteTournament(position);
            }
        });
    }

    public void updateTourneyList(){
        ListView tourneyList = (ListView) getView().findViewById(R.id.tourneyList);
        BaseAdapter adapter = (BaseAdapter) tourneyList.getAdapter();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.tourney, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                mListener.addTournament();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
