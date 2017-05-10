package edu.berkeley.zouxuan.tripbuddy;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.zagum.speechrecognitionview.RecognitionProgressView;
import com.github.zagum.speechrecognitionview.adapters.RecognitionListenerAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private ImageView titleview;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SpeechRecognizer speechRecognizer;
    private static final String TAG = "MainActivity";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION_CODE = 1;
    RecognitionProgressView recognitionProgressView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


//        titleview=(ImageView)rootView.findViewById(R.id.titleview);
//        titleview.setImageResource(R.drawable.history);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(getActivity());

        recognitionProgressView = (RecognitionProgressView) rootView.findViewById(R.id.recognition_view);
        recognitionProgressView.setRecognitionListener(new RecognitionListenerAdapter() {
            @Override
            public void onResults(Bundle results) {
                showResults(results);
            }
        });
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
//        Button button=(Button)rootView.findViewById(R.id.fab);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ContextCompat.checkSelfPermission(getActivity(),
//                        Manifest.permission.RECORD_AUDIO)
//                        != PackageManager.PERMISSION_GRANTED) {
//                    requestPermission();
//                } else {
//                    startRecognition();
//                    recognitionProgressView.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            startRecognition();
//                        }
//                    }, 50);
//                }
//            }
//        });

        return rootView;
    }

    public void callByMain(){
        Toast.makeText(getContext(),"call",Toast.LENGTH_LONG);
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermission();
        } else {
            startRecognition();
            recognitionProgressView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startRecognition();
                }
            }, 50);
        }
    }

    private void startRecognition() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getActivity().getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en");
        speechRecognizer.startListening(intent);
    }

    private void showResults(Bundle results) {
        ArrayList<String> matches = results
                .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        Toast.makeText(getActivity(), matches.get(0), Toast.LENGTH_LONG).show();
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.RECORD_AUDIO)) {
            Toast.makeText(getActivity(), "Requires RECORD_AUDIO permission", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.RECORD_AUDIO},
                    REQUEST_RECORD_AUDIO_PERMISSION_CODE);
        }
    }



    private ArrayList<HistoryData> getDataSet() {
        ArrayList<HistoryData> list = new ArrayList<>();
        list.add(new HistoryData(R.drawable.game_icon, "Game Score", "You got a score of 3 in nba team name category."));
        list.add(new HistoryData(R.drawable.alarm_icon2, "Alarm Reaction", "Your reaction time is 10 seconds. You need a rest. :("));
        list.add(new HistoryData(R.drawable.game_icon, "Game Score", "You beat road trip game in multiple choice game."));
        return list;
    }


}
