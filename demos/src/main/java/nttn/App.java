package nttn;
import nttn.demo.*;

public class App 
{
    public static void main( String[] args )
    {
        // Test some demos 
        // iDemo starfield = new Starfield();
        // starfield.run();

        // LWJGL_HelloWorld helloworld = new LWJGL_HelloWorld();
        // helloworld.run();
        //iDemo points = new Points();
        
        DemoTemplate demo = new DemoTemplate();

        // iDemoContent pointsLines = new PointsLines();
        // demo.run(pointsLines);

        iDemoContent circlesAndEllipses = new CirclesAndEllipses();
        demo.run(circlesAndEllipses);

        // iDemoContent starfield = new Starfield();
        // demo.run(starfield);
    }
}
