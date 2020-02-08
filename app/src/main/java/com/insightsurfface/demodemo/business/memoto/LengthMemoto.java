package com.insightsurfface.demodemo.business.memoto;

import java.io.Serializable;

public class LengthMemoto implements Serializable {
    private String meter;
    private String inch;
    private String feet;

    public LengthMemoto(String meter, String inch, String feet) {
        this.meter = meter;
        this.inch = inch;
        this.feet = feet;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch;
    }

    public String getFeet() {
        return feet;
    }

    public void setFeet(String feet) {
        this.feet = feet;
    }
}
