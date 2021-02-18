package lt.staupasedvinas;

//enkapsuliacija
//paveldejimas
//polimorfizmas
//abstrakcija (is 2 ir 3)

public class Main {

    public static void main(String[] args) {
	NumberBox numberBox1 = new NumberBox();
	NumberBox numberBox2 = new NumberBox();
	numberBox1.setNumber(8);
	numberBox2.setNumber(9);

	//numberBox1.number = 8 ar kažkaip panašiai negalima, nes private.
	System.out.println(numberBox1.getNumber());
	System.out.println(numberBox2.getNumber());
    }
}
