package nttn;

import java.awt.*; 
import javax.swing.*; 

public class Display extends Canvas { 
    private final JFrame jframe; 

    public Display(int width, int height, String title) {

        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        jframe = new JFrame(title);
        jframe.add(this);
        jframe.pack();
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
    
}
