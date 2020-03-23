package core;

public class NotEnoughEnergyException extends Exception {

    public NotEnoughEnergyException(String s) {
        super(s);
    }

    public NotEnoughEnergyException() {
        super();
    }

}
