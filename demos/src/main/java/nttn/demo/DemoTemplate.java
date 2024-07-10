package nttn.demo;
import nttn.core.Display;
import nttn.core.Bitmap;


public class DemoTemplate {
    private final Display display;
    private final Bitmap bitmap;

    public DemoTemplate() {
        display = new Display(800, 600, "Points demo");
        bitmap = new Bitmap(display.getWidth(), display.getHeight());
    }

    public Bitmap getBitmap() {return bitmap;}

    public void run(iDemoContent demo)
    {
        demo.load(this);

        long prevTime  = System.nanoTime();

        while(true) {
            long currentTime = System.nanoTime();

            display.renderBitmap(bitmap);
            bitmap.clear((byte)0x0);

            float deltaTime = (currentTime - prevTime)/1000000000.0f;

            demo.run(deltaTime);

            // // work 
            //
            // for(int i = 0; i < starsCount; i++) {
            //     starsZ[i] -= deltaTime * speed; 
            //
            //     if(starsZ[i] <= 0) {
            //         initStar(i);
            //     }
            //
            //
            //     int x = (int)((starsX[i]/starsZ[i]) * halfWidth + halfWidth);
            //     int y = (int)((starsY[i]/starsZ[i]) * halfHeight + halfHeight);
            //
            //     final boolean outOfBounds = 
            //         (x < 0 || x >= width) || 
            //         (y < 0 || y >= height);
            //
            //     if(outOfBounds) {
            //         this.initStar(i);
            //         continue;
            //     }
            //
            //     //System.out.println(x + " " + y);
            //     bitmap.drawPixel(x, y, (byte)255, (byte)255, (byte)255, (byte)255);
            // }
            // // 


            prevTime = currentTime;
        }
    }
}
