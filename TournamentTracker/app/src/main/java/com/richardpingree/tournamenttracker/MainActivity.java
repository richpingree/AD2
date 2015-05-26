package com.richardpingree.tournamenttracker;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.richardpingree.tournamenttracker.Fragments.PokerHandsFragment;
import com.richardpingree.tournamenttracker.Fragments.TimerFragment;
import com.richardpingree.tournamenttracker.Fragments.TournamentListFragment;

import java.util.ArrayList;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, TournamentListFragment.TournamentListener, TimerFragment.TimerListener {


    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private final String TAG = "MainActivity.TAG";

    //Tournament List Activity
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
    public static final String ADDARRAYEXTRAS = "Add Blind Array";
    private ArrayList<BlindClass> mBlindArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        //TournamentList
        mTournamentResultList = new ArrayList<TournamentClass>();


        if (TournamentFileUtility.tourneyLoad(this) != null){
            mTournamentResultList = TournamentFileUtility.tourneyLoad(this);
        }

        //BlindList for Timer
        mBlindArrayList = new ArrayList<BlindClass>();

        if (BlindFileUtility.loadBlinds(this) != null){
            mBlindArrayList = BlindFileUtility.loadBlinds(this);
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
//                .commit();
        switch (position){
            case 0:
                getFragmentManager().beginTransaction().replace(R.id.container, new TimerFragment()).commit();
                break;
            case 1:
                getFragmentManager().beginTransaction().replace(R.id.container, new TournamentListFragment()).commit();
                break;
            case 2:

                break;
            case 3:
                getFragmentManager().beginTransaction().replace(R.id.container, new PokerHandsFragment()).commit();
                break;

        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.titel_section4);
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            //getMenuInflater().inflate(R.menu.main, menu);
            //restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//Tournament Fragment interface
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
        } else if (resultCode == Activity.RESULT_OK && requestCode == DELETEREQUEST){
            mTournamentResultList.remove(data.getIntExtra(DELETETOURNEYEXTRA,0));
            TournamentListFragment tlf = (TournamentListFragment) getFragmentManager().findFragmentById(R.id.container);
            try{
                tlf.updateTourneyList();
            }catch  (Exception e){
                e.printStackTrace();
            }
        }else if(resultCode == Activity.RESULT_OK && requestCode == TimerFragment.ADDEXTRAS){
            mBlindArrayList = (ArrayList<BlindClass>) data.getSerializableExtra(ADDARRAYEXTRAS);
            Log.i("MainActivity", "Results from list" + mBlindArrayList.toString());

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
        Intent deleteIntent = new Intent(this, TourneyDetailsActivity.class);
        deleteIntent.putExtra(TourneyDetailsActivity.TOURNEYEXTRA, mTournamentResultList.get(position));
        deleteIntent.putExtra(TourneyDetailsActivity.DELETETOURNEYEXTRA, position);
        startActivityForResult(deleteIntent, DELETEREQUEST);
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
    //Timer interface
    @Override
    public ArrayList<BlindClass> getBlinds() {
        return mBlindArrayList;
    }
}
