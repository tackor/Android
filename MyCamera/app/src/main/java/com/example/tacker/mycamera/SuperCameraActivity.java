package com.example.tacker.mycamera;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by Tacker on 2017/2/18.
 */
public class SuperCameraActivity extends AppCompatActivity implements View.OnClickListener, SurfaceHolder.Callback {

    private Camera mCamera;

    private TextView mPhotoBtn;
    private SurfaceView mPreview;
    private SurfaceHolder mHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_camera);

        mPhotoBtn = (TextView) findViewById(R.id.activity_super_takePhoto);
        mPhotoBtn.setOnClickListener(this);
        mPreview = (SurfaceView) findViewById(R.id.activity_super_Img);
        mHolder = mPreview.getHolder();
        mHolder.addCallback(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mCamera == null) {
            mCamera = getCamera();
            if (mHolder != null) {
                setStartPreview(mCamera, mHolder);
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        releaseCamera();
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 获取Camera对象
     * @return
     */
    private Camera getCamera() {
        Camera camera;
        try {
            camera = Camera.open();
        } catch (Exception e) {
            camera  = null;
            e.printStackTrace();
        }
        return camera;
    }

    /**
     * 开始预览相机内容
     */
    private void setStartPreview(Camera camera, SurfaceHolder holder) {
        try {
            camera.setPreviewDisplay(holder);

            // 将默认的横屏设置成竖屏
            camera.setDisplayOrientation(90);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 是否相机对象
     */
    private void releaseCamera() {
        if (mCamera != null) {
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
            mCamera = null;
        }
        mCamera.release();

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setStartPreview(mCamera, mHolder);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mCamera.stopPreview();
        setStartPreview(mCamera, mHolder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        releaseCamera();
    }
}