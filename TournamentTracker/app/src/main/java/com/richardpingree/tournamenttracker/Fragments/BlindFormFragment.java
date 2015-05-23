package com.richardpingree.tournamenttracker.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.richardpingree.tournamenttracker.BlindClass;
import com.richardpingree.tournamenttracker.R;

/**
 * Created by Richard Pingree APD2 1505 on 5/20/15.
 */
public class BlindFormFragment extends Fragment {

    private final String TAG = "BlindFormFrag.TAG";

    public EditText time, sBlind, bBlind;
    public Button save, cancel;

    public BlindClass newBlindLevel;

    private BlindFormListener mListener;

    public interface BlindFormListener{
        public void addBlind(BlindClass newBlindLevel);
        public void cancelBlind();
    }

    public BlindFormFragment(){

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof BlindFormListener){
            mListener = (BlindFormListener)activity;
        }else{
            throw new IllegalArgumentException("Containing activity must implement BlindFormListener interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blindform, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        time = (EditText) getView().findViewById(R.id.timeInput);
        time.setText(String.valueOf(30));
        sBlind = (EditText) getView().findViewById(R.id.smallBlindInput);
        sBlind.setText(String.valueOf(0));
        bBlind = (EditText) getView().findViewById(R.id.bigBlindInput);
        bBlind.setText(String.valueOf(0));

        save = (Button) getView().findViewById(R.id.blindSave);
        cancel = (Button) getView().findViewById(R.id.blindCancel);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newBlindLevel = new BlindClass();

                newBlindLevel.mTimer = Integer.valueOf(time.getText().toString());
                newBlindLevel.mSmallBlind = Integer.valueOf(sBlind.getText().toString());
                newBlindLevel.mBigBlind = Integer.valueOf(bBlind.getText().toString());

                mListener.addBlind(newBlindLevel);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelBlind();
            }
        });
    }
}
