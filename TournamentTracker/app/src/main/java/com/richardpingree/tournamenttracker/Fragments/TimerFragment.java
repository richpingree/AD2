package com.richardpingree.tournamenttracker.Fragments;

import android.app.Fragment;
import android.content.Intent;
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

import com.richardpingree.tournamenttracker.BlindListActivity;
import com.richardpingree.tournamenttracker.R;

import java.util.concurrent.TimeUnit;

/**
 * Created by richardpingree on 5/18/15.
 */
public class TimerFragment extends Fragment {

    private final String TAG = "TimerFragment.TAG";

    private CountDownTimer countDownTimer;
    private final long startTime = 1800 * 1000;
    private final long interval = 1 * 1000;
    TextView timer, smallBlind, bigBlind;
    ImageButton prevBtn, playBtn, pauseBtn, nextBtn;
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

        countDownTimer = new MyCountDownTimer(startTime, interval);

        timer = (TextView)getView().findViewById(R.id.timerView);
        timer.setText(""+String.format("%d:00", TimeUnit.MILLISECONDS.toMinutes(startTime)));
        prevBtn = (ImageButton)getView().findViewById(R.id.previousBtn);
        playBtn = (ImageButton)getView().findViewById(R.id.playBtn);
        pauseBtn = (ImageButton)getView().findViewById(R.id.pauseBtn);
        nextBtn = (ImageButton)getView().findViewById(R.id.nextBtn);
        smallBlind = (TextView)getView().findViewById(R.id.smallBlindValue);
        bigBlind = (TextView)getView().findViewById(R.id.bigBlindValue);
        resetButton = (Button)getView().findViewById(R.id.resetBtn);

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();

            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.onTick(startTime);
            }
        });

    }

    public class MyCountDownTimer extends CountDownTimer{

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
            //timer.setText("" + millisUntilFinished/1000);
            //timer.setText((millisUntilFinished/60000)+ ":" +(millisUntilFinished % 60000/1000));
//            timer.setText(""+String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
//                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
//                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            timer.setText(""+String.format("%d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
        }

        @Override
        public void onFinish() {

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
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
