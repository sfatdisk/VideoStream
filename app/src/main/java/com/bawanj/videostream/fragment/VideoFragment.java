package com.bawanj.videostream.fragment;


import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bawanj.videostream.R;

public class VideoFragment extends Fragment {

    private VideoView mVideoView;
    private MediaController mMediaController;

    private final String VIDEO_URL= //"https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
            "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";

    public static VideoFragment newInstance(){
        return new VideoFragment();
    }
    @Override
    public void onCreate( Bundle savedInstanceState  ){
        super.onCreate( savedInstanceState );
        setRetainInstance(true);

        mMediaController = new MediaController( getActivity() );

    }

    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState){

        View view= inflater
                .from(getActivity())
                .inflate(R.layout.fragment_video, container, false);

        mVideoView= (VideoView)view.findViewById(R.id.fragment_video_view_controller);

        playVideo();

        return view;
    }

    private void playVideo(){

        mMediaController.setAnchorView(mVideoView);

        Uri videoUrl= Uri.parse(VIDEO_URL);

        mVideoView.setMediaController(mMediaController);
        mVideoView.setVideoURI(videoUrl);

        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                mVideoView.start();
            }
        });

    }

}
