package notUsed;

public class Meter {
    private final double value;

    public Meter(double i) {
        this.value = i;
    }

    public Meter add(Meter meter) {
        double v = this.value + meter.value;
        return new Meter(v);
    }

    public Meter minus(Meter meter) {
        double v = this.value - meter.value;
        return new Meter(v);
    }

    public double getValue() {
        return value;
    }

    public Meter multiply(int i) {
        double v = this.value * i;
        return new Meter(v);
    }

    public KiloMeter transformToKiloMeter() {
        double v = this.value/1000;
        return new KiloMeter(v);
    }
}
