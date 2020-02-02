package com.insightsurfface.demodemo.business.visitor;

import java.util.LinkedList;
import java.util.List;

public class BusinessReport {
    private List<Staff> mStaffList = new LinkedList<>();

    public BusinessReport() {
        mStaffList.add(new Fighter("张三"));
        mStaffList.add(new Doctor("李四"));
        mStaffList.add(new Blacksmith("王五"));
        mStaffList.add(new Fighter("任六"));
        mStaffList.add(new Doctor("王八"));
    }
    public void showReport(Visitor visitor){
        for (Staff staff:mStaffList){
            staff.accept(visitor);
        }
    }
}
