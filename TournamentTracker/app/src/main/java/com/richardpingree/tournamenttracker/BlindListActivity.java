package com.richardpingree.tournamenttracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.richardpingree.tournamenttracker.Fragments.BlindListFragment;
import com.richardpingree.tournamenttracker.Fragments.TimerFragment;

import java.util.ArrayList;

/**
 * Created by Richard Pingree APD2 1505 on 5/20/15.
 */
public class BlindListActivity extends Activity implements BlindListFragment.BlindListListener, TimerFragment.TimerListener{

    private final String TAG = "BlindListA.Tag";

    private static final int ADDBLINDREQUEST = 1;
    public static String ADDBLINDEXTRATIME = "Timer";
    public static String ADDBLINDEXTRASMALLBLIND = "Small Blind";
    public static String ADDBLINDEXTRABIGBLIND = "Big Blind";
    public static int DELETEBLINDREQUEST = 0;
    public static String DELETEBLINDEXTRA = "Delete Blind";

    public BlindClass newBlindLevel;
    public ArrayList<BlindClass> mBlindArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blindlist);
        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().replace(R.id.container, new BlindListFragment()).commit();
        }

        mBlindArrayList = new ArrayList<BlindClass>();


        if (BlindFileUtility.loadBlinds(this) != null){
            mBlindArrayList = BlindFileUtility.loadBlinds(this);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == ADDBLINDREQUEST){
            newBlindLevel = new BlindClass();

            newBlindLevel.mTimer = data.getIntExtra(ADDBLINDEXTRATIME, 0);
            newBlindLevel.mSmallBlind = data.getIntExtra(ADDBLINDEXTRASMALLBLIND, 0);
            newBlindLevel.mBigBlind = data.getIntExtra(ADDBLINDEXTRABIGBLIND, 0);

            mBlindArrayList.add(newBlindLevel);

            if (newBlindLevel != null){
                BlindFileUtility.saveBlinds(this, newBlindLevel);
                //Log.i(TAG, "data saved");
            }else{
                //Log.i(TAG, "data did not save!");
            }

            BlindListFragment blf = (BlindListFragment)getFragmentManager().findFragmentById(R.id.container);
            try{
                blf.updateBlindList();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    @Override
    public void deleteBlind(int position) {
        mBlindArrayList.remove(position);
        BlindListFragment blf = (BlindListFragment) getFragmentManager().findFragmentById(R.id.container);
        try{
            blf.updateBlindList();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<BlindClass> getBlinds() {
        return mBlindArrayList;
    }

    @Override
    public void addBlind() {
        Intent addBlindIntent = new Intent(this, BlindFormActivity.class);
        startActivityForResult(addBlindIntent, ADDBLINDREQUEST);
    }
}
