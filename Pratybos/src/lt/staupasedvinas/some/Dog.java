package lt.staupasedvinas.some;

public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    /*public String getName() {
        return name;
    }*/
    @Override
    public String talk() {
        return "Au au " + this.getName();
    }
}
