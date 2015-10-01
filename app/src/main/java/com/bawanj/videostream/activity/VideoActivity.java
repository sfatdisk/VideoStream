package com.bawanj.videostream.activity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bawanj.videostream.R;

public class VideoActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    private VideoView mVideoView;

    private final String VIDEO_URL= //"https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
            "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mVideoView= (VideoView)findViewById(R.id.video_view_controller);

        mProgressDialog= new ProgressDialog(VideoActivity.this);
        mProgressDialog.setTitle("VideoStream Title");
        mProgressDialog.setMessage("Buffering...");
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

        try{
            MediaController mediaController= new MediaController(VideoActivity.this);
            /* A view containing controls for a MediaPlayer. Typically contains the
             * buttons like "Play/Pause", "Rewind", "Fast Forward" and a progress
             * slider. It takes care of synchronizing the controls with the state
             * of the MediaPlayer.*/

            mediaController.setAnchorView(mVideoView);

            Uri videoUri= Uri.parse(VIDEO_URL);

            mVideoView.setMediaController(mediaController);
            mVideoView.setVideoURI(videoUri);
            //mVideoView.setVideoPath(file_path);


        }catch (Exception e){
            e.printStackTrace();
        }

        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mProgressDialog.dismiss();
                mVideoView.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
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
