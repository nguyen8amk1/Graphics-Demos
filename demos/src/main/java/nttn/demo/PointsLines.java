package nttn.demo;

import nttn.core.*;


public class PointsLines implements iDemoContent
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
        gfxOutput.point(400, 200);
        gfxOutput.point(400, 300);
        gfxOutput.point(400, 400);
        gfxOutput.point(400, 500);
        gfxOutput.point(400, 550);

        // gfxOutput.ddaLine(200, 200, 400, 300);
        gfxOutput.line(200, 200, 400, 300);
        gfxOutput.circleMidpoint(200, 200, 100);



        //const int[] worldCoordPoints = []; 
        //gfxOutput.polyLine(worldCoordPoints);
        // gfxOutput.bresLine(200, 200, 400, 300);
    }
}
