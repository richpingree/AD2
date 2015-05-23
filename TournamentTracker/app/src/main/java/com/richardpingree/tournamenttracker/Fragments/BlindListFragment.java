package com.richardpingree.tournamenttracker.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.richardpingree.tournamenttracker.BlindAdapter;
import com.richardpingree.tournamenttracker.BlindClass;
import com.richardpingree.tournamenttracker.MainActivity;
import com.richardpingree.tournamenttracker.R;

import java.util.ArrayList;

/**
 * Created by Richard Pingree APD2 1505 on 5/20/15.
 */
public class BlindListFragment extends Fragment {

    private final String TAG = "BlindListFrag.TAG";

    private BlindListListener mListener;
    private ArrayList<BlindClass> mBlindList;
    BlindAdapter mAdapter;
    private ActionMode mActionMode;
    private int mItemSeleceted = -1;

    public interface BlindListListener{
        public void deleteBlind(int position);
        public ArrayList<BlindClass> getBlinds();
        public void addBlind();
    }

    public BlindListFragment(){

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof BlindListListener){
            mListener = (BlindListListener) activity;
        }else{
            throw new IllegalArgumentException("Containing activity must implement BlindListListener interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blindlist, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);

        ListView blindListView = (ListView) getView().findViewById(R.id.blindList);
        mAdapter = new BlindAdapter(getActivity(), mListener.getBlinds());
        blindListView.setAdapter(mAdapter);

//        blindListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (mActionMode != null) {
//                    //return false;
//                }
//                mItemSeleceted = position;
//                mActionMode = getActivity().startActionMode(mActionModeCallback);
//                //return true;
//            }
//        });

        blindListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (mActionMode != null) {
                    return false;
                }
                mItemSeleceted = position;
                mActionMode = getActivity().startActionMode(mActionModeCallback);
                return true;

            }
        });
    }

    public void updateBlindList(){
        ListView blindList = (ListView) getView().findViewById(R.id.blindList);
        BaseAdapter adapter = (BaseAdapter) blindList.getAdapter();
        adapter.notifyDataSetChanged();
    }

    public BlindClass getToDelete(){
        return mAdapter.getItem(mItemSeleceted);
    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.action_menu_list, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.itemDelete:

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Are you sure you want to delete?").setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mListener.deleteBlind(mItemSeleceted);
                            mActionMode.finish();
                        }
                    })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mActionMode.finish();
                                }
                            });
                    builder.show();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;

        }
    };

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.blind, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Log.i(TAG, "Add button clicked");
                mListener.addBlind();
                break;
            case R.id.action_done:

                Intent doneIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(doneIntent);
                getActivity().finish();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
