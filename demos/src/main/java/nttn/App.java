package nttn;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        Display display = new Display(800, 600, "Demo Window");
        Bitmap bitmap = new Bitmap(display.getWidth(), display.getHeight());
        bitmap.clear((byte)100);

        while(true) {
            display.renderBitmap(bitmap);
        }
    }
}
