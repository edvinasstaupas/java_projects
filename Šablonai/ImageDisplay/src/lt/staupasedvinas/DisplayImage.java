package lt.staupasedvinas;

import javax.swing.*;
import java.awt.*;

public class DisplayImage extends JFrame {

    public DisplayImage() {

        initUI();
    }

    private void initUI() {

        ImageIcon ii = loadImage();

        JLabel label = new JLabel(ii);

        label.setForeground(Color.BLACK);

        createLayout(label);

        setTitle("Image");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private ImageIcon loadImage() {

        ImageIcon ii = new ImageIcon("src/images/snake.jpg");
        return ii;
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        pack();
    }
}