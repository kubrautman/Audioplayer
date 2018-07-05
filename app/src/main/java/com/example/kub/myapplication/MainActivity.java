package com.example.kub.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button bstart,bstop;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
player=MediaPlayer.create(MainActivity.this,R.raw.worm);


        player.setLooping(true);
        player.stop();
        bstart=(Button)findViewById(R.id.buttonStart);
        bstop=(Button)findViewById(R.id.buttonStop);
        bstart.setOnClickListener(this);
        bstop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==bstart){
            startService(new Intent(this,myService.class));

        } else if(v==bstop)
            stopService(new Intent(this,myService.class));

    }
    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(this,myService.class));
        // Always call the superclass method first
        Toast.makeText(getApplicationContext(), "onStop called", Toast.LENGTH_LONG).show();
    }
}
