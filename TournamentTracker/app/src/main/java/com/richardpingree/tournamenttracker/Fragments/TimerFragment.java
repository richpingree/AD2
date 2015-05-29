package com.richardpingree.tournamenttracker.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.richardpingree.tournamenttracker.BlindClass;
import com.richardpingree.tournamenttracker.BlindListActivity;
import com.richardpingree.tournamenttracker.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Richard Pingree APD2 1505 on 5/18/15.
 */
public class TimerFragment extends Fragment {



    private final String TAG = "TimerFragment.TAG";

    public static final int ADDEXTRAS = 0;
    private TimerListener mListener;
    private CountDownTimer countDownTimer;
    private long startTime = 60 * 1000;
    private final long interval = 1 * 1000;
    private ArrayList<BlindClass> BlindArray;
    public long timeremaining;
    int sBlind, bBlind;
    int currentBlind = 0;
    TextView timer, smallBlind, bigBlind;
    ImageButton prevBtn, playBtn, pauseBtn, nextBtn;
    Button resetButton;

    private MediaPlayer mplayer;

    public interface TimerListener {
        public ArrayList<BlindClass> getBlinds();
    }


    public TimerFragment(){


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        if (activity instanceof TimerListener){
            mListener = (TimerListener) activity;
        }else{
            throw new IllegalArgumentException("Containing activity must implement TimerListener interface");
        }
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

        mplayer = MediaPlayer.create(getActivity(), R.raw.testalarm);



        BlindArray = mListener.getBlinds();

        //Log.i(TAG, String.valueOf(BlindArray.get(0).getmTimer()) + " " + String.valueOf(BlindArray.get(0).getmSmallBlind()) + " " + String.valueOf(BlindArray.get(0).getmBigBlind()));
        if (BlindArray.size() > 0){
            startTime = BlindArray.get(currentBlind).getmTimer();
            sBlind = BlindArray.get(currentBlind).getmSmallBlind();
            bBlind = BlindArray.get(currentBlind).getmBigBlind();

        }
        countDownTimer = new MyCountDownTimer(startTime, interval);

        timer = (TextView)getView().findViewById(R.id.timerView);
        timer.setText(""+String.format("%d:00", TimeUnit.MILLISECONDS.toMinutes(startTime)));

        prevBtn = (ImageButton)getView().findViewById(R.id.previousBtn);
        playBtn = (ImageButton)getView().findViewById(R.id.playBtn);
        pauseBtn = (ImageButton)getView().findViewById(R.id.pauseBtn);
        nextBtn = (ImageButton)getView().findViewById(R.id.nextBtn);
        smallBlind = (TextView)getView().findViewById(R.id.smallBlindValue);
        smallBlind.setText(String.valueOf(sBlind));
        bigBlind = (TextView)getView().findViewById(R.id.bigBlindValue);
        bigBlind.setText(String.valueOf(bBlind));
        resetButton = (Button)getView().findViewById(R.id.resetBtn);

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mplayer.start();
                if (currentBlind >= 1) {
                    currentBlind--;
                    startTime = BlindArray.get(currentBlind).getmTimer();
                    sBlind = BlindArray.get(currentBlind).getmSmallBlind();
                    bBlind = BlindArray.get(currentBlind).getmBigBlind();
                    timer.setText("" + String.format("%d:00", TimeUnit.MILLISECONDS.toMinutes(startTime)));
                    smallBlind.setText(String.valueOf(sBlind));
                    bigBlind.setText(String.valueOf(bBlind));

                }

            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BlindArray.size() > 0){
                    startTime = BlindArray.get(currentBlind).getmTimer();
                    sBlind = BlindArray.get(currentBlind).getmSmallBlind();
                    bBlind = BlindArray.get(currentBlind).getmBigBlind();

                }
                countDownTimer.start();

            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Cancel Button Clicked" + String.valueOf(timeremaining));
                countDownTimer.cancel();
                timer.setText("" + String.format("%d:%02d", TimeUnit.MILLISECONDS.toMinutes(timeremaining),
                        TimeUnit.MILLISECONDS.toSeconds(timeremaining) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeremaining))));
                AlertDialog.Builder pauseAlert = new AlertDialog.Builder(getActivity());
                pauseAlert.setMessage("The Blinds Are Pause!").setPositiveButton("Resume", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       // timer.setText("" + String.format("%d:00", TimeUnit.MILLISECONDS.toMinutes(timeremaining)));
                       // countDownTimer.onTick(startTime - timeremaining);
                        countDownTimer.start();
                    }
                });

                pauseAlert.show();

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mplayer.start();
                if (currentBlind < BlindArray.size() -1) {
                    currentBlind++;
                    startTime = BlindArray.get(currentBlind).getmTimer();
                    sBlind = BlindArray.get(currentBlind).getmSmallBlind();
                    bBlind = BlindArray.get(currentBlind).getmBigBlind();
                    timer.setText("" + String.format("%d:00", TimeUnit.MILLISECONDS.toMinutes(startTime)));
                    smallBlind.setText(String.valueOf(sBlind));
                    bigBlind.setText(String.valueOf(bBlind));
                }


            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BlindArray.size() != 0) {
                    AlertDialog.Builder resetAlert = new AlertDialog.Builder(getActivity());
                    resetAlert.setMessage("Are you sure you want to reset the tournament?").setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            currentBlind = 0;
                            countDownTimer.cancel();
                            startTime = BlindArray.get(currentBlind).getmTimer();
                            sBlind = BlindArray.get(currentBlind).getmSmallBlind();
                            bBlind = BlindArray.get(currentBlind).getmBigBlind();
                            timer.setText("" + String.format("%d:00", TimeUnit.MILLISECONDS.toMinutes(startTime)));
                            smallBlind.setText(String.valueOf(sBlind));
                            bigBlind.setText(String.valueOf(bBlind));
                            countDownTimer.onTick(startTime);
                        }
                    })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    resetAlert.show();
                }else{
                    countDownTimer.cancel();
                    timer.setText("" + String.format("%d:00", TimeUnit.MILLISECONDS.toMinutes(startTime)));
                }
            }
        });

    }

    public class MyCountDownTimer extends CountDownTimer{

        //public long timeremaining;

        /**
         * @param startTime    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param interval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
                timer.setText("" + String.format("%d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));

            timeremaining = millisUntilFinished;

        }

        @Override
        public void onFinish() {

            mplayer.start();
            if (BlindArray.size() > 0) {
                currentBlind++;
                if (currentBlind < BlindArray.size() && currentBlind > 0) {
                    startTime = BlindArray.get(currentBlind).getmTimer();
                    sBlind = BlindArray.get(currentBlind).getmSmallBlind();
                    bBlind = BlindArray.get(currentBlind).getmBigBlind();
                    timer.setText("" + String.format("%d:00", TimeUnit.MILLISECONDS.toMinutes(startTime)));
                    smallBlind.setText(String.valueOf(sBlind));
                    bigBlind.setText(String.valueOf(bBlind));
                    countDownTimer.start();
                }
            }else{
                timer.setText("" + String.format("%d:00", TimeUnit.MILLISECONDS.toMinutes(startTime)));
                countDownTimer.start();
            }
        }
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
                Intent blindListIntent = new Intent(getActivity(), BlindListActivity.class);
                startActivity(blindListIntent);
                getActivity().finish();

                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
