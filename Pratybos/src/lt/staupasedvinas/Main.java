package lt.staupasedvinas;

//enkapsuliacija
//paveldejimas
//polimorfizmas
//abstrakcija (is 2 ir 3)


public class Main {

    public static void main(String[] args) {
        Milkmaid anelė = new Milkmaid();
        Goat goat = new Goat();
        Cow cow = new Cow();
        Milk cowMilk = anelė.milk(cow);
        System.out.println(cowMilk.getAmountInL());
        Milk goatMilk = anelė.milk(goat);
        System.out.println(goatMilk.getAmountInL());
    }
}


class Milk {
    private int amountInL;

    public Milk(int amountInL) {
        this.amountInL = amountInL;
    }

    public int getAmountInL() {
        return amountInL;
    }
}

interface HubbardOwner {
    Milk pullHubbard();
}

class Milkmaid {
    public Milk milk(HubbardOwner milkable) {
        int amount = 0;
        for (int i = 0; i < 2; i++) {
            amount += milkable.pullHubbard().getAmountInL();
        }
        return new Milk(amount);
    }
}

class Cow implements HubbardOwner {
    public Milk pullHubbard() {
        return new Milk(5);
    }
}

class Goat implements HubbardOwner {
    public Milk pullHubbard() {
        return new Milk(10);
    }
}

