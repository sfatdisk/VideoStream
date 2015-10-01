package com.bawanj.videostream.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.bawanj.videostream.R;

public class MainActivity extends AppCompatActivity {
    private Button mButtonVideoController;
    private Button mButtonVideoMediaPlayer;
    private Button mButtonFragVideoController;
    private Button mButtonFragVideoMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonVideoController = (Button)findViewById(R.id.btn_video_media_controller);
        mButtonVideoController.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToVideoActivity = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intentToVideoActivity);
            }
        });

        mButtonVideoMediaPlayer= (Button)findViewById(R.id.btn_video_media_player);
        mButtonVideoMediaPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToMediaActivity = new Intent(MainActivity.this, MediaPlayerActivity.class);
                startActivity(intentToMediaActivity);
            }
        });

        mButtonFragVideoController= (Button)findViewById(R.id.btn_frag_video_media_controller);
        mButtonFragVideoController.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToVideoFragmentActivity
                        = new Intent( MainActivity.this, VideoFragmentActivity.class);
                startActivity(intentToVideoFragmentActivity);
            }
        });
        
        mButtonFragVideoMediaPlayer= (Button) findViewById(R.id.btn_frag_video_media_player);
        mButtonFragVideoMediaPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToMediaFragmentActivity
                        = new Intent( MainActivity.this, MediaFragmentActivity.class);
                startActivity(intentToMediaFragmentActivity);
                
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
