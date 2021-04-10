package lt.staupasedvinas;

public class Mifuva implements GasStation{
    @Override
    public void fillUp(Car car) {
        car.fillUp(3);
    }
}
