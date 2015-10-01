package com.bawanj.videostream.activity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.bawanj.videostream.R;

public class MediaPlayerActivity extends AppCompatActivity implements
        SurfaceHolder.Callback, MediaPlayer.OnPreparedListener{

    private MediaPlayer mMediaPlayer;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView mSurfaceView;

    private final String VIDEO_URL= //"https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
            "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        mSurfaceView= (SurfaceView)findViewById(R.id.video_view_player);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_media, menu);
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

    // SurfaceHolder.Callback
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //setup
        try{
            mMediaPlayer= new MediaPlayer();
            mMediaPlayer.setDisplay(holder); /// why we need to use the callback
            mMediaPlayer.setDataSource(VIDEO_URL);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //mMediaPlayer.setDisplay(null);
        playerStop();
    }

    // OnPrepareListener
    @Override
    public void onPrepared(MediaPlayer mp) {
        //start playback
        mMediaPlayer.start();
    }

    @Override
    public void onPause(){
        super.onPause();
        playerStop();

    }

    private void playerStop(){
        mMediaPlayer.stop();
        mMediaPlayer.release();
        mMediaPlayer=null;
    }


}
