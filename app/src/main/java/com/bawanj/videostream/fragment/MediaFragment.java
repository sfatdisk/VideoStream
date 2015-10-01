package com.bawanj.videostream.fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.bawanj.videostream.R;

import java.io.IOException;

public class MediaFragment extends Fragment {

    private static final String TAG= "MediaFragment";
    private static final String VIDEO_URL= //"https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
            "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";

    private SurfaceView mSurfaceView;

    private MediaPlayer mMediaPlayer;

    private SurfaceHolder mSurfaceHolder; // no needed 

    public static MediaFragment newInstance(){
        return new MediaFragment();
    }

    @Override
    public void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        setRetainInstance(true);
        // TODO - why?? jarring hiccups happening ?? are you doing much during Activity creation and the system can't handle the load, but that's another problem entirely!)
        playVideo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){

        View view= inflater
                .from(getActivity())
                .inflate(R.layout.fragment_media, container, false);

        mSurfaceView= (SurfaceView) view.findViewById(R.id.fragment_surface_view);

        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mMediaPlayer.setDisplay(holder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mMediaPlayer.setDisplay(null);
            }
        });

        return view ;
    }

    @Override
    public void onStart(){
        super.onStart();
        if(mMediaPlayer==null){
            playVideo();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        stopVideo();
    }

    private void playVideo(){ // play video
        try{
            mMediaPlayer= new MediaPlayer();
            mMediaPlayer.setDataSource(VIDEO_URL); // !! setup data
            //mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.prepare();
            mMediaPlayer.start();

        }catch ( IOException ioe){
            ioe.printStackTrace();
            Log.e(TAG, "Can not play Video "+ioe);
        }
    }

    private void stopVideo(){
        mMediaPlayer.stop();
        mMediaPlayer.reset();
        mMediaPlayer.release();
        mMediaPlayer=null;
    }

}
