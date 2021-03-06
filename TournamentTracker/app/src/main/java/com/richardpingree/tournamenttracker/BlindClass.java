package com.richardpingree.tournamenttracker;

import java.io.Serializable;

/**
 * Created by Richard Pingree APD2 1505 on 5/20/15.
 */
public class BlindClass implements Serializable{

    public int mTimer;
    public int mSmallBlind;
    public int mBigBlind;

    public BlindClass(){

    }

    public BlindClass(int time, int sBlind, int bBlind){
        mTimer = time;
        mSmallBlind = sBlind;
        mBigBlind = bBlind;
    }

    public int getmTimer(){
        return mTimer * 60 * 1000;
    }

    public void setmTimer(){
        this.mTimer = mTimer;
    }

    public int getmSmallBlind(){
        return mSmallBlind;
    }

    public void setmSmallBlind(){
        this.mSmallBlind = mSmallBlind;
    }

    public int getmBigBlind(){
        return mBigBlind;
    }

    public void setmBigBlind(){
        this.mBigBlind = mBigBlind;
    }

    @Override
    public String toString() {
        return "Blind: " + mTimer + " " + "Small Blind: " + mSmallBlind + " " + "Big Blind: " + mBigBlind;
    }
}
