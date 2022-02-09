package com.example.globcovidtracker.Model;

import android.widget.ImageView;

public class model {
    String numTitle;
    String num;
    int profile;
    String Sym_name;
    String Sym_des;


    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getSym_name() {
        return Sym_name;
    }

    public void setSym_name(String sym_name) {
        Sym_name = sym_name;
    }

    public String getSym_des() {
        return Sym_des;
    }

    public void setSym_des(String sym_des) {
        Sym_des = sym_des;
    }

    public model(int profile, String sym_name, String sym_des) {
        this.profile = profile;
         this.Sym_name = sym_name;
        this.Sym_des = sym_des;
    }

    public model(String numTitle, String num) {
        this.numTitle = numTitle;
        this.num = num;
    }
    public model() {

    }

    public String getNumTitle() {
        return numTitle;
    }

    public void setNumTitle(String numTitle) {
        this.numTitle = numTitle;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
