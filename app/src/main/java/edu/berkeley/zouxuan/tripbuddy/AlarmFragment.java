package edu.berkeley.zouxuan.tripbuddy;

import android.support.v4.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by zouxuan on 5/6/17.
 */

public class AlarmFragment extends Fragment {

    SeekBar timerSeekBar;
    TextView timerTextView;
    ImageView go;
    ImageView stop;
    Button controllerButton;
    Boolean counterIsActive = false;
    CountDownTimer countDownTimer;

    public AlarmFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_alarm, container, false);
        timerSeekBar = (SeekBar)rootView.findViewById(R.id.timerSeekBar);
        timerTextView = (TextView) rootView.findViewById(R.id.timerTextView);
        go = (ImageView)rootView.findViewById(R.id.imageView);
        stop = (ImageView)rootView.findViewById(R.id.imageView2);
        controllerButton = (Button)rootView.findViewById(R.id.controllerButton);
        assert timerSeekBar != null;
        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(300);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        controllerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlTimer(v);
            }
        });

        return rootView;
    }


    public void resetTimer(){
        controllerButton.setText("Start");
        timerSeekBar.setEnabled(true);
        //timerSeekBar.setProgress(30);
        countDownTimer.cancel();
        counterIsActive = false;
    }

    public void updateTimer(int secondsLeft){
        int mins =  secondsLeft / 60;
        int secs =  secondsLeft - mins * 60;

        String mins2 = String.valueOf(mins);
        String secs2 = String.valueOf(secs);

        if (secs <= 9){
            secs2 = "0" + secs2;
        }


        assert timerTextView != null;
        timerTextView.setText(mins2 +":"+ secs2);
    }

    public void controlTimer(View view){
        //Log.i("button pressed", "pressed");

        if (counterIsActive == false) {

            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            controllerButton.setText("Stop");
            go.setVisibility(View.VISIBLE);
            stop.setVisibility(View.INVISIBLE);

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    timerTextView.setText("0:00");
                    go.setVisibility(View.INVISIBLE);
                    stop.setVisibility(View.VISIBLE);
                    MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), R.raw.airhorn);
                    mediaPlayer.start();
                    resetTimer();
                }
            }.start();
        }else {
            timerTextView.setText("5:00");
            timerSeekBar.setProgress(300);
            resetTimer();
        }
    }

}
