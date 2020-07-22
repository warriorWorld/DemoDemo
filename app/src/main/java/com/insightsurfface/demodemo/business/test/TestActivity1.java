package com.insightsurfface.demodemo.business.test;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;
import com.insightsurfface.demodemo.utils.DisplayUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.util.List;

import androidx.annotation.Nullable;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by acorn on 2020/7/11.
 */
public class TestActivity1 extends BaseActivity implements EasyPermissions.PermissionCallbacks {
    private static String TAG = "TestActivity1";
    private TextView default_prompt;
    private ImageView waiting_iv;
    private boolean ret;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unzipFile();
        default_prompt.setText(ret + "");
        ImageLoader.getInstance().displayImage("file://" + Environment
                .getExternalStorageDirectory().getAbsolutePath() + File.separator + "aSpider" +
                File.separator + "Pluto" + File.separator + "1" + File.separator + "manga_1_0.png", waiting_iv);
    }

    @Override
    protected void initUI() {
        default_prompt = findViewById(R.id.default_prompt);
        waiting_iv = findViewById(R.id.waiting_iv);
    }

    @AfterPermissionGranted(111)
    private void unzipFile() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...
            Log.d(TAG, "unzipFile() called");
             ret = true;
            File file = new File(Environment
                    .getExternalStorageDirectory().getAbsolutePath() + File.separator + "aSpider" + File.separator + "dist.zip");
            if (file.exists()) {
                ZipFile zipFile;
                try {
                    zipFile = new ZipFile(file);
                    zipFile.extractAll(Environment
                            .getExternalStorageDirectory().getAbsolutePath() + File.separator + "aSpider");
                } catch (ZipException e) {
                    e.printStackTrace();
                    ret = false;
                }
//                boolean delete = file.delete();
            }
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, "我们需要写入/读取权限",
                    111, perms);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_waiting;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        baseToast.showToast("已获得授权,请继续!");
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
    }
}
