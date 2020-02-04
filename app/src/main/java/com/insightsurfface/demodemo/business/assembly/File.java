package com.insightsurfface.demodemo.business.assembly;

import java.util.List;

public class File extends Dir {
    private String err = "文件对象不支持该操作";

    public File(String name) {
        super(name);
    }

    @Override
    public void addDir(Dir dir) {
        throw new UnsupportedOperationException(err);
    }

    @Override
    public void removeDir(Dir dir) {
        throw new UnsupportedOperationException(err);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException(err);
    }

    @Override
    public String print() {
        return getName();
    }

    @Override
    public List<Dir> getFiles() {
        throw new UnsupportedOperationException(err);
    }
}
