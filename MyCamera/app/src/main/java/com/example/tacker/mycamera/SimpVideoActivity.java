package com.example.tacker.mycamera;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by Tacker on 2017/2/18.
 */

public class SimpVideoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTakeVideoBtn;
    private VideoView mVideoView;
    static final int REQUEST_VIDEO_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simp_video);

        mTakeVideoBtn = (TextView) findViewById(R.id.activity_takeVideo);
        mVideoView = (VideoView) findViewById(R.id.activity_videoView);
        mTakeVideoBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = getIntent().getData();
            mVideoView.setVideoURI(videoUri);
        }
    }
}