package com.example.adddynamicviewandroid;

import java.io.Serializable;

public class TranningModel implements Serializable {

    String tranningName,whereTranning;

    public TranningModel(String tranningName, String whereTranning) {
        this.tranningName = tranningName;
        this.whereTranning = whereTranning;
    }

    public TranningModel(){

    }

    public String getTranningName() {
        return tranningName;
    }

    public void setTranningName(String tranningName) {
        this.tranningName = tranningName;
    }

    public String getWhereTranning() {
        return whereTranning;
    }

    public void setWhereTranning(String whereTranning) {
        this.whereTranning = whereTranning;
    }
}
