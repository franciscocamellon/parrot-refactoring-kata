package parrot;

public abstract class Parrot {

    protected Parrot() {}

    public abstract double getSpeed();

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

    public abstract String getCry();
}
