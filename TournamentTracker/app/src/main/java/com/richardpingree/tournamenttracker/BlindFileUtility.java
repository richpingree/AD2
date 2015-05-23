package com.richardpingree.tournamenttracker;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Richard Pingree APD2 1505 on 5/22/15.
 */
public class BlindFileUtility {

//    public static void saveBlinds(Context context, ArrayList<BlindClass> blindArrayList){
//
//        blindArrayList = loadBlinds(context);
//        if (blindArrayList == null){
//            blindArrayList = new ArrayList<BlindClass>();
//        }
//
//        //blindArrayList.add(blinds);
//
//        try{
//            FileOutputStream fos = context.openFileOutput("blinds", Context.MODE_PRIVATE);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(blindArrayList);
//            oos.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    public static void saveBlinds(Context context, BlindClass blinds){

        ArrayList<BlindClass> blindArrayList = loadBlinds(context);
        if (blindArrayList == null){
            blindArrayList = new ArrayList<BlindClass>();
        }

        blindArrayList.add(blinds);

        try{
            FileOutputStream fos = context.openFileOutput("blinds", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(blindArrayList);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<BlindClass> loadBlinds(Context context) {

        ArrayList<BlindClass> blindArrayList = null;
        try{
            FileInputStream fis = context.openFileInput("blinds");
            ObjectInputStream ois = new ObjectInputStream(fis);
            blindArrayList = (ArrayList<BlindClass>) ois.readObject();
            ois.close();
            if (blindArrayList == null){
                blindArrayList = new ArrayList<BlindClass>();
                return blindArrayList;
            }else{
                return blindArrayList;
            }
        }catch (Exception e){
            return null;
        }

    }
}
