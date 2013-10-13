package After;

public class MyLength {
    private final String unit;
    private final double value;

    public MyLength(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public MyLength add(MyLength length) {
        return new MyLength(this.unit, this.value + length.transform(this.unit).value);
    }

    public MyLength minus(MyLength length) {
        return new MyLength(this.unit, this.value - length.transform(this.unit).value);
    }

    public MyLength multiply(double times) {
        return new MyLength(this.unit, this.value * times);
    }

    public MyLength transform(String unitForResult) {
        double proportionForThis = calculateProportion(this.unit);
        double proportionForResult = calculateProportion(unitForResult);
        return new MyLength(unitForResult, this.value * (proportionForThis / proportionForResult));
    }

    public double calculateProportion(String unit) {
        double proportionForUnit = 0;
        if (unit.equals(ConstansForLength.KM)) {
            proportionForUnit = ConstansForLength.KM_TO_CM;
        }
        if (unit.equals(ConstansForLength.M)) {
            proportionForUnit = ConstansForLength.M_TO_CM;
        }
        if (unit.equals(ConstansForLength.DM)) {
            proportionForUnit = ConstansForLength.DM_TO_CM;
        }
        if (unit.equals(ConstansForLength.CM)) {
            proportionForUnit = ConstansForLength.CM_TO_CM;
        }
        if (unit.equals(ConstansForLength.MM)) {
            proportionForUnit = ConstansForLength.MM_TO_CM;
        }
        return proportionForUnit;
    }

    public String compareLength(MyLength comparedLength) {
        double minusValue = this.minus(comparedLength).value;
        if (minusValue > 0) {
            return ConstansForLength.BIGGER;
        }
        if (minusValue < 0) {
            return ConstansForLength.SMALLER;
        }
        return ConstansForLength.EQUAL;
    }
}
