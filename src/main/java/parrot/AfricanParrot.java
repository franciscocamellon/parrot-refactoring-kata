package parrot;

public class AfricanParrot extends Parrot {

    protected int numberOfCoconuts;

    protected AfricanParrot(int numberOfCoconuts) {
        super();
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
    }

    @Override
    public String getCry() {
        return "Sqaark!";
    }

    public double getLoadFactor() {
        return 9.0;
    }

}
