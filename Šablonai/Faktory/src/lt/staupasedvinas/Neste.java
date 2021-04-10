package lt.staupasedvinas;

public class Neste implements GasStation{


    @Override
    public void fillUp(Car car) {
        double ammountToFill = car.getFuelTankCapacity() - car.getFuelAmount();
        car.fillUp(ammountToFill);
    }
}
