package com.insightsurfface.demodemo.business.assembly;

import java.util.Iterator;
import java.util.List;

public class Folder extends Dir {
    public Folder(String name) {
        super(name);
    }

    @Override
    public void addDir(Dir dir) {
        dirs.add(dir);
    }

    @Override
    public void removeDir(Dir dir) {
        dirs.remove(dir);
    }

    @Override
    public void clear() {
        dirs.clear();
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "(");
        Iterator<Dir> iter = dirs.iterator();
        while (iter.hasNext()) {
            Dir dir = iter.next();
            sb.append(dir.print());
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public List<Dir> getFiles() {
        return dirs;
    }
}
