package edu.berkeley.zouxuan.tripbuddy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    private ImageButton button_category;


    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_game, container, false);

        button_category = (ImageButton) rootview.findViewById(R.id.game_category);
        button_category.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent t = new Intent(getActivity(), ChatActivity.class);
                startActivity(t);
            }
        });
        return rootview;
    }


}
