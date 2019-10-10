package com.example.ungdungbaothuc;

import android.widget.TextView;

public class baothuc {
    private String gio;
    private String ghichu;
    private int check;

    public baothuc(String gio, String ghichu, int check) {
        this.gio = gio;
        this.ghichu = ghichu;
        this.check = check;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
