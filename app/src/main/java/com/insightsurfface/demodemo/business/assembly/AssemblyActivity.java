package com.insightsurfface.demodemo.business.assembly;

import android.os.Bundle;
import android.widget.TextView;

import com.insightsurfface.demodemo.R;
import com.insightsurfface.demodemo.base.BaseActivity;

import androidx.annotation.Nullable;

public class AssemblyActivity extends BaseActivity {
    private TextView filePathTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dir diskC=new Folder("C");
        diskC.addDir(new File("1.txt"));
        Dir dirWin=new Folder("Windows");
        dirWin.addDir(new File("explorer.exe"));
        diskC.addDir(dirWin);
        Dir dirPer=new Folder("PerfLogs");
        dirPer.addDir(new File("null.txt"));
        diskC.addDir(dirPer);
        Dir dirPro=new Folder("Progrem File");
        dirPro.addDir(new File("FTP.txt"));
        dirPer.addDir(dirPro);

        filePathTv.setText(diskC.print()+"\n\n"+dirWin.print());
    }

    @Override
    protected void initUI() {
        filePathTv = findViewById(R.id.file_path_tv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_assembly;
    }
}
