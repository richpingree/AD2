package com.richardpingree.tournamenttracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Richard Pingree APD2 1505 on 5/14/15.
 */
public class TournamentAdapter extends BaseAdapter{

    private static final long ID_CONSTANT = 0x000000;

    Context mContext;
    ArrayList<TournamentClass> mTourneys;

    public TournamentAdapter(Context context, ArrayList<TournamentClass> tourneys){
        mContext = context;
        mTourneys = tourneys;
    }

    @Override
    public int getCount() {
        return mTourneys.size();
    }

    @Override
    public TournamentClass getItem(int position) {
        return mTourneys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ID_CONSTANT + position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.tourney_list_item, parent, false);
        }
        TournamentClass tourney = getItem(position);
        TextView tourneyText = (TextView) convertView.findViewById(R.id.tournamentName);
        tourneyText.setText(tourney.getTournyName());
        return convertView;
    }
}
