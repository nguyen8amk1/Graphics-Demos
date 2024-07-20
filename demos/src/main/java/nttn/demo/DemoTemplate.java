package nttn.demo;

import nttn.core.*;


public class DemoTemplate {
    private final GraphicsOutput gfxOutput; 
    private final GraphicsInput gfxInput; 

    public DemoTemplate() {
        this.gfxOutput = new GraphicsOutput();
        this.gfxInput = new GraphicsInput(gfxOutput.getBitmap());
    }


    public void run(iDemoContent demo)
    {
        demo.setup(gfxInput, gfxOutput);

        long prevTime  = System.nanoTime();

        while(true) {
            long currentTime = System.nanoTime();

            gfxOutput.update();
            gfxOutput.clear((byte)0x0);

            float deltaTime = (currentTime - prevTime)/1000000000.0f;

            demo.loop(deltaTime);

            prevTime = currentTime;
        }
    }
}
