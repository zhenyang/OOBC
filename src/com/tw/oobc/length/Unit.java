package com.tw.oobc.length;

public enum Unit {
    m(1),cm(100),mm(1000);

    private int rate;

    private Unit(int rate) {
        this.rate = rate;
    }

    public int valueInM(int value1) {
        return value1/rate;
    }

}
