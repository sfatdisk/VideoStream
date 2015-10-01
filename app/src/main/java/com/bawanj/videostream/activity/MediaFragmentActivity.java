package com.bawanj.videostream.activity;


import android.support.v4.app.Fragment;

import com.bawanj.videostream.fragment.MediaFragment;

public class MediaFragmentActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MediaFragment.newInstance() ;
    }

}
