package lt.staupasedvinas.some;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Maksas");
        Cat cat = new Cat("Micius");
        //System.out.print(dog.getName());
        //talkTo(dog);
        //talkTo(cat);

        List<Pet> pets = new ArrayList<>();

        pets.add(cat);
        pets.add(dog);

        for (Pet pet: pets) {
            talkTo(pet);
        }
    }

    public static void talkTo(Pet pet){
        System.out.println(pet.talk());
    }
}
