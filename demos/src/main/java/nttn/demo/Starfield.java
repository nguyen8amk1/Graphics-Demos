package nttn.demo;
import nttn.core.*;


//public class Starfield implements iDemo
public class Starfield implements iDemoContent
{
    private float starsX[], starsY[], starsZ[]; 
    private int starsCount = 1000;

    private int width;
    private int height;
    private int halfWidth;
    private int halfHeight;

    private GraphicsOutput gfxOutput; 
    private GraphicsInput gfxInput; 
    
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
    public void setup(final GraphicsInput gfxInput, final GraphicsOutput gfxOutput) {
        starsX = new float[starsCount];
        starsY = new float[starsCount];
        starsZ = new float[starsCount];

        for(int i = 0; i < starsCount; i++) {
            this.initStar(i);
        }
        
        this.gfxOutput = gfxOutput;
        this.gfxInput = gfxInput;

        width = gfxInput.getXMax();
        height = gfxInput.getYMax();
        halfWidth = width/2;
        halfHeight = height/2;
    }

    @Override
    public void loop(final float deltaTime) {
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

            gfxOutput.point(x, y);
        }

    }
}
