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
        returnIntent.putExtra(MainActivity.ADDTOURNEYNAME, newTournament.tournyName);
        //Player1
        returnIntent.putExtra(MainActivity.ADDPLAYER1NAME, newTournament.p1Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER1PAYOUT, newTournament.p1Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER1POINTS, newTournament.p1Points);
        //Player2
        returnIntent.putExtra(MainActivity.ADDPLAYER2NAME, newTournament.p2Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER2PAYOUT, newTournament.p2Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER2POINTS, newTournament.p2Points);
        //Player3
        returnIntent.putExtra(MainActivity.ADDPLAYER3NAME, newTournament.p3Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER3PAYOUT, newTournament.p3Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER3POINTS, newTournament.p3Points);
        //Player4
        returnIntent.putExtra(MainActivity.ADDPLAYER4NAME, newTournament.p4Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER4PAYOUT, newTournament.p4Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER4POINTS, newTournament.p4Points);
        //Player5
        returnIntent.putExtra(MainActivity.ADDPLAYER5NAME, newTournament.p5Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER5PAYOUT, newTournament.p5Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER5POINTS, newTournament.p5Points);
        //Player6
        returnIntent.putExtra(MainActivity.ADDPLAYER6NAME, newTournament.p6Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER6PAYOUT, newTournament.p6Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER6POINTS, newTournament.p6Points);
        //Player7
        returnIntent.putExtra(MainActivity.ADDPLAYER7NAME, newTournament.p7Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER7PAYOUT, newTournament.p7Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER7POINTS, newTournament.p7Points);
        //Player8
        returnIntent.putExtra(MainActivity.ADDPLAYER8NAME, newTournament.p8Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER8PAYOUT, newTournament.p8Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER8POINTS, newTournament.p8Points);
        //Player9
        returnIntent.putExtra(MainActivity.ADDPLAYER9NAME, newTournament.p9Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER9PAYOUT, newTournament.p9Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER9POINTS, newTournament.p9Points);
        //Player10
        returnIntent.putExtra(MainActivity.ADDPLAYER10NAME, newTournament.p10Name);
        returnIntent.putExtra(MainActivity.ADDPLAYER10PAYOUT, newTournament.p10Payout);
        returnIntent.putExtra(MainActivity.ADDPLAYER10POINTS, newTournament.p10Points);
        setResult(RESULT_OK, returnIntent);
        finish();

    }

    @Override
    public void cancelTourney() {
        finish();
    }


}
