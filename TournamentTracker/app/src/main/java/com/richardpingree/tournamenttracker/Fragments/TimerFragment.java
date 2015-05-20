package com.richardpingree.tournamenttracker.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.richardpingree.tournamenttracker.R;

/**
 * Created by richardpingree on 5/18/15.
 */
public class TimerFragment extends Fragment {

    private final String TAG = "TimerFragment.TAG";

    TextView timer, smallBlind, bigBlind;

    Button resetButton;

    public TimerFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timer, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);

        timer = (TextView)getView().findViewById(R.id.timerView);
        smallBlind = (TextView)getView().findViewById(R.id.smallBlindValue);
        bigBlind = (TextView)getView().findViewById(R.id.bigBlindValue);
        resetButton = (Button)getView().findViewById(R.id.resetBtn);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.timer, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Log.i(TAG, "add button pressed");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
