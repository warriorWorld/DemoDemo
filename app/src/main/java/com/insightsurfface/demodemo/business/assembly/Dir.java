package com.insightsurfface.demodemo.business.assembly;

import java.util.ArrayList;
import java.util.List;

public abstract class Dir {
    protected List<Dir> dirs = new ArrayList<>();
    private String name;

    public Dir(String name) {
        this.name = name;
    }

    public abstract void addDir(Dir dir);

    public abstract void removeDir(Dir dir);

    public abstract void clear();

    public abstract String print();

    public abstract List<Dir> getFiles();

    public String getName() {
        return name;
    }
}
