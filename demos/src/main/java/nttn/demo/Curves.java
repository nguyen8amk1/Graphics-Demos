package nttn.demo;

import nttn.core.*;


public class Curves implements iDemoContent
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
        // TODO: output curves 
    }
}
