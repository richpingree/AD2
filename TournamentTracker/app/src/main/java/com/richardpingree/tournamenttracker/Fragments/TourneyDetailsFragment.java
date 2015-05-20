package com.richardpingree.tournamenttracker.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.richardpingree.tournamenttracker.R;
import com.richardpingree.tournamenttracker.TournamentClass;

/**
 * Created by Richard Pingree APD2 1505 on 5/13/15.
 */
public class TourneyDetailsFragment extends Fragment {

    private final String TAG = "TDetailsFragment.TAG";

    private TourneyDetailsListener mListener;

    public interface TourneyDetailsListener{
        public TournamentClass getTourney();
        public int getDelete();
        public void deleteTourney();

    }

    public TourneyDetailsFragment(){

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof TourneyDetailsListener){
            mListener = (TourneyDetailsListener) activity;
        }else{
            throw new IllegalArgumentException("Containing activity must implement TourneyDetailsListener interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tourneydetails, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Tournament Name
        TextView textView = (TextView)getView().findViewById(R.id.tourneyName);
        textView.setText(mListener.getTourney().getTournyName());
        //Player 1
        textView = (TextView)getView().findViewById(R.id.p1NameLabel);
        textView.setText(mListener.getTourney().getP1Name());
        textView = (TextView)getView().findViewById(R.id.p1PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP1Payout());
        textView = (TextView)getView().findViewById(R.id.p1PointsLabel);
        textView.setText("" + mListener.getTourney().getP1Points());
        //Player 2
        textView = (TextView)getView().findViewById(R.id.p2NameLabel);
        textView.setText(mListener.getTourney().getP2Name());
        textView = (TextView)getView().findViewById(R.id.p2PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP2Payout());
        textView = (TextView)getView().findViewById(R.id.p2PointsLabel);
        textView.setText("" + mListener.getTourney().getP2Points());
        //Player 3
        textView = (TextView)getView().findViewById(R.id.p3NameLabel);
        textView.setText(mListener.getTourney().getP3Name());
        textView = (TextView)getView().findViewById(R.id.p3PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP3Payout());
        textView = (TextView)getView().findViewById(R.id.p3PointsLabel);
        textView.setText("" + mListener.getTourney().getP3Points());
        //Player 4
        textView = (TextView)getView().findViewById(R.id.p4NameLabel);
        textView.setText(mListener.getTourney().getP4Name());
        textView = (TextView)getView().findViewById(R.id.p4PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP4Payout());
        textView = (TextView)getView().findViewById(R.id.p4PointsLabel);
        textView.setText("" + mListener.getTourney().getP4Points());
        //Player 5
        textView = (TextView)getView().findViewById(R.id.p5NameLabel);
        textView.setText(mListener.getTourney().getP5Name());
        textView = (TextView)getView().findViewById(R.id.p5PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP5Payout());
        textView = (TextView)getView().findViewById(R.id.p5PointsLabel);
        textView.setText("" + mListener.getTourney().getP5Points());
        //Player 6
        textView = (TextView)getView().findViewById(R.id.p6NameLabel);
        textView.setText(mListener.getTourney().getP6Name());
        textView = (TextView)getView().findViewById(R.id.p6PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP6Payout());
        textView = (TextView)getView().findViewById(R.id.p6PointsLabel);
        textView.setText("" + mListener.getTourney().getP6Points());
        //Player 7
        textView = (TextView)getView().findViewById(R.id.p7NameLabel);
        textView.setText(mListener.getTourney().getP7Name());
        textView = (TextView)getView().findViewById(R.id.p7PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP7Payout());
        textView = (TextView)getView().findViewById(R.id.p7PointsLabel);
        textView.setText("" + mListener.getTourney().getP7Points());
        //Player 8
        textView = (TextView)getView().findViewById(R.id.p8NameLabel);
        textView.setText(mListener.getTourney().getP8Name());
        textView = (TextView)getView().findViewById(R.id.p8PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP8Payout());
        textView = (TextView)getView().findViewById(R.id.p8PointsLabel);
        textView.setText("" + mListener.getTourney().getP8Points());
        //Player 9
        textView = (TextView)getView().findViewById(R.id.p9NameLabel);
        textView.setText(mListener.getTourney().getP9Name());
        textView = (TextView)getView().findViewById(R.id.p9PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP9Payout());
        textView = (TextView)getView().findViewById(R.id.p9PointsLabel);
        textView.setText("" + mListener.getTourney().getP9Points());
        //Player 10
        textView = (TextView)getView().findViewById(R.id.p10NameLabel);
        textView.setText(mListener.getTourney().getP10Name());
        textView = (TextView)getView().findViewById(R.id.p10PayoutLabel);
        textView.setText("$" + mListener.getTourney().getP10Payout());
        textView = (TextView)getView().findViewById(R.id.p10PointsLabel);
        textView.setText("" + mListener.getTourney().getP10Points());

        if (mListener.getDelete()> 0){
            Button delBtn = (Button) getView().findViewById(R.id.tDeleteBtn);
            delBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(TAG, "Delete");
                    mListener.deleteTourney();
                }
            });
        }
    }
}
