package nttn.demo;
import nttn.core.Display;
import nttn.core.Bitmap;


//public class Starfield implements iDemo
public class Starfield implements iDemoContent
{

    private float starsX[], starsY[], starsZ[]; 
    private int starsCount = 1000;

    private int width;
    private int height;
    private int halfWidth;
    private int halfHeight;

    //private final Display display; 
    private Bitmap bitmap; 
    
    final int speed = 1;

    public Starfield() {
    }

    private void initStar(int index) {
        float spread = 1;
        starsX[index] = (2 * ((float)Math.random() - .5f) * spread);
        starsY[index] = (2 * ((float)Math.random() - .5f) * spread);
        starsZ[index] = (((float)Math.random() + .00001f) * spread);

    }

    @Override
    public void load(DemoTemplate templateInfo) {
        starsX = new float[starsCount];
        starsY = new float[starsCount];
        starsZ = new float[starsCount];

        for(int i = 0; i < starsCount; i++) {
            this.initStar(i);
        }
    
        // display = new Display(800, 600, "Demo Starfield");
        // bitmap = new Bitmap(display.getWidth(), display.getHeight());
        
        this.bitmap = templateInfo.getBitmap();
        //Bitmap bitmap = templateInfo.getBitmap();

        width = bitmap.getWidth();
        height = bitmap.getHeight();
        halfWidth = width/2;
        halfHeight = height/2;
    }

    @Override
    public void run(float deltaTime) {
        for(int i = 0; i < starsCount; i++) {
            starsZ[i] -= deltaTime * speed; 

            if(starsZ[i] <= 0) {
                initStar(i);
            }


            int x = (int)((starsX[i]/starsZ[i]) * halfWidth + halfWidth);
            int y = (int)((starsY[i]/starsZ[i]) * halfHeight + halfHeight);

            final boolean outOfBounds = 
                (x < 0 || x >= width) || 
                (y < 0 || y >= height);

            if(outOfBounds) {
                this.initStar(i);
                continue;
            }

            //System.out.println(x + " " + y);
            bitmap.drawPixel(x, y, (byte)255, (byte)255, (byte)255, (byte)255);
        }

    }
}
