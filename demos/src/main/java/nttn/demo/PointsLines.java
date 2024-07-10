package nttn.demo;
import nttn.core.*;


public class PointsLines implements iDemoContent
{
    private GraphicsOutputFunctions gfxOutput; 
    private GraphicsInputFunctions gfxInput; 

    @Override
    public void load(DemoTemplate templateInfo) {
        gfxOutput = new GraphicsOutputFunctions(templateInfo.getBitmap());
        gfxInput = new GraphicsInputFunctions(templateInfo.getBitmap());

    }

    @Override
    public void run(float deltaTime)
    {
        gfxOutput.point(200, 200, (byte)255, (byte)255, (byte)255, (byte)255);
    }
}
