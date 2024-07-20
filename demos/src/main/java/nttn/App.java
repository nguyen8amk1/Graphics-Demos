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


        iDemoContent starfield = new Starfield();
        iDemoContent pointsLines = new PointsLines();
        iDemoContent circlesAndEllipses = new CirclesAndEllipses();

        //demo.run(starfield);
        demo.run(pointsLines);
        //demo.run(circlesAndEllipses);

        // iDemoContent conicSections = new ConicSections();
        // demo.run(conicSections);

        // iDemoContent polynomialsAndSplines = new PolynomialsAndSplines();
        // demo.run(polynomialsAndSplines);

    }
}
