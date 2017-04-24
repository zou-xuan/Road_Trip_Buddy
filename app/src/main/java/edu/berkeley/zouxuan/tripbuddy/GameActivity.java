package edu.berkeley.zouxuan.tripbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GameActivity extends AppCompatActivity {

    private ImageButton button_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button_category=(ImageButton)findViewById(R.id.game_category);
        button_category.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent t=new Intent(GameActivity.this,ChatActivity.class);
                startActivity(t);
            }
        });
    }
}
