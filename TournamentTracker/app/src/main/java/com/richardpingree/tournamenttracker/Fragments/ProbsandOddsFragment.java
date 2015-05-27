package com.richardpingree.tournamenttracker.Fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richardpingree.tournamenttracker.R;

/**
 * Created by Richard Pingree APD2 1505 on 5/27/15.
 */
public class ProbsandOddsFragment extends Fragment {

    private final String TAG = "Probs&Odds.Frag";

    TextView po1title, po1name1, po1prob1, po1odd1, po1name2, po1prob2, po1odd2, po1name3, po1prob3, po1odd3,
            po1name4, po1prob4, po1odd4, po1name5, po1prob5, po1odd5, po1name6, po1prob6, po1odd6,
            po1name7, po1prob7, po1odd7, po1name8, po1prob8, po1odd8, po1name9, po1prob9, po1odd9,
            po1name10, po1prob10, po1odd10, po1name11, po1prob11, po1odd11, po1name12, po1prob12, po1odd12,
            po1name13, po1prob13, po1odd13, po1name14, po1prob14, po1odd14, po1name15, po1prob15, po1odd15,
            po1name16, po1prob16, po1odd16, po1name17, po1prob17, po1odd17, po1name18, po1prob18, po1odd18,
            po2title, po2name1, po2prob1, po2odd1, po2name2, po2prob2, po2odd2, po2name3, po2prob3, po2odd3,
            po2name4, po2prob4, po2odd4, po3title, po3name1, po3prob1, po3odd1, po3name2, po3prob2, po3odd2,
            po3name3, po3prob3, po3odd3, po3name4, po3prob4, po3odd4, po3name5, po3prob5, po3odd5,
            po3name6, po3prob6, po3odd6, po3name7, po3prob7, po3odd7, po3name8, po3prob8, po3odd8,
            po3name9, po3prob9, po3odd9, po3name10, po3prob10, po3odd10, po3name11, po3prob11, po3odd11,
            po3name12, po3prob12, po3odd12, po3name13, po3prob13, po3odd13;

    public ProbsandOddsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_probsodds, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        po1title = (TextView)getView().findViewById(R.id.POtitle1);
        po1title.setTextColor(Color.BLACK);
        po1title.setText("Odds of being dealt certain starting hands");

        po1name1 = (TextView)getView().findViewById(R.id.po1name1);
        po1name1.setTextColor(Color.WHITE);
        po1name1.setText("A-Ks or any specific suited cards");
        po1prob1 = (TextView)getView().findViewById(R.id.po1prob1);
        po1prob1.setTextColor(Color.WHITE);
        po1prob1.setText(".3");
        po1odd1 = (TextView)getView().findViewById(R.id.po1odd1);
        po1odd1.setTextColor(Color.WHITE);
        po1odd1.setText("331-1");

        po1name2 = (TextView)getView().findViewById(R.id.po1name2);
        po1name2.setTextColor(Color.WHITE);
        po1name2.setText("A-A or any specific pair");
        po1prob2 = (TextView)getView().findViewById(R.id.po1prob2);
        po1prob2.setTextColor(Color.WHITE);
        po1prob2.setText(".4");
        po1odd2 = (TextView)getView().findViewById(R.id.po1odd2);
        po1odd2.setTextColor(Color.WHITE);
        po1odd2.setText("220-1");

        po1name3 = (TextView)getView().findViewById(R.id.po1name3);
        po1name3.setTextColor(Color.WHITE);
        po1name3.setText("A-Ks, K-Qs, Q-Js, \n or J-10s (suited cards)");
        po1prob3 = (TextView)getView().findViewById(R.id.po1prob3);
        po1prob3.setTextColor(Color.WHITE);
        po1prob3.setText("1.2");
        po1odd3 = (TextView)getView().findViewById(R.id.po1odd3);
        po1odd3.setTextColor(Color.WHITE);
        po1odd3.setText("81.9-1");

        po1name4 = (TextView)getView().findViewById(R.id.po1name4);
        po1name4.setTextColor(Color.WHITE);
        po1name4.setText("A-K or any specific \n non-pair, incl. suited");
        po1prob4 = (TextView)getView().findViewById(R.id.po1prob4);
        po1prob4.setTextColor(Color.WHITE);
        po1prob4.setText("1.2");
        po1odd4 = (TextView)getView().findViewById(R.id.po1odd4);
        po1odd4.setTextColor(Color.WHITE);
        po1odd4.setText("81.9-1");

        po1name5 = (TextView)getView().findViewById(R.id.po1name5);
        po1name5.setTextColor(Color.WHITE);
        po1name5.setText("A-A, K-K, or Q-Q");
        po1prob5 = (TextView)getView().findViewById(R.id.po1prob5);
        po1prob5.setTextColor(Color.WHITE);
        po1prob5.setText("1.3");
        po1odd5 = (TextView)getView().findViewById(R.id.po1odd5);
        po1odd5.setTextColor(Color.WHITE);
        po1odd5.setText("72.7-1");

        po1name6 = (TextView)getView().findViewById(R.id.po1name6);
        po1name6.setTextColor(Color.WHITE);
        po1name6.setText("A-A, K-K, Q-Q, or J-J");
        po1prob6 = (TextView)getView().findViewById(R.id.po1prob6);
        po1prob6.setTextColor(Color.WHITE);
        po1prob6.setText("1.8");
        po1odd6 = (TextView)getView().findViewById(R.id.po1odd6);
        po1odd6.setTextColor(Color.WHITE);
        po1odd6.setText("54.3-1");

        po1name7 = (TextView)getView().findViewById(R.id.po1name7);
        po1name7.setTextColor(Color.WHITE);
        po1name7.setText("Suited cards, jack or better");
        po1prob7 = (TextView)getView().findViewById(R.id.po1prob7);
        po1prob7.setTextColor(Color.WHITE);
        po1prob7.setText("1.8");
        po1odd7 = (TextView)getView().findViewById(R.id.po1odd7);
        po1odd7.setTextColor(Color.WHITE);
        po1odd7.setText("54.3-1");

        po1name8 = (TextView)getView().findViewById(R.id.po1name8);
        po1name8.setTextColor(Color.WHITE);
        po1name8.setText("A-A, K-K, Q-Q, J-J, 10-10");
        po1prob8 = (TextView)getView().findViewById(R.id.po1prob8);
        po1prob8.setTextColor(Color.WHITE);
        po1prob8.setText("2.2");
        po1odd8 = (TextView)getView().findViewById(R.id.po1odd8);
        po1odd8.setTextColor(Color.WHITE);
        po1odd8.setText("43.2-1");

        po1name9 = (TextView)getView().findViewById(R.id.po1name9);
        po1name9.setTextColor(Color.WHITE);
        po1name9.setText("Suited cards, 10 or better");
        po1prob9 = (TextView)getView().findViewById(R.id.po1prob9);
        po1prob9.setTextColor(Color.WHITE);
        po1prob9.setText("3");
        po1odd9 = (TextView)getView().findViewById(R.id.po1odd9);
        po1odd9.setTextColor(Color.WHITE);
        po1odd9.setText("32.2-1");

        po1name10 = (TextView)getView().findViewById(R.id.po1name10);
        po1name10.setTextColor(Color.WHITE);
        po1name10.setText("Suited connectors");
        po1prob10 = (TextView)getView().findViewById(R.id.po1prob10);
        po1prob10.setTextColor(Color.WHITE);
        po1prob10.setText("3.9");
        po1odd10 = (TextView)getView().findViewById(R.id.po1odd10);
        po1odd10.setTextColor(Color.WHITE);
        po1odd10.setText("24.5-1");

        po1name11 = (TextView)getView().findViewById(R.id.po1name11);
        po1name11.setTextColor(Color.WHITE);
        po1name11.setText("Connected cards, 10 or better");
        po1prob11 = (TextView)getView().findViewById(R.id.po1prob11);
        po1prob11.setTextColor(Color.WHITE);
        po1prob11.setText("4.8");
        po1odd11 = (TextView)getView().findViewById(R.id.po1odd11);
        po1odd11.setTextColor(Color.WHITE);
        po1odd11.setText("19.7-1");

        po1name12 = (TextView)getView().findViewById(R.id.po1name12);
        po1name12.setTextColor(Color.WHITE);
        po1name12.setText("Any two cards with \n rank at least queen");
        po1prob12 = (TextView)getView().findViewById(R.id.po1prob12);
        po1prob12.setTextColor(Color.WHITE);
        po1prob12.setText("4.9");
        po1odd12 = (TextView)getView().findViewById(R.id.po1odd12);
        po1odd12.setTextColor(Color.WHITE);
        po1odd12.setText("19.1-1");

        po1name13 = (TextView)getView().findViewById(R.id.po1name13);
        po1name13.setTextColor(Color.WHITE);
        po1name13.setText("Any pocket pair");
        po1prob13 = (TextView)getView().findViewById(R.id.po1prob13);
        po1prob13.setTextColor(Color.WHITE);
        po1prob13.setText("5.8");
        po1odd13 = (TextView)getView().findViewById(R.id.po1odd13);
        po1odd13.setTextColor(Color.WHITE);
        po1odd13.setText("16-1");

        po1name14 = (TextView)getView().findViewById(R.id.po1name14);
        po1name14.setTextColor(Color.WHITE);
        po1name14.setText("Any two cards with \n rank at least jack");
        po1prob14 = (TextView)getView().findViewById(R.id.po1prob14);
        po1prob14.setTextColor(Color.WHITE);
        po1prob14.setText("9");
        po1odd14 = (TextView)getView().findViewById(R.id.po1odd14);
        po1odd14.setTextColor(Color.WHITE);
        po1odd14.setText("10.1-1");

        po1name15 = (TextView)getView().findViewById(R.id.po1name15);
        po1name15.setTextColor(Color.WHITE);
        po1name15.setText("Any two cards with \n rank at least 10");
        po1prob15 = (TextView)getView().findViewById(R.id.po1prob15);
        po1prob15.setTextColor(Color.WHITE);
        po1prob15.setText("14.3");
        po1odd15 = (TextView)getView().findViewById(R.id.po1odd15);
        po1odd15.setTextColor(Color.WHITE);
        po1odd15.setText("5.98-1");

        po1name16 = (TextView)getView().findViewById(R.id.po1name16);
        po1name16.setTextColor(Color.WHITE);
        po1name16.setText("Connected cards \n (cards of consecutive rank");
        po1prob16 = (TextView)getView().findViewById(R.id.po1prob16);
        po1prob16.setTextColor(Color.WHITE);
        po1prob16.setText("15.7");
        po1odd16 = (TextView)getView().findViewById(R.id.po1odd16);
        po1odd16.setTextColor(Color.WHITE);
        po1odd16.setText("5.38-1");

        po1name17 = (TextView)getView().findViewById(R.id.po1name17);
        po1name17.setTextColor(Color.WHITE);
        po1name17.setText("Any two cards with \n rank of at least 9");
        po1prob17 = (TextView)getView().findViewById(R.id.po1prob17);
        po1prob17.setTextColor(Color.WHITE);
        po1prob17.setText("20.8");
        po1odd17 = (TextView)getView().findViewById(R.id.po1odd17);
        po1odd17.setTextColor(Color.WHITE);
        po1odd17.setText("3.81-1");

        po1name18 = (TextView)getView().findViewById(R.id.po1name18);
        po1name18.setTextColor(Color.WHITE);
        po1name18.setText("Neither connected nor suited, \n at least one 2-9");
        po1prob18 = (TextView)getView().findViewById(R.id.po1prob18);
        po1prob18.setTextColor(Color.WHITE);
        po1prob18.setText("53.4");
        po1odd18 = (TextView)getView().findViewById(R.id.po1odd18);
        po1odd18.setTextColor(Color.WHITE);
        po1odd18.setText("0.873-1");

        po2title = (TextView)getView().findViewById(R.id.POtitle2);
        po2title.setTextColor(Color.BLACK);
        po2title.setText("Odds Against Flopping");

        po2name1 = (TextView)getView().findViewById(R.id.po2name1);
        po2name1.setTextColor(Color.WHITE);
        po2name1.setText("A flush");
        po2prob1 = (TextView)getView().findViewById(R.id.po2prob1);
        po2prob1.setTextColor(Color.WHITE);
        po2prob1.setText("118-1");
        po2odd1 = (TextView)getView().findViewById(R.id.po2odd1);
        po2odd1.setTextColor(Color.WHITE);
        po2odd1.setText("0.8%");

        po2name2 = (TextView)getView().findViewById(R.id.po2name2);
        po2name2.setTextColor(Color.WHITE);
        po2name2.setText("A straight when holding \n any two connecting cards \n J-10 through 5-4");
        po2prob2 = (TextView)getView().findViewById(R.id.po2prob2);
        po2prob2.setTextColor(Color.WHITE);
        po2prob2.setText("76-1");
        po2odd2 = (TextView)getView().findViewById(R.id.po2odd2);
        po2odd2.setTextColor(Color.WHITE);
        po2odd2.setText("1.3%");

        po2name3 = (TextView)getView().findViewById(R.id.po2name3);
        po2name3.setTextColor(Color.WHITE);
        po2name3.setText("Three of a kind when \n holding a pocket pair");
        po2prob3 = (TextView)getView().findViewById(R.id.po2prob3);
        po2prob3.setTextColor(Color.WHITE);
        po2prob3.setText("7.5-1");
        po2odd3 = (TextView)getView().findViewById(R.id.po2odd3);
        po2odd3.setTextColor(Color.WHITE);
        po2odd3.setText("11.8%");

        po2name4 = (TextView)getView().findViewById(R.id.po2name4);
        po2name4.setTextColor(Color.WHITE);
        po2name4.setText("A pair \n (matching one of your holecards)");
        po2prob4 = (TextView)getView().findViewById(R.id.po2prob4);
        po2prob4.setTextColor(Color.WHITE);
        po2prob4.setText("2.45-1");
        po2odd4 = (TextView)getView().findViewById(R.id.po2odd4);
        po2odd4.setTextColor(Color.WHITE);
        po2odd4.setText("29%");

        po3title = (TextView)getView().findViewById(R.id.POtitle3);
        po3title.setTextColor(Color.BLACK);
        po3title.setText("Chance of an over card when holding a pocket pair");

        po3name1 = (TextView)getView().findViewById(R.id.po3name1);
        po3name1.setTextColor(Color.WHITE);
        po3name1.setText("2-2");
        po3prob1 = (TextView)getView().findViewById(R.id.po3prob1);
        po3prob1.setTextColor(Color.WHITE);
        po3prob1.setText("100%");
        po3odd1 = (TextView)getView().findViewById(R.id.po3odd1);
        po3odd1.setTextColor(Color.WHITE);
        po3odd1.setText("100%");

        po3name2 = (TextView)getView().findViewById(R.id.po3name2);
        po3name2.setTextColor(Color.WHITE);
        po3name2.setText("3-3");
        po3prob2 = (TextView)getView().findViewById(R.id.po3prob2);
        po3prob2.setTextColor(Color.WHITE);
        po3prob2.setText("99.9%");
        po3odd2 = (TextView)getView().findViewById(R.id.po3odd2);
        po3odd2.setTextColor(Color.WHITE);
        po3odd2.setText("99.9997%");

        po3name3 = (TextView)getView().findViewById(R.id.po3name3);
        po3name3.setTextColor(Color.WHITE);
        po3name3.setText("4-4");
        po3prob3 = (TextView)getView().findViewById(R.id.po3prob3);
        po3prob3.setTextColor(Color.WHITE);
        po3prob3.setText("99.4%");
        po3odd3 = (TextView)getView().findViewById(R.id.po3odd3);
        po3odd3.setTextColor(Color.WHITE);
        po3odd3.setText("99.988%");

        po3name4 = (TextView)getView().findViewById(R.id.po3name4);
        po3name4.setTextColor(Color.WHITE);
        po3name4.setText("5-5");
        po3prob4 = (TextView)getView().findViewById(R.id.po3prob4);
        po3prob4.setTextColor(Color.WHITE);
        po3prob4.setText("98.1%");
        po3odd4 = (TextView)getView().findViewById(R.id.po3odd4);
        po3odd4.setTextColor(Color.WHITE);
        po3odd4.setText("99.91%");

        po3name5 = (TextView)getView().findViewById(R.id.po3name5);
        po3name5.setTextColor(Color.WHITE);
        po3name5.setText("6-6");
        po3prob5 = (TextView)getView().findViewById(R.id.po3prob5);
        po3prob5.setTextColor(Color.WHITE);
        po3prob5.setText("95.8%");
        po3odd5 = (TextView)getView().findViewById(R.id.po3odd5);
        po3odd5.setTextColor(Color.WHITE);
        po3odd5.setText("99.6%");

        po3name6 = (TextView)getView().findViewById(R.id.po3name6);
        po3name6.setTextColor(Color.WHITE);
        po3name6.setText("7-7");
        po3prob6 = (TextView)getView().findViewById(R.id.po3prob6);
        po3prob6.setTextColor(Color.WHITE);
        po3prob6.setText("92.1%");
        po3odd6 = (TextView)getView().findViewById(R.id.po3odd6);
        po3odd6.setTextColor(Color.WHITE);
        po3odd6.setText("98.8%");

        po3name7 = (TextView)getView().findViewById(R.id.po3name7);
        po3name7.setTextColor(Color.WHITE);
        po3name7.setText("8-8");
        po3prob7 = (TextView)getView().findViewById(R.id.po3prob7);
        po3prob7.setTextColor(Color.WHITE);
        po3prob7.setText("86.7%");
        po3odd7 = (TextView)getView().findViewById(R.id.po3odd7);
        po3odd7.setTextColor(Color.WHITE);
        po3odd7.setText("96.9%");

        po3name8 = (TextView)getView().findViewById(R.id.po3name8);
        po3name8.setTextColor(Color.WHITE);
        po3name8.setText("9-9");
        po3prob8 = (TextView)getView().findViewById(R.id.po3prob8);
        po3prob8.setTextColor(Color.WHITE);
        po3prob8.setText("79.3%");
        po3odd8 = (TextView)getView().findViewById(R.id.po3odd8);
        po3odd8.setTextColor(Color.WHITE);
        po3odd8.setText("93.3%");

        po3name9 = (TextView)getView().findViewById(R.id.po3name9);
        po3name9.setTextColor(Color.WHITE);
        po3name9.setText("10-10");
        po3prob9 = (TextView)getView().findViewById(R.id.po3prob9);
        po3prob9.setTextColor(Color.WHITE);
        po3prob9.setText("69.5%");
        po3odd9 = (TextView)getView().findViewById(R.id.po3odd9);
        po3odd9.setTextColor(Color.WHITE);
        po3odd9.setText("86.9%");

        po3name10 = (TextView)getView().findViewById(R.id.po3name10);
        po3name10.setTextColor(Color.WHITE);
        po3name10.setText("J-J");
        po3prob10 = (TextView)getView().findViewById(R.id.po3prob10);
        po3prob10.setTextColor(Color.WHITE);
        po3prob10.setText("57%");
        po3odd10 = (TextView)getView().findViewById(R.id.po3odd10);
        po3odd10.setTextColor(Color.WHITE);
        po3odd10.setText("76.3%");

        po3name11 = (TextView)getView().findViewById(R.id.po3name11);
        po3name11.setTextColor(Color.WHITE);
        po3name11.setText("Q-Q");
        po3prob11 = (TextView)getView().findViewById(R.id.po3prob11);
        po3prob11.setTextColor(Color.WHITE);
        po3prob11.setText("41.4%");
        po3odd11 = (TextView)getView().findViewById(R.id.po3odd11);
        po3odd11.setTextColor(Color.WHITE);
        po3odd11.setText("59.9%");

        po3name12 = (TextView)getView().findViewById(R.id.po3name12);
        po3name12.setTextColor(Color.WHITE);
        po3name12.setText("K-K");
        po3prob12 = (TextView)getView().findViewById(R.id.po3prob12);
        po3prob12.setTextColor(Color.WHITE);
        po3prob12.setText("22.6%");
        po3odd12 = (TextView)getView().findViewById(R.id.po3odd12);
        po3odd12.setTextColor(Color.WHITE);
        po3odd12.setText("35.3%");

        po3name13 = (TextView)getView().findViewById(R.id.po3name13);
        po3name13.setTextColor(Color.WHITE);
        po3name13.setText("A-A");
        po3prob13 = (TextView)getView().findViewById(R.id.po3prob13);
        po3prob13.setTextColor(Color.WHITE);
        po3prob13.setText("0%");
        po3odd13 = (TextView)getView().findViewById(R.id.po3odd13);
        po3odd13.setTextColor(Color.WHITE);
        po3odd13.setText("0%");

    }
}