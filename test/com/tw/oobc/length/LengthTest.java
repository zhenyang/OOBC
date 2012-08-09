package com.tw.oobc.length;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LengthTest {

    //equal
    @Test
    public void test_1_m_should_equal_another_1_m() throws Exception {
        Length oneMeter = new Length(1, Unit.m);
        Length anotherMeter = new Length(1, Unit.m);

        assertThat(oneMeter.equal(anotherMeter), is(true));
    }

    @Test
    public void test_1_m_should_not_equal_2_m() throws Exception {
        Length oneMeter = new Length(1, Unit.m);
        Length anotherMeter = new Length(2, Unit.m);

        assertThat(oneMeter.equal(anotherMeter), is(false));
    }

    @Test
    public void test_1_m_should_equal_100_cm() throws Exception {
        Length oneMeter = new Length(1, Unit.m);
        Length oneHundredCM = new Length(100, Unit.cm);

        assertThat(oneMeter.equal(oneHundredCM), is(true));
    }

    @Test
    public void test_1_m_should_not_equal_200_cm() throws Exception {
        Length oneMeter = new Length(1, Unit.m);
        Length twoHundredsCM = new Length(200, Unit.cm);

        assertThat(oneMeter.equal(twoHundredsCM), is(false));
    }

    @Test
    public void test_100_cm_should_equal_1_m() throws Exception {
        Length oneMeter = new Length(1, Unit.m);
        Length oneHundredCM = new Length(100, Unit.cm);

        assertThat(oneHundredCM.equal(oneMeter), is(true));
    }

    @Test
    public void test_1000_mm_should_equal_1_m() throws Exception {
        Length oneMeter = new Length(1, Unit.m);
        Length oneThousandMM = new Length(1000, Unit.mm);

        assertThat(oneThousandMM.equal(oneMeter), is(true));
    }


    @Test
    public void test_add() throws Exception {
    }

    @Test
    public void test_minus() throws Exception {
    }

    @Test
    public void test_change_unit() throws Exception {
    }
}
