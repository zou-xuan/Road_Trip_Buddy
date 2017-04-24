package edu.berkeley.zouxuan.tripbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<HistoryData> getDataSet() {
        ArrayList<HistoryData> list = new ArrayList<>();
        list.add(new HistoryData(R.drawable.game_icon, "Game Score", "You got a score of 5 in nba team name category."));
        list.add(new HistoryData(R.drawable.alarm_icon, "Alarm Reaction", "Your reaction time is 10 seconds. You need a rest. :("));
        list.add(new HistoryData(R.drawable.game_icon, "Game Score", "You beat road trip game in multiple choice game."));
        return list;
    }
}
