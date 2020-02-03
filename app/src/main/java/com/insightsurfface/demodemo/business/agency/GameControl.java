package com.insightsurfface.demodemo.business.agency;

public class GameControl {
    private Skill mSkill;

    public GameControl(Skill skill) {
        mSkill = skill;
    }

    public void setSkill(Skill skill) {
        mSkill = skill;
    }

    public void r() {
        mSkill.r();
    }
}
