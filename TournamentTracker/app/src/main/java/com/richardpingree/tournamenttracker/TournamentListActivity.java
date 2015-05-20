package com.richardpingree.tournamenttracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.richardpingree.tournamenttracker.Fragments.TournamentListFragment;

import java.util.ArrayList;

/**
 * Created by Richard Pingree APD2 1505 on 5/12/15.
 */
public class TournamentListActivity  extends Activity implements TournamentListFragment.TournamentListener{


    private final String TAG = "TournamentListActivity.TAG";

    private static final int ADDREQUEST = 0;
    public static String ADDTOURNEYNAME = "Tournament Name";
    public static String ADDPLAYER1NAME = "Player1";
    public static String ADDPLAYER1PAYOUT = "Player1Payout";
    public static String ADDPLAYER1POINTS = "Player1Points";
    public static String ADDPLAYER2NAME = "Player2";
    public static String ADDPLAYER2PAYOUT = "Player2Payout";
    public static String ADDPLAYER2POINTS = "Player2Points";
    public static String ADDPLAYER3NAME = "Player3";
    public static String ADDPLAYER3PAYOUT = "Player3Payout";
    public static String ADDPLAYER3POINTS = "Player3Points";
    public static String ADDPLAYER4NAME = "Player4";
    public static String ADDPLAYER4PAYOUT = "Player4Payout";
    public static String ADDPLAYER4POINTS = "Player4Points";
    public static String ADDPLAYER5NAME = "Player5";
    public static String ADDPLAYER5PAYOUT = "Player5Payout";
    public static String ADDPLAYER5POINTS = "Player5Points";
    public static String ADDPLAYER6NAME = "Player6";
    public static String ADDPLAYER6PAYOUT = "Player6Payout";
    public static String ADDPLAYER6POINTS = "Player6Points";
    public static String ADDPLAYER7NAME = "Player7";
    public static String ADDPLAYER7PAYOUT = "Player7Payout";
    public static String ADDPLAYER7POINTS = "Player7Points";
    public static String ADDPLAYER8NAME = "Player8";
    public static String ADDPLAYER8PAYOUT = "Player8Payout";
    public static String ADDPLAYER8POINTS = "Player8Points";
    public static String ADDPLAYER9NAME = "Player9";
    public static String ADDPLAYER9PAYOUT = "Player9Payout";
    public static String ADDPLAYER9POINTS = "Player9Points";
    public static String ADDPLAYER10NAME = "Player10";
    public static String ADDPLAYER10PAYOUT = "Player10Payout";
    public static String ADDPLAYER10POINTS = "Player10Points";
    public static int DELETEREQUEST = 1;
    public static String DELETETOURNEYEXTRA = "Delete Tournament";
    private ArrayList<TournamentClass> mTournamentResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournamentlist);




        mTournamentResultList = new ArrayList<TournamentClass>();

//        Test Data
//        mTournamentResultList.add(new TournamentClass("First Tournament", "John Smith", 100, 9, "Richard Pingree", 75, 8,
//                "Fred", 50, 7, "Jason", 25, 6, "Kyle", 25, 5, "Dusty", 25, 4, "Darin", 25, 3, "Todd", 25, 2, "Chad", 25, 1, "Matt", 25, 0));

        if (TournamentFileUtility.tourneyLoad(this) != null){
            mTournamentResultList = TournamentFileUtility.tourneyLoad(this);
        }

        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().replace(R.id.container, new TournamentListFragment()).commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == ADDREQUEST){
            TournamentClass newTournament = new TournamentClass();

            //Tournament Name
            newTournament.tournyName = data.getStringExtra(ADDTOURNEYNAME);
            //Player1
            newTournament.p1Name = data.getStringExtra(ADDPLAYER1NAME);
            newTournament.p1Payout = data.getIntExtra(ADDPLAYER1PAYOUT, 0);
            newTournament.p1Points = data.getIntExtra(ADDPLAYER1POINTS, 0);
            //Player2
            newTournament.p2Name = data.getStringExtra(ADDPLAYER2NAME);
            newTournament.p2Payout = data.getIntExtra(ADDPLAYER2PAYOUT,0);
            newTournament.p2Points = data.getIntExtra(ADDPLAYER2POINTS, 0);
            //Player3
            newTournament.p3Name = data.getStringExtra(ADDPLAYER3NAME);
            newTournament.p3Payout = data.getIntExtra(ADDPLAYER3PAYOUT,0);
            newTournament.p3Points = data.getIntExtra(ADDPLAYER3POINTS, 0);
            //Player4
            newTournament.p4Name = data.getStringExtra(ADDPLAYER4NAME);
            newTournament.p4Payout = data.getIntExtra(ADDPLAYER4PAYOUT,0);
            newTournament.p4Points = data.getIntExtra(ADDPLAYER4POINTS, 0);
            //Player5
            newTournament.p5Name = data.getStringExtra(ADDPLAYER5NAME);
            newTournament.p5Payout = data.getIntExtra(ADDPLAYER5PAYOUT,0);
            newTournament.p5Points = data.getIntExtra(ADDPLAYER5POINTS, 0);
            //Player6
            newTournament.p6Name = data.getStringExtra(ADDPLAYER6NAME);
            newTournament.p6Payout = data.getIntExtra(ADDPLAYER6PAYOUT,0);
            newTournament.p6Points = data.getIntExtra(ADDPLAYER6POINTS, 0);
            //Player7
            newTournament.p7Name = data.getStringExtra(ADDPLAYER7NAME);
            newTournament.p7Payout = data.getIntExtra(ADDPLAYER7PAYOUT,0);
            newTournament.p7Points = data.getIntExtra(ADDPLAYER7POINTS, 0);
            //Player8
            newTournament.p8Name = data.getStringExtra(ADDPLAYER8NAME);
            newTournament.p8Payout = data.getIntExtra(ADDPLAYER8PAYOUT,0);
            newTournament.p8Points = data.getIntExtra(ADDPLAYER8POINTS, 0);
            //Player9
            newTournament.p9Name = data.getStringExtra(ADDPLAYER9NAME);
            newTournament.p9Payout = data.getIntExtra(ADDPLAYER9PAYOUT,0);
            newTournament.p9Points = data.getIntExtra(ADDPLAYER9POINTS, 0);
            //Player10
            newTournament.p10Name = data.getStringExtra(ADDPLAYER10NAME);
            newTournament.p10Payout = data.getIntExtra(ADDPLAYER10PAYOUT, 0);
            newTournament.p10Points = data.getIntExtra(ADDPLAYER10POINTS, 0);

            mTournamentResultList.add(newTournament);

            if (newTournament != null){
                TournamentFileUtility.tourneySave(this, newTournament);
                //Log.i(TAG, "data saved");
            }else{
               //Log.i(TAG, "data did not save!");
            }
            TournamentListFragment tlf = (TournamentListFragment) getFragmentManager().findFragmentById(R.id.container);
            try{
                tlf.updateTourneyList();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void viewTournament(int position) {
        Intent tourneyDetailIntent = new Intent(this, TourneyDetailsActivity.class);
        tourneyDetailIntent.putExtra(TourneyDetailsActivity.TOURNEYEXTRA, mTournamentResultList.get(position));
        startActivity(tourneyDetailIntent);

    }

    @Override
    public void deleteTournament(int position) {
        mTournamentResultList.remove(position);
        TournamentListFragment tlf = (TournamentListFragment) getFragmentManager().findFragmentById(R.id.container);
        try{
            tlf.updateTourneyList();
        }catch (Exception e){
            e.printStackTrace();
        }

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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.tourney, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_add:
//                addTournament();
//                break;
//            default:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
