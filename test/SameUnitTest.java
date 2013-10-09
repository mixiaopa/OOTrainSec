import length.Meter;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SameUnitTest {
    @Test
    public void shouldGetThreeWhenGivenOneAndTwo() throws Exception {
        Meter meter1 = new Meter(1);
        Meter meter2 = new Meter(2);
        Meter result = meter1.add(meter2);
        assertThat(result.getValue(), is(3.0));
    }

    @Test
    public void shouldGetTwoWhenGivenOneAndOne() throws Exception {
        Meter meter = new Meter(1);
        Meter result = meter.add(meter);
        assertThat(result.getValue(), is(2.0));
    }

    @Test
    public void shouldGetOneWhenGivenTwoMinusOne() throws Exception {
        Meter meter = new Meter(2);
        Meter meter2 = new Meter(1);
        Meter result = meter.minus(meter2);
        assertThat(result.getValue(), is(1.0));
    }

    @Test
    public void shouldGetTwoWhenGivenThreeMinusOne() throws Exception {
        Meter meter = new Meter(3);
        Meter meter1 = new Meter(1);
        Meter result = meter.minus(meter1);
        assertThat(result.getValue(), is(2.0));
    }

    @Test
    public void shouldGetTenWhenOneMultiplyTen() throws Exception {
        Meter meter = new Meter(1);
        Meter result = meter.multiply(10);
        assertThat(result.getValue(), is(10.0));
    }

    @Test
    public void shouldGetFourWhenTwoMultiplyTwo() throws Exception {
        Meter meter = new Meter(2);
        Meter result = meter.multiply(2);
        assertThat(result.getValue(), is(4.0));
    }
}
