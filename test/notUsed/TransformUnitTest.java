package notUsed;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransformUnitTest {
    @Test
    public void shouldGetOneKiloMeterWhenGivenOneThousandMeters() throws Exception {
        Meter meter = new Meter(1000);
        KiloMeter kiloMeter = meter.transformToKiloMeter();
        assertThat(kiloMeter.getValue(), is(1.0));
    }

    @Test
    public void shouldGetTwoKiloMeterWhenGivenTwoThousandMeters() throws Exception {
        Meter meter = new Meter(2000);
        KiloMeter kiloMeter = meter.transformToKiloMeter();
        assertThat(kiloMeter.getValue(), is(2.0));
    }

    @Test
    public void shouldGetOneThousandMetersWhenGivenOneKiloMeter() throws Exception {
        KiloMeter kiloMeter = new KiloMeter(1.0);
        Meter meter = kiloMeter.transformToMeter();
        assertThat(meter.getValue(), is(1000.0));
    }
}
