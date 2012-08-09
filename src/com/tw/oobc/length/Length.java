package com.tw.oobc.length;

public class Length {
    private int value;
    private Unit unit;

    public Length(int value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Boolean equal(Length anotherMeter) {
        return anotherMeter.unit.valueInM(anotherMeter.value) == unit.valueInM(value);
    }
}
