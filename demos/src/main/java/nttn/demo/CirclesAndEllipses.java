package nttn.demo;

import nttn.core.*;


public class CirclesAndEllipses implements iDemoContent
{
    private GraphicsOutput gfxOutput; 
    private GraphicsInput gfxInput; 

    @Override
    public void setup(final GraphicsInput gfxInput, final GraphicsOutput gfxOutput) {
        this.gfxOutput = gfxOutput;
        this.gfxInput = gfxInput;
    }

    @Override
    public void loop(float deltaTime) {
        gfxOutput.circleMidpoint(200, 200, 100);
        gfxOutput.ellipseMidpoint(400, 200, 100, 200);
    }
}
