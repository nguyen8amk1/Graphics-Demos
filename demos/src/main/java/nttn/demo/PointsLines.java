package nttn.demo;

import nttn.core.*;


public class PointsLines implements iDemoContent
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
        gfxOutput.point(400, 200);
        gfxOutput.point(400, 300);
        gfxOutput.point(400, 400);
        gfxOutput.point(400, 500);
        gfxOutput.point(400, 550);

        gfxOutput.ddaLine(200, 200, 400, 300);
    }
}
