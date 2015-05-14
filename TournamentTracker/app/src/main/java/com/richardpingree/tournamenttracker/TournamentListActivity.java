package com.richardpingree.tournamenttracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.richardpingree.tournamenttracker.Fragments.TournamentListFragment;

import java.util.ArrayList;

/**
 * Created by Richard Pingree APD2 1505 on 5/12/15.
 */
public class TournamentListActivity  extends Activity implements TournamentListFragment.TournamentListener{


    private final String TAG = "TournamentListActivity.TAG";

    private static final int ADDREQUEST = 0;
    private ArrayList<TournamentClass> mTournamentResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentlist);

        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().replace(R.id.container, new TournamentListFragment()).commit();
        }


        mTournamentResultList = new ArrayList<TournamentClass>();

        mTournamentResultList.add(new TournamentClass("First Tournament", "John Smith", 100, 9, "Richard Pingree", 75, 8,
                "Fred", 50, 7, "Jason", 25, 6, "Kyle", 25, 5, "Dusty", 25, 4, "Darin", 25, 3, "Todd", 25, 2, "Chad", 25, 1, "Matt", 25, 0));
    }

    @Override
    public void viewTournament(int position) {
        Intent tourneyDetailIntent = new Intent(this, TourneyDetailsActivity.class);
        tourneyDetailIntent.putExtra(TourneyDetailsActivity.TOURNEYEXTRA, mTournamentResultList.get(position));
        startActivity(tourneyDetailIntent);

    }

    @Override
    public void deleteTournament(int position) {

    }

    @Override
    public ArrayList<TournamentClass> getTournaments() {
        return mTournamentResultList;
    }

    @Override
    public void addTournament() {
        Intent addTourneyIntent = new Intent(this, TourneyFormActivity.class);
        startActivityForResult(addTourneyIntent, ADDREQUEST);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tourney, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                addTournament();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
