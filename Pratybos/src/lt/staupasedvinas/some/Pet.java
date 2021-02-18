package lt.staupasedvinas.some;

public class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String talk () {
        return "Miau, aš" + name;
    }
}
