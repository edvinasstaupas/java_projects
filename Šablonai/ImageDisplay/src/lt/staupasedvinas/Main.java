package lt.staupasedvinas;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            DisplayImage ex = new DisplayImage();
            ex.setVisible(true);
        });
    }
}
