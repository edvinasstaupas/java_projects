package lt.staupasedvinas;

public class GasStationFactory {
    public static GasStation createDefaultGasStation() {
        if(Math.random() > 0.5)
            return new Neste();
        else
            return new Mifuva();
    }
}
