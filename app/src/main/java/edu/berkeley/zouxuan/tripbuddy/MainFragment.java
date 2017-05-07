package edu.berkeley.zouxuan.tripbuddy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private ImageView titleview;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        titleview=(ImageView)rootView.findViewById(R.id.titleview);
        titleview.setImageResource(R.drawable.logo);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    private ArrayList<HistoryData> getDataSet() {
        ArrayList<HistoryData> list = new ArrayList<>();
        list.add(new HistoryData(R.drawable.game_icon, "Game Score", "You got a score of 5 in nba team name category."));
        list.add(new HistoryData(R.drawable.alarm_icon, "Alarm Reaction", "Your reaction time is 10 seconds. You need a rest. :("));
        list.add(new HistoryData(R.drawable.game_icon, "Game Score", "You beat road trip game in multiple choice game."));
        return list;
    }


}
