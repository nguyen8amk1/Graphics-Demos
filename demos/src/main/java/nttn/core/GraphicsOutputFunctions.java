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
        // TODO: 

    }

    public void parralellBresLine(int x1, int y1, int x2, int y2, byte a, byte r, byte g, byte b) {
        // TODO: 
    }

    public void line(int x1, int y1, int x2, int y2) {
        //this.parralellBresLine(x1, y2, x2, y2, a, r, g, b);
        ddaLine(x1, y1, x2, y2);
    }

    public void polyLineAbsoluteCoord(int[] wcPoints) {
        int n = wcPoints.length;
        // TODO: coordinates transformation
        // wc: world absolute coordinates 
    }

    public void polyLineRelativeCoord(int[] wcPoints) {
        int n = wcPoints.length;
        // TODO: coordinates transformation
        // wc: world relative coordinates 
    }


    private void circlePlotPoints(int xCenter, int yCenter, int x, int y) {
        setPixel(xCenter + x, yCenter + y);
        setPixel(xCenter - x, yCenter + y);
        setPixel(xCenter + x, yCenter - y);
        setPixel(xCenter - x, yCenter - y);
        setPixel(xCenter + y, yCenter + x);
        setPixel(xCenter - y, yCenter + x);
        setPixel(xCenter + y, yCenter - x);
        setPixel(xCenter - y, yCenter - x);
    }

    public void circleMidpoint(int xCenter, int yCenter, int radius) {
        int x = 0;
        int y = radius;
        int p = 1 - radius;

        // Plot first set of points
        circlePlotPoints(xCenter, yCenter, x, y);

        while (x < y) {
            x++;
            if (p < 0) {
                p += 2 * x + 1;
            } else {
                y--;
                p += 2 * (x - y) + 1;
            }
            circlePlotPoints(xCenter, yCenter, x, y);
        }

    }

    private void ellipsePlotPoints(int xCenter, int yCenter, int x, int y) {
        setPixel(xCenter + x, yCenter + y);
        setPixel(xCenter - x, yCenter + y);
        setPixel(xCenter + x, yCenter - y);
        setPixel(xCenter - x, yCenter - y);
    }

    public void ellipseMidpoint(int xCenter, int yCenter, int Rx, int Ry) {
        int Rx2 = Rx * Rx;
        int Ry2 = Ry * Ry;
        int twoRx2 = 2 * Rx2;
        int twoRy2 = 2 * Ry2;
        int p;
        int x = 0;
        int y = Ry;
        int px = 0;
        int py = twoRx2 * y;

        ellipsePlotPoints(xCenter, yCenter, x, y);

        // Region 1
        p = m.round(Ry2 - (Rx2 * Ry) + (0.25 * Rx2));
        while (px < py) {
            x++;
            px += twoRy2;
            if (p < 0) p += Ry2 + px;
            else {
                y--;
                py -= twoRx2;
                p += Ry2 + px - py;
            }
            ellipsePlotPoints(xCenter, yCenter, x, y);
        }

        // Region 2
        p = m.round(Ry2 * (x + 0.5) * (x + 0.5) + Rx2 * (y - 1) * (y - 1) - Rx2 * Ry2);
        while (y > 0) {
            y--;
            py -= twoRx2;
            if (p > 0) p += Rx2 - py;
            else {
                x++;
                px += twoRy2;
                p += Rx2 - py + px;
            }
            ellipsePlotPoints(xCenter, yCenter, x, y);
        }

    }

    public void fillArea() { // input: an array of vertices

    }
}
