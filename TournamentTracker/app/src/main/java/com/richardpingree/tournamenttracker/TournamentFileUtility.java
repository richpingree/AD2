package com.richardpingree.tournamenttracker;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Richard Pingree APD2 1505 on 5/15/15.
 */
public class TournamentFileUtility {

    public static void tourneySave(Context context, TournamentClass tournament){


        ArrayList<TournamentClass> tournamentArrayList = tourneyLoad(context);

        if (tournamentArrayList == null){
            tournamentArrayList = new ArrayList<TournamentClass>();

        }

        tournamentArrayList.add(tournament);

        try{
            FileOutputStream fos = context.openFileOutput("tournaments", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tournamentArrayList);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<TournamentClass> tourneyLoad(Context context) {
        ArrayList<TournamentClass> tournamentArrayList = null;
        try{
            FileInputStream fis = context.openFileInput("tournaments");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tournamentArrayList = (ArrayList<TournamentClass>) ois.readObject();
            ois.close();
            if (tournamentArrayList == null){
                tournamentArrayList = new ArrayList<TournamentClass>();
                return tournamentArrayList;
            }else{
                return tournamentArrayList;
            }

        }catch(Exception e){
            return null;
        }

    }
}
