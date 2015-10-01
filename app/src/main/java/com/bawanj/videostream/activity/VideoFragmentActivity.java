package com.bawanj.videostream.activity;


import android.support.v4.app.Fragment;

import com.bawanj.videostream.fragment.VideoFragment;

public class VideoFragmentActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return VideoFragment.newInstance();
    }

}
