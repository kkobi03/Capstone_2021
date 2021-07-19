package com.example.newgolden;

import android.app.Application;

public class Phone extends Application {
    private String p_num;

    public String getP_num(){
        return p_num;
    }
    public void setP_num(String p_num){
        this.p_num = p_num;
    }
}
