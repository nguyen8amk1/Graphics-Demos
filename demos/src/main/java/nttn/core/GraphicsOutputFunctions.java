package nttn.core;

import java.util.Arrays; 

public class GraphicsOutputFunctions { 
    private final Bitmap bitmap;
    private final byte a = (byte)255, r = (byte)255, g = (byte)255, b = (byte)255; 
    private final CommonMath m = new CommonMath();  

    public GraphicsOutputFunctions(Bitmap bitmap) {
        this.bitmap = bitmap;
    } 

    public void setPixel(int x, int y) {
        bitmap.setPixel(x, y, a, r, g, b);
    }

    public void getPixel(int x, int y) {
        //bitmap.setPixel(x, y, a, r, g, b);
        //
        //throw new Exception("TODO: I haven't implement this function yet, return the intensive property");
    }

    public void point(int x, int y) {
        this.setPixel(x, y);
        //bitmap.setPixel(x, y, a, r, g, b);
        //
        //throw new Exception("TODO: I haven't implement this function yet, return the intensive property");
    }

    public void ddaLine(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        float xIncrement, yIncrement; 
        float x = x1; 
        float y = y1; 
        
        int steps = 0;

        if(m.abs(dx) > m.abs(dy)) 
            steps = (int) m.abs(dx);
        else 
            steps = (int) m.abs(dy);

        xIncrement = dx/(float)steps;
        yIncrement = dy/(float)steps;

        //System.out.println(steps);

        this.setPixel(m.round(x), m.round(y));

        for(int i = 0; i < steps; i++) {
            x += xIncrement;
            y += yIncrement;
            this.setPixel(m.round(x), m.round(y));
        }

    }

    public void bresLine(int x1, int y1, int x2, int y2) {

    }

    public void parralellBresLine(int x1, int y1, int x2, int y2, byte a, byte r, byte g, byte b) {
    }

    public void line(int x1, int y1, int x2, int y2, byte a, byte r, byte g, byte b) {
        this.parralellBresLine(x1, y2, x2, y2, a, r, g, b);
    }

    public void circle() {

    }

    public void ellipse() {

    }

    public void fillArea() { // input: an array of vertices

    }


    // public void setPixel(int x, int y, byte a, byte r, byte g, byte b) {
    //     bitmap.setPixel(x, y, a, r, g, b);
    // }
}
