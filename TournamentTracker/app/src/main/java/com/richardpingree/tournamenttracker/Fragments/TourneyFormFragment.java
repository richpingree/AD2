package com.richardpingree.tournamenttracker.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.richardpingree.tournamenttracker.R;
import com.richardpingree.tournamenttracker.TournamentClass;

/**
 * Created by Richard Pingree APD2 1505 on 5/14/15.
 */
public class TourneyFormFragment extends Fragment{

    private final String TAG = "TourneyFormFragment.TAG";

    public EditText tNameInput, p1NameInput, p1PayoutInput, p1PointsInput,
            p2NameInput, p2PayoutInput, p2PointsInput, p3NameInput, p3PayoutInput, p3PointsInput,
            p4NameInput, p4PayoutInput, p4PointsInput, p5NameInput, p5PayoutInput, p5PointsInput,
            p6NameInput, p6PayoutInput, p6PointsInput, p7NameInput, p7PayoutInput, p7PointsInput,
            p8NameInput, p8PayoutInput, p8PointsInput, p9NameInput, p9PayoutInput, p9PointsInput,
            p10NameInput, p10PayoutInput, p10PointsInput;

    public Button save, cancel;

    public String noPlayer = "No Player";

    public TournamentClass newTournament;

    private TourneyFormListener mListener;

    public interface TourneyFormListener{
        public void addTourney(TournamentClass newTournament);
        public void cancelTourney();
    }

    public TourneyFormFragment(){

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof TourneyFormListener){
            mListener = (TourneyFormListener) activity;
        }else{
            throw new IllegalArgumentException("Containing activity must implement TourneyFormListener interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tourneyform, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Tournament Input
        tNameInput = (EditText)getView().findViewById(R.id.tourneyInput);
        tNameInput.setText("No Title Entered");
        //Player 1 Inputs
        p1NameInput = (EditText)getView().findViewById(R.id.p1NameInput);
        p1NameInput.setText(noPlayer);
        p1PayoutInput = (EditText)getView().findViewById(R.id.p1PayoutInput);
        p1PayoutInput.setText(String.valueOf(0));
        p1PointsInput = (EditText)getView().findViewById(R.id.p1PointsInput);
        p1PointsInput.setText(String.valueOf(0));
        //Player 2 Inputs
        p2NameInput = (EditText)getView().findViewById(R.id.p2NameInput);
        p2NameInput.setText(noPlayer);
        p2PayoutInput = (EditText)getView().findViewById(R.id.p2PayoutInput);
        p2PayoutInput.setText(String.valueOf(0));
        p2PointsInput = (EditText)getView().findViewById(R.id.p2PointsInput);
        p2PointsInput.setText(String.valueOf(0));
        //Player 3 Inputs
        p3NameInput = (EditText)getView().findViewById(R.id.p3NameInput);
        p3NameInput.setText(noPlayer);
        p3PayoutInput = (EditText)getView().findViewById(R.id.p3PayoutInput);
        p3PayoutInput.setText(String.valueOf(0));
        p3PointsInput = (EditText)getView().findViewById(R.id.p3PointsInput);
        p3PointsInput.setText(String.valueOf(0));
        //Player 4 Inputs
        p4NameInput = (EditText)getView().findViewById(R.id.p4NameInput);
        p4NameInput.setText(noPlayer);
        p4PayoutInput = (EditText)getView().findViewById(R.id.p4PayoutInput);
        p4PayoutInput.setText(String.valueOf(0));
        p4PointsInput = (EditText)getView().findViewById(R.id.p4PointsInput);
        p4PointsInput.setText(String.valueOf(0));
        //Player 5 Inputs
        p5NameInput = (EditText)getView().findViewById(R.id.p5NameInput);
        p5NameInput.setText(noPlayer);
        p5PayoutInput = (EditText)getView().findViewById(R.id.p5PayoutInput);
        p5PayoutInput.setText(String.valueOf(0));
        p5PointsInput = (EditText)getView().findViewById(R.id.p5PointsInput);
        p5PointsInput.setText(String.valueOf(0));
        //Player 6 Inputs
        p6NameInput = (EditText)getView().findViewById(R.id.p6NameInput);
        p6NameInput.setText(noPlayer);
        p6PayoutInput = (EditText)getView().findViewById(R.id.p6PayoutInput);
        p6PayoutInput.setText(String.valueOf(0));
        p6PointsInput = (EditText)getView().findViewById(R.id.p6PointsInput);
        p6PointsInput.setText(String.valueOf(0));
        //Player 7 Inputs
        p7NameInput = (EditText)getView().findViewById(R.id.p7NameInput);
        p7NameInput.setText(noPlayer);
        p7PayoutInput = (EditText)getView().findViewById(R.id.p7PayoutInput);
        p7PayoutInput.setText(String.valueOf(0));
        p7PointsInput = (EditText)getView().findViewById(R.id.p7PointsInput);
        p7PointsInput.setText(String.valueOf(0));
        //Player 8 Inputs
        p8NameInput = (EditText)getView().findViewById(R.id.p8NameInput);
        p8NameInput.setText(noPlayer);
        p8PayoutInput = (EditText)getView().findViewById(R.id.p8PayoutInput);
        p8PayoutInput.setText(String.valueOf(0));
        p8PointsInput = (EditText)getView().findViewById(R.id.p8PointsInput);
        p8PointsInput.setText(String.valueOf(0));
        //Player 9 Inputs
        p9NameInput = (EditText)getView().findViewById(R.id.p9NameInput);
        p9NameInput.setText(noPlayer);
        p9PayoutInput = (EditText)getView().findViewById(R.id.p9PayoutInput);
        p9PayoutInput.setText(String.valueOf(0));
        p9PointsInput = (EditText)getView().findViewById(R.id.p9PointsInput);
        p9PointsInput.setText(String.valueOf(0));
        //Player 10 Inputs
        p10NameInput = (EditText)getView().findViewById(R.id.p10NameInput);
        p10NameInput.setText(noPlayer);
        p10PayoutInput = (EditText)getView().findViewById(R.id.p10PayoutInput);
        p10PayoutInput.setText(String.valueOf(0));
        p10PointsInput = (EditText)getView().findViewById(R.id.p10PointsInput);
        p10PointsInput.setText(String.valueOf(0));

        save = (Button)getView().findViewById(R.id.saveBtn);
        cancel = (Button)getView().findViewById(R.id.cancelBtn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newTournament = new TournamentClass();

                if (tNameInput.getText().toString().isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Tournament Title is REQUIRED!").setNegativeButton(R.string.action_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();

                }else{
                    newTournament.tournyName = tNameInput.getText().toString();
                    Log.i(TAG, newTournament.tournyName);
                }
                //player1
                if (p1NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p1Name = p1NameInput.getText().toString();
                    Log.i(TAG, newTournament.p1Name);
                }
                if (p1PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p1Payout = Integer.valueOf(p1PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p1Payout));
                }
                if (p1PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p1Points = Integer.valueOf(p1PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p1Points));
                }
                //player2
                if (p2NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p2Name = p2NameInput.getText().toString();
                    Log.i(TAG, newTournament.p2Name);
                }
                if (p2PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p2Payout = Integer.valueOf(p2PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p2Payout));
                }
                if (p2PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p2Points = Integer.valueOf(p2PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p2Points));
                }
                //player3
                if (p3NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p3Name = p3NameInput.getText().toString();
                    Log.i(TAG, newTournament.p3Name);
                }
                if (p3PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p3Payout = Integer.valueOf(p3PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p3Payout));
                }
                if (p3PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p3Points = Integer.valueOf(p3PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p3Points));
                }
                //player4
                if (p4NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p4Name = p4NameInput.getText().toString();
                    Log.i(TAG, newTournament.p4Name);
                }
                if (p4PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p4Payout = Integer.valueOf(p4PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p4Payout));
                }
                if (p2PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p4Points = Integer.valueOf(p4PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p4Points));
                }
                //player5
                if (p5NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p5Name = p5NameInput.getText().toString();
                    Log.i(TAG, newTournament.p5Name);
                }
                if (p5PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p5Payout = Integer.valueOf(p5PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p5Payout));
                }
                if (p5PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p5Points = Integer.valueOf(p5PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p5Points));
                }
                //player6
                if (p6NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p6Name = p6NameInput.getText().toString();
                    Log.i(TAG, newTournament.p6Name);
                }
                if (p6PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p6Payout = Integer.valueOf(p6PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p6Payout));
                }
                if (p6PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p6Points = Integer.valueOf(p6PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p6Points));
                }
                //player7
                if (p7NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p7Name = p7NameInput.getText().toString();
                    Log.i(TAG, newTournament.p7Name);
                }
                if (p7PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p7Payout = Integer.valueOf(p7PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p7Payout));
                }
                if (p7PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p7Points = Integer.valueOf(p7PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p7Points));
                }
                //player8
                if (p8NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p8Name = p8NameInput.getText().toString();
                    Log.i(TAG, newTournament.p8Name);
                }
                if (p8PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p8Payout = Integer.valueOf(p8PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p8Payout));
                }
                if (p8PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p8Points = Integer.valueOf(p8PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p8Points));
                }
                //player9
                if (p9NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p9Name = p9NameInput.getText().toString();
                    Log.i(TAG, newTournament.p9Name);
                }
                if (p9PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p9Payout = Integer.valueOf(p9PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p9Payout));
                }
                if (p9PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p9Points = Integer.valueOf(p9PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p9Points));
                }
                //player10
                if (p10NameInput.getText().toString().isEmpty()){
                    playerInputAlert();

                }else{
                    newTournament.p10Name = p10NameInput.getText().toString();
                    Log.i(TAG, newTournament.p10Name);
                }
                if (p10PayoutInput.getText().toString().isEmpty()){
                    payoutInputAlert();
                }else{
                    newTournament.p10Payout = Integer.valueOf(p10PayoutInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p10Payout));
                }
                if (p10PointsInput.getText().toString().isEmpty()){
                    pointsInputAlert();
                }else{
                    newTournament.p10Points = Integer.valueOf(p10PointsInput.getText().toString());
                    Log.i(TAG, String.valueOf(newTournament.p10Points));
                }
                mListener.addTourney(newTournament);
                //TournamentFileUtility.tourneySave(getActivity(), newTournament);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.cancelTourney();

            }
        });
    }

    public void playerInputAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("All player names are REQUIRED!").setNegativeButton(R.string.action_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public void payoutInputAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("All payouts inputs are REQUIRED!").setNegativeButton(R.string.action_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    public void pointsInputAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("All points inputs are REQUIRED!").setNegativeButton(R.string.action_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
