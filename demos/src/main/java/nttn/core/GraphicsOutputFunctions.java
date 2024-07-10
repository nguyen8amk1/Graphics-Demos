package nttn.core;

import java.util.Arrays; 

public class GraphicsOutputFunctions { 
    private final Bitmap bitmap;

    public GraphicsOutputFunctions(Bitmap bitmap) {
        this.bitmap = bitmap;
    } 

    public void setPixel(int x, int y, byte a, byte r, byte g, byte b) {
        bitmap.setPixel(x, y, a, r, g, b);
    }

    public void getPixel(int x, int y) {
        //bitmap.setPixel(x, y, a, r, g, b);
        //
        //throw new Exception("TODO: I haven't implement this function yet, return the intensive property");
    }

    public void point(int x, int y, byte a, byte r, byte g, byte b) {
        this.setPixel(x, y, a, r, g, b);
        //bitmap.setPixel(x, y, a, r, g, b);
        //
        //throw new Exception("TODO: I haven't implement this function yet, return the intensive property");
    }

    public void ddaLine(int x1, int y1, int x2, int y2, byte a, byte r, byte g, byte b) {


    }

    public void bresLine(int x1, int y1, int x2, int y2, byte a, byte r, byte g, byte b) {

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
