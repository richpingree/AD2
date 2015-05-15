package com.richardpingree.tournamenttracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.richardpingree.tournamenttracker.Fragments.TourneyFormFragment;

/**
 * Created by Richard Pingree APD2 1505 on 5/14/15.
 */
public class TourneyFormActivity extends Activity implements TourneyFormFragment.TourneyFormListener{

    private final String TAG = "TourneyFormActivity.TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentform);

        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().replace(R.id.container, new TourneyFormFragment()).commit();
        }
    }

    @Override
    public void addTourney(TournamentClass newTournament) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(TournamentListActivity.ADDTOURNEYNAME, newTournament.tournyName);
        //Player1
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER1NAME, newTournament.p1Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER1PAYOUT, newTournament.p1Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER1POINTS, newTournament.p1Points);
        //Player2
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER2NAME, newTournament.p2Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER2PAYOUT, newTournament.p2Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER2POINTS, newTournament.p2Points);
        //Player3
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER3NAME, newTournament.p3Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER3PAYOUT, newTournament.p3Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER3POINTS, newTournament.p3Points);
        //Player4
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER4NAME, newTournament.p4Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER4PAYOUT, newTournament.p4Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER4POINTS, newTournament.p4Points);
        //Player5
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER5NAME, newTournament.p5Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER5PAYOUT, newTournament.p5Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER5POINTS, newTournament.p5Points);
        //Player6
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER6NAME, newTournament.p6Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER6PAYOUT, newTournament.p6Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER6POINTS, newTournament.p6Points);
        //Player7
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER7NAME, newTournament.p7Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER7PAYOUT, newTournament.p7Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER7POINTS, newTournament.p7Points);
        //Player8
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER8NAME, newTournament.p8Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER8PAYOUT, newTournament.p8Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER8POINTS, newTournament.p8Points);
        //Player9
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER9NAME, newTournament.p9Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER9PAYOUT, newTournament.p9Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER9POINTS, newTournament.p9Points);
        //Player10
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER10NAME, newTournament.p10Name);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER10PAYOUT, newTournament.p10Payout);
        returnIntent.putExtra(TournamentListActivity.ADDPLAYER10POINTS, newTournament.p10Points);
        setResult(RESULT_OK, returnIntent);
        finish();

    }

    @Override
    public void cancelTourney() {
        finish();
    }


}
