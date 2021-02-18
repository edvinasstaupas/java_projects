package lt.staupasedvinas.some;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("reksas");
        System.out.println(dog.getName());

        Cat cat = new Cat("aa");
        System.out.println(cat.getName());

        Pet dog2 = new Pet("Maksas");
        Pet cat2 = new Pet("bb");
        System.out.println(Pet.getName());
        System.out.println(Pet.getName());
    }
}
