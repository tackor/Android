package com.example.tacker.mycamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 立即显示图片
    private TextView mTakePhotoBtn;

    // 拍照并立即保存
    private TextView mTakeAndSavePhotoBtn;

    // 简单摄像
    private TextView mTakeVideoBtn;

    // 高级相机
    private TextView mSuperCamera;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTakePhotoBtn = (TextView)findViewById(R.id.activity_takePhoto_toImageView);
        mTakeAndSavePhotoBtn = (TextView)findViewById(R.id.activity_takePhoto_toSave);
        mTakeVideoBtn = (TextView)findViewById(R.id.activity_takeVideo);
        mSuperCamera = (TextView)findViewById(R.id.activity_super_Camera);

        takePhotoAndShow();
        takePhotoAndSave();
        takeVideo();
        startSuperCamera();

    }

    /**
     * 拍照,并立即显示
     */
    private void takePhotoAndShow() {
        mTakePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowImageActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 拍照并保存到相册
     */
    private void takePhotoAndSave() {
        mTakeAndSavePhotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SaveImageActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 摄像
     */
    private void takeVideo() {
        mTakeVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpVideoActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 高级相机
     */
    private void startSuperCamera() {
        mSuperCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SuperCameraActivity.class);
                startActivity(intent);
            }
        });

    }
}
