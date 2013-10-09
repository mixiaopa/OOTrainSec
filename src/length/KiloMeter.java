package length;

public class KiloMeter {
    private Double value;

    public KiloMeter(double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public Meter transformToMeter() {

        return new Meter(1000.0);
    }
}
