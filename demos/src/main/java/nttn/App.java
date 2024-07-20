package nttn;
import nttn.demo.*;

public class App 
{
    public static void main( String[] args )
    {
        DemoTemplate demo = new DemoTemplate();


        iDemoContent starfield = new Starfield();
        iDemoContent pointsLines = new PointsLines();
        iDemoContent circlesAndEllipses = new CirclesAndEllipses();
        iDemoContent curves = new Curves();

        //demo.run(starfield);
        //demo.run(pointsLines);
        //demo.run(circlesAndEllipses);
        demo.run(curves);


    }
}
