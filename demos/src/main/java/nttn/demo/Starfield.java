package nttn.demo;
import nttn.core.Display;
import nttn.core.Bitmap;


public class Starfield 
{
    private final float starsX[], starsY[], starsZ[]; 
    private final int starsCount = 1000;

    public Starfield() {
        starsX = new float[starsCount];
        starsY = new float[starsCount];
        starsZ = new float[starsCount];

        for(int i = 0; i < starsCount; i++) {
            this.initStar(i);
        }
    }

    private void initStar(int index) {
        float spread = 1;
        starsX[index] = (2 * ((float)Math.random() - .5f) * spread);
        starsY[index] = (2 * ((float)Math.random() - .5f) * spread);
        starsZ[index] = (((float)Math.random() + .00001f) * spread);

    }

    public void run()
    {
        Display display = new Display(800, 600, "Demo Starfield");
        Bitmap bitmap = new Bitmap(display.getWidth(), display.getHeight());
        long prevTime = System.nanoTime();  

        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();
        final int halfWidth = width/2;
        final int halfHeight = height/2;

        final int speed = 1;
        
        while(true) {
            long currentTime = System.nanoTime();

            display.renderBitmap(bitmap);
            bitmap.clear((byte)0);

            float deltaTime = (currentTime - prevTime)/1000000000.0f;

            for(int i = 0; i < starsCount; i++) {
                starsZ[i] -= deltaTime * speed; 

                if(starsZ[i] <= 0) {
                    initStar(i);
                }


                // TODO: convert to screen coord before render 
                int x = (int)((starsX[i]/starsZ[i]) * halfWidth + halfWidth);
                int y = (int)((starsY[i]/starsZ[i]) * halfHeight + halfHeight);

                final boolean outOfBounds = 
                    (x < 0 || x >= width) || (y < 0 || y >= height);

                if(outOfBounds) {
                    this.initStar(i);
                    continue;
                }

                //System.out.println(x + " " + y);
                bitmap.drawPixel(x, y, (byte)255, (byte)255, (byte)255, (byte)255);
            }

            prevTime = currentTime;
        }
    }
}
