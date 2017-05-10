package edu.berkeley.zouxuan.tripbuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.zagum.speechrecognitionview.RecognitionProgressView;
import com.github.zagum.speechrecognitionview.adapters.RecognitionListenerAdapter;

/**
 * Created by zouxuan on 5/9/17.
 */

public class StartFragment extends Fragment {

    RecognitionProgressView recognitionProgressView;

    public StartFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_start, container, false);
        recognitionProgressView = (RecognitionProgressView) rootView.findViewById(R.id.recognition_view);
        int[] colors = {
                ContextCompat.getColor(getActivity(), R.color.color1),
                ContextCompat.getColor(getActivity(), R.color.color2),
                ContextCompat.getColor(getActivity(), R.color.color3),
                ContextCompat.getColor(getActivity(), R.color.color4),
                ContextCompat.getColor(getActivity(), R.color.color5)
        };
        int[] heights = {60, 76, 58, 80, 55};
        recognitionProgressView.setBarMaxHeightsInDp(heights);
        recognitionProgressView.setColors(colors);
        recognitionProgressView.play();
        return rootView;
    }

}
