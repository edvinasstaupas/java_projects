package lt.staupasedvinas;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       GasStation gasStation = GasStationFactory.createDefaultGasStation();
       fillUpTheCar(gasStation);
    }

    public static void fillUpTheCar (GasStation gasStation) {
        List<Car> cars = Arrays.asList(new Car(), new Car());
        for(Car car: cars) {
            gasStation.fillUp(car);
            System.out.println("Car has " + car.getFuelAmount() + "of fuel.\n");
        }
    }
}
