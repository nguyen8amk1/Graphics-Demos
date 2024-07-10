package nttn.core;

import java.util.Arrays; 

public class Bitmap { 
    private final int width, height; 
    private final byte components[]; // the color elements

    public Bitmap(int width, int height) {
        this.width = width; 
        this.height = height; 
        this.components = new byte[width*height*4];
    }

    public void clear(byte shade) {
        Arrays.fill(this.components, shade);
    }

    // public void clear(byte r, byte g, byte b, byte a) {
    //     Arrays.fill(this.components, shade)
    // }

    public void setPixel(int x, int y, byte r, byte g, byte b, byte a) {
        // NOTE: we're using ABRG format 
        int index = (x + y*width)*4;
        this.components[index] = a;
        this.components[index + 1] = b;
        this.components[index + 2] = g;
        this.components[index + 3] = r;
    }

    public byte[] getAsBytesArray() {
        byte byteArray[] = new byte[this.width*this.height*3];

        for(int i = 0; i < this.width * this.height; i++) {
            byteArray[i*3]     = this.components[i*4 + 1];
            byteArray[i*3 + 1] = this.components[i*4 + 2];
            byteArray[i*3 + 2] = this.components[i*4 + 3];
        }

        return byteArray;
    }

    public void copyToDestBytesArray(byte[] dest) {
        for(int i = 0; i < this.width * this.height; i++) {
            dest[i*3]     = this.components[i*4 + 1];
            dest[i*3 + 1] = this.components[i*4 + 2];
            dest[i*3 + 2] = this.components[i*4 + 3];
        }
    }

    public int getWidth() {return this.width;}
    public int getHeight() {return this.height;}
}
