package parrot;

public enum ParrotTypeEnum {

    EUROPEAN,
    AFRICAN,
    NORWEGIAN_BLUE,
    BRAZILIAN; //artificial type just for testing the switch default type

    public static Parrot createParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {

        Parrot parrot;

        switch (type) {
            case EUROPEAN -> parrot = new EuropeanParrot();
            case AFRICAN -> parrot = new AfricanParrot(numberOfCoconuts);
            case NORWEGIAN_BLUE -> parrot = new NorwegianParrot(voltage, isNailed);
            default -> throw new IllegalArgumentException("Invalid Parrot type: " + type);
        }
        return parrot;
    }
}
