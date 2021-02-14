import javax.swing.JOptionPane;
/**
Tutorial project
Author: Edvinas Staupas
Title: b
 */
public class b {
    int x;
    String name;

    public b (int a, String n) {
        x = a;
        name = n;
    }
    public void printX (b item) {
        System.out.println(item.name + " is " + item.x + " y.o.");
    }

    public void changeX (b item) {
        System.out.println(item.name + " is " + item.x + " y.o.");
    }

    public static void main (String[] args) {
        b item = new b(15, "E");
        item.printX(item);
        item.x = 20;
        
        //System.out.println(item.a + item.x);
        item.printX(item);
        System.exit(0);
    }
}