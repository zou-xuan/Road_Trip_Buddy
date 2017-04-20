package edu.berkeley.zouxuan.tripbuddy;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView titleview;
    private ImageButton game_button;
    private ImageButton alarm_button;
    private ImageButton history_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleview=(ImageView)findViewById(R.id.titleview);
        titleview.setImageResource(R.drawable.title);

        game_button=(ImageButton)findViewById(R.id.game_button);
        alarm_button=(ImageButton)findViewById(R.id.alarm_button);
        history_button=(ImageButton)findViewById(R.id.history_button);
        game_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent t=new Intent(MainActivity.this,GameActivity.class);
                startActivity(t);
            }
        });
    }
}
