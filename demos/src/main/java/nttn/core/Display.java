package nttn.core;

import java.awt.*; 
import javax.swing.*; 
import java.awt.image.*;

public class Display extends Canvas { 
    private final JFrame jframe; 

    private final BufferedImage bufferedImage;
    private final BufferStrategy bufferStrategy;
    private final Graphics graphics;
    private byte displayBytes[];

    private final int width, height;

    public Display(int width, int height, String title) {
        this.width = width;
        this.height = height;

        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        this.jframe = new JFrame(title);
        this.jframe.add(this);
        this.jframe.pack();
        this.jframe.setResizable(false);
        this.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jframe.setLocationRelativeTo(null);
        this.jframe.setVisible(true);


        // setup the backbuffer
        createBufferStrategy(1);
        this.bufferStrategy = getBufferStrategy();
        this.graphics = this.bufferStrategy.getDrawGraphics();

        // NOTE: implicit pixel format information here  
        this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        this.displayBytes = ((DataBufferByte)this.bufferedImage.getRaster().getDataBuffer()).getData();

    }
    
    public void renderBitmap(Bitmap bitmap) {
        bitmap.copyToDestBytesArray(this.displayBytes);
        this.graphics.drawImage(this.bufferedImage, 0, 0, bitmap.getWidth(), bitmap.getHeight(), null);
        this.bufferStrategy.show();
    }

    public int getWidth() {return this.width;}
    public int getHeight() {return this.height;}

}
