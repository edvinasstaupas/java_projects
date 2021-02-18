package lt.staupasedvinas.some;

public class Cat extends Pet{

    public Cat (String name) {
        super(name);
    }

    /*public String getName() {

        return n;
    }*/

    @Override
    public String talk() {
        return "Miau " + this.getName();
    }
}
