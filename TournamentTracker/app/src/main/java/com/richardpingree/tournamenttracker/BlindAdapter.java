package com.richardpingree.tournamenttracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Richard Pingree APF2 1505 on 5/20/15.
 */
public class BlindAdapter extends BaseAdapter {

    private  static final long ID_CONSTANT = 0x000000;

    Context mContext;
    ArrayList<BlindClass> mBlinds;

    public BlindAdapter(Context context, ArrayList<BlindClass> blinds){
        mContext = context;
        mBlinds = blinds;
    }

    @Override
    public int getCount() {
        return mBlinds.size();
    }

    @Override
    public BlindClass getItem(int position) {
        return mBlinds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ID_CONSTANT + position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.blind_list_item, parent,false);
        }
        BlindClass blind = getItem(position);
        TextView tv = (TextView) convertView.findViewById(R.id.blindTime);
        tv.setText(blind.getmTimer());
        tv = (TextView) convertView.findViewById(R.id.smallBlind);
        tv.setText(blind.getmSmallBlind());
        tv = (TextView) convertView.findViewById(R.id.bigBlind);
        tv.setText(blind.getmBigBlind());
        return convertView;
    }
}
