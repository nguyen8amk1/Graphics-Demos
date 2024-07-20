package nttn.demo;

import nttn.core.*;


public class CirclesAndEllipses implements iDemoContent
{
    private GraphicsOutputFunctions gfxOutput; 
    private GraphicsInputFunctions gfxInput; 

    @Override
    public void setup(DemoTemplate templateInfo) {
        gfxOutput = new GraphicsOutputFunctions(templateInfo.getBitmap());
        gfxInput = new GraphicsInputFunctions(templateInfo.getBitmap());

    }

    @Override
    public void loop(float deltaTime) {
        gfxOutput.circleMidpoint(200, 200, 100);
        gfxOutput.ellipseMidpoint(400, 200, 100, 200);
    }
}
