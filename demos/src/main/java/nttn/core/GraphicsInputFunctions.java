package nttn.core;

import java.util.Arrays; 

public class GraphicsInputFunctions { 
    private final Bitmap bitmap;

    public GraphicsInputFunctions(Bitmap bitmap) {
        this.bitmap = bitmap;
    } 

    public int getXMax() { return bitmap.getWidth(); }
    public int getYMax() { return bitmap.getHeight(); }

    // LOCATOR-a dcl.vce for sperltyinga coordinate posltlon ( x , y)
    // STROKE-+ dtv1c.e for specifying a series of coordinate positions
    // STRING-.. a drviie for specifying text input
    // VALUATOR-'1 de\-ice for specifying scalar value:
    // CHOICE-a deu~Lefor selecting nwnu options
    // PICK-a device tc%rselecting picturc componen
}
