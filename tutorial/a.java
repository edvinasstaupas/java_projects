import javax.swing.JOptionPane;

public class a {
    public static void main (String[] args) {
        String inputString = "Input a number";
        String stringedNumber = JOptionPane.showInputDialog(inputString);        
        int number = Integer.parseInt(stringedNumber);
        String answer = "";
        for(int i = 1; i <= 10; ++i) {
            String line = number + " * " + i + " = " + number * i + "\n";
            answer += line;
        }
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
}