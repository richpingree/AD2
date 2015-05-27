package com.richardpingree.tournamenttracker.Fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.richardpingree.tournamenttracker.R;

/**
 * Created by Richard Pingree APD2 1505 on 5/26/15.
 */
public class PokerHandsFragment extends Fragment{

    private final String TAG = "PokerHandFrag.TAG";

    TextView title, title2, title3, title4, title5, title6, title7, title8, title9, title10,
            royaldesc, straightflushdesc, fourdesc, fulldesc, flushdesc, straightdesc, threedesc, twopairdesc, pairdesc, highcarddesc;

    ImageView royalFlush, straightFlush, fourKind, fullHouse, flush, straight, threeKind, twopair, pair, highcard;

    public PokerHandsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pokerhands, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().getActionBar().setTitle(R.string.title_section4);

        title = (TextView)getView().findViewById(R.id.Title);
        title.setTextColor(Color.WHITE);
        title.setText("Royal Flush");

        royalFlush = (ImageView)getView().findViewById(R.id.royalFlush);
        royalFlush.setImageResource(R.drawable.royalflush);

        royaldesc = (TextView)getView().findViewById(R.id.royaldescription);
        royaldesc.setTextColor(Color.WHITE);
        royaldesc.setText("This hand contains five cards \n in sequence, all of the same suit.");

        title2 = (TextView)getView().findViewById(R.id.Title2);
        title2.setTextColor(Color.WHITE);
        title2.setText("Straight Flush");

        straightFlush = (ImageView)getView().findViewById(R.id.straightFlush);
        straightFlush.setImageResource(R.drawable.straightflush);

        straightflushdesc = (TextView)getView().findViewById(R.id.straightflushdescription);
        straightflushdesc.setTextColor(Color.WHITE);
        straightflushdesc.setText("This hand contains five cards \n in sequence, all of the same suit.");

        title3 = (TextView)getView().findViewById(R.id.Title3);
        title3.setTextColor(Color.WHITE);
        title3.setText("Four of a Kind");

        fourKind = (ImageView)getView().findViewById(R.id.fourKind);
        fourKind.setImageResource(R.drawable.fourofakind);

        fourdesc = (TextView)getView().findViewById(R.id.fourdescription);
        fourdesc.setTextColor(Color.WHITE);
        fourdesc.setText("This hand contains all four cards \n of one rank and any other unmatched card.");

        title4 = (TextView)getView().findViewById(R.id.Title4);
        title4.setTextColor(Color.WHITE);
        title4.setText("Full House");

        fullHouse = (ImageView)getView().findViewById(R.id.fullHouse);
        fullHouse.setImageResource(R.drawable.fullhouse);

        fulldesc = (TextView)getView().findViewById(R.id.fulldescription);
        fulldesc.setTextColor(Color.WHITE);
        fulldesc.setText("This hand contains three matching cards \n and two matching cards of another rank.");

        title5 = (TextView)getView().findViewById(R.id.Title5);
        title5.setTextColor(Color.WHITE);
        title5.setText("Flush");

        flush = (ImageView)getView().findViewById(R.id.flush);
        flush.setImageResource(R.drawable.flush);

        flushdesc = (TextView)getView().findViewById(R.id.flushdescription);
        flushdesc.setTextColor(Color.WHITE);
        flushdesc.setText("This hand contains all five cards \n of the same suit, but not in sequence.");

        title6 = (TextView)getView().findViewById(R.id.Title6);
        title6.setTextColor(Color.WHITE);
        title6.setText("Straight");

        straight = (ImageView)getView().findViewById(R.id.straight);
        straight.setImageResource(R.drawable.straight);

        straightdesc = (TextView)getView().findViewById(R.id.straightdescription);
        straightdesc.setTextColor(Color.WHITE);
        straightdesc.setText("This hand contains five card of sequential \n rank in at least two different suits.");

        title7 = (TextView)getView().findViewById(R.id.Title7);
        title7.setTextColor(Color.WHITE);
        title7.setText("Three of a Kind");

        threeKind = (ImageView)getView().findViewById(R.id.threeKind);
        threeKind.setImageResource(R.drawable.threeofakind);

        threedesc = (TextView)getView().findViewById(R.id.threedescription);
        threedesc.setTextColor(Color.WHITE);
        threedesc.setText("This hand contains three cards of \n the same rank, with two cards not \n of this rank nor the same as each other.");

        title8 = (TextView)getView().findViewById(R.id.Title8);
        title8.setTextColor(Color.WHITE);
        title8.setText("Two Pair");

        twopair = (ImageView)getView().findViewById(R.id.twoPair);
        twopair.setImageResource(R.drawable.twopair);

        twopairdesc = (TextView)getView().findViewById(R.id.twopairdescription);
        twopairdesc.setTextColor(Color.WHITE);
        twopairdesc.setText("This hand contains two cards \n of the same rank, plus \n two cards of another rank.");

        title9 = (TextView)getView().findViewById(R.id.Title9);
        title9.setTextColor(Color.WHITE);
        title9.setText("Pair");

        pair = (ImageView)getView().findViewById(R.id.pair);
        pair.setImageResource(R.drawable.pair);

        pairdesc = (TextView)getView().findViewById(R.id.pairdescription);
        pairdesc.setTextColor(Color.WHITE);
        pairdesc.setText("This hand contains two cards the same rank, \n plus three cards which are not of this \n rank nor the same.");

        title10 = (TextView)getView().findViewById(R.id.Title10);
        title10.setTextColor(Color.WHITE);
        title10.setText("High Card");

        highcard = (ImageView)getView().findViewById(R.id.highcard);
        highcard.setImageResource(R.drawable.highcard);

        highcarddesc = (TextView)getView().findViewById(R.id.highcarddescription);
        highcarddesc.setTextColor(Color.WHITE);
        highcarddesc.setText("This hand contains any five cards not \n meeting any of the above requirements.");
    }
}
