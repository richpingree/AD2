package com.richardpingree.tournamenttracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.richardpingree.tournamenttracker.Fragments.TourneyDetailsFragment;

/**
 * Created by Richard Pingree APD2 1505 on 5/13/15.
 */
public class TourneyDetailsActivity extends Activity implements TourneyDetailsFragment.TourneyDetailsListener{


    private final String TAG = "TourneyDetailsActivity.TAG";

    private TournamentClass mTournament;
    private int mDelete;

    public static final String TOURNEYEXTRA = "Tournament";
    public static final String DELETETOURNEYEXTRA = "Delete";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourneydetails);
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().add(R.id.container, new TourneyDetailsFragment()).commit();
        }

        Intent detailIntent = getIntent();
        if (detailIntent != null){
            mTournament = (TournamentClass) detailIntent.getSerializableExtra(TOURNEYEXTRA);
            mDelete = detailIntent.getIntExtra(DELETETOURNEYEXTRA, 0);
        }
    }

    @Override
    public TournamentClass getTourney() {
        return mTournament;
    }

    @Override
    public int getDelete() {
        return mDelete;
    }

    @Override
    public void deleteTourney() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(TournamentListActivity.DELETETOURNEYEXTRA, mDelete);
        setResult(RESULT_OK, returnIntent);
        finish();

    }
}
