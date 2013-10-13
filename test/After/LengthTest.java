package After;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LengthTest {
    @Test
    public void shouldGetTwoMetersWhenOneMeterAddOneMeter() throws Exception {
        MyLength length = new MyLength("M", 1.0);
        MyLength result = length.add(length);
        assertThat(result.getValue(), is(2.0));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetThreeMetersWhenTwoMetersAddOneMeter() throws Exception {
        MyLength length = new MyLength("M", 1.0);
        MyLength lengthTwo = new MyLength("M", 2.0);
        MyLength result = length.add(lengthTwo);
        assertThat(result.getValue(), is(3.0));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetTwoMetersWhenThreeMetersMinusOneMeter() throws Exception {
        MyLength length = new MyLength("M", 1.0);
        MyLength lengthThree = new MyLength("M", 3.0);
        MyLength result = lengthThree.minus(length);
        assertThat(result.getValue(), is(2.0));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetOneMeterWhenTwoMetersMinusOneMeter() throws Exception {
        MyLength length = new MyLength("M", 1.0);
        MyLength lengthTwo = new MyLength("M", 2.0);
        MyLength result = lengthTwo.minus(length);
        assertThat(result.getValue(), is(1.0));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetTenMetersWhenOneMeterMultiplyTen() throws Exception {
        MyLength length = new MyLength("M", 1.0);
        MyLength result = length.multiply(10);
        assertThat(result.getValue(), is(10.0));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetFiveMetersWhenOneMeterMultiplyFive() throws Exception {
        MyLength length = new MyLength("M", 1.0);
        MyLength result = length.multiply(5);
        assertThat(result.getValue(), is(5.0));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetOneThousandMetersWhenOneKilometerTransferToMeter() throws Exception {
        MyLength length = new MyLength("KM", 1.0);
        MyLength result = length.transform("M");
        assertThat(result.getValue(), is(1000.0));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetOneKilometerWhenOneThousandMetersTransferToKilometer() throws Exception {
        MyLength length = new MyLength("M", 1000.0);
        MyLength result = length.transform("KM");
        assertThat(result.getValue(), is(1.0));
        assertThat(result.getUnit(), is("KM"));
    }

    @Test
    public void shouldGetOneHundredCentimetresWhenOneMeterTransferToCentimetre() throws Exception {
        MyLength length = new MyLength("M", 1.0);
        MyLength result = length.transform("CM");
        assertThat(result.getValue(), is(100.0));
        assertThat(result.getUnit(), is("CM"));
    }

    @Test
    public void shouldGetOnePointZeroFiveMetresWhenOneMeterAddFiveCentimetres() throws Exception {
        MyLength length = new MyLength("M", 1.0);
        MyLength lengthCentimeter = new MyLength("CM", 5.0);
        MyLength result = length.add(lengthCentimeter);
        assertThat(result.getValue(), is(1.05));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetOneThousandAndFiveMetresWhenFiveMetersAddOneKilometre() throws Exception {
        MyLength length = new MyLength("M", 5.0);
        MyLength lengthKilometer = new MyLength("KM", 1.0);
        MyLength result = length.add(lengthKilometer);
        assertThat(result.getValue(), is(1005.0));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetZeroPointNineFiveMetresWhenOneMeterMinusFiveCentimetres() throws Exception {
        MyLength length = new MyLength("M", 1.0);
        MyLength lengthCentimeter = new MyLength("CM", 5.0);
        MyLength result = length.minus(lengthCentimeter);
        assertThat(result.getValue(), is(0.95));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetFourThousandsMetresWhenFiveThousandMetersMinusOneKilometre() throws Exception {
        MyLength length = new MyLength("M", 5000.0);
        MyLength lengthKilometer = new MyLength("KM", 1.0);
        MyLength result = length.minus(lengthKilometer);
        assertThat(result.getValue(), is(4000.0));
        assertThat(result.getUnit(), is("M"));
    }

    @Test
    public void shouldGetBiggerResultWhenFiveMetersCompareWithFourMeters() throws Exception {
        MyLength length = new MyLength("M", 5.0);
        MyLength shortLength = new MyLength("M", 4.0);
        String result = length.compareLength(shortLength);
        assertThat(result, is("BIGGER"));
    }

    @Test
    public void shouldGetSmallerResultWhenFiveMetersCompareWithOneKilometer() throws Exception {
        MyLength length = new MyLength("M", 5.0);
        MyLength lengthKilo = new MyLength("KM", 1.0);
        String result = length.compareLength(lengthKilo);
        assertThat(result, is("SMALLER"));
    }

    @Test
    public void shouldGetEqualResultWhenFiveMetersCompareWithFiveHundredCentimeter() throws Exception {
        MyLength length = new MyLength("M", 5.0);
        MyLength lengthCentimeter = new MyLength("CM", 500.0);
        String result = length.compareLength(lengthCentimeter);
        assertThat(result, is("EQUAL"));
    }
}
