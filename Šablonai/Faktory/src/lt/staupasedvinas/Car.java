package lt.staupasedvinas;

public class Car {
    private double fuelAmountInL;
    private double tankCapacity;

    public Car () {
        fuelAmountInL = 20;
        tankCapacity = 45;
    }

    public void fillUp(double amountOfFuelInL) {
        fuelAmountInL += amountOfFuelInL;
    }

    public double getFuelTankCapacity () {
        return tankCapacity;
    }

    public double getFuelAmount () {
        return fuelAmountInL;
    }
}
