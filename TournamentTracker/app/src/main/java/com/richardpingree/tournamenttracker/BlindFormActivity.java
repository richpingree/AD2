package com.richardpingree.tournamenttracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.richardpingree.tournamenttracker.Fragments.BlindFormFragment;

/**
 * Created by Richard Pingree APD2 1505 on 5/20/15.
 */
public class BlindFormActivity extends Activity implements BlindFormFragment.BlindFormListener{

    private final String TAG = "BlindFormA.TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blindform);

        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().replace(R.id.container, new BlindFormFragment()).commit();

        }
    }

    @Override
    public void addBlind(BlindClass newBlindLevel) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(BlindListActivity.ADDBLINDEXTRATIME, newBlindLevel.mTimer);
        returnIntent.putExtra(BlindListActivity.ADDBLINDEXTRASMALLBLIND, newBlindLevel.mSmallBlind);
        returnIntent.putExtra(BlindListActivity.ADDBLINDEXTRABIGBLIND, newBlindLevel.mBigBlind);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    @Override
    public void cancelBlind() {
        finish();
    }
}
