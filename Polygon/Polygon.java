package Polygon;
import java.lang.Math;
import java.awt.geom.Point2D;
import java.util.*;

abstract public class Polygon {
	public int[] vertices;
    public Polygon(int[] vertices){
    	this.vertices = vertices;
    }
    public Polygon(Point2D.Double[] points){
       Scanner sc = new Scanner(System.in);
       double x1 = sc.nextDouble();
       double y1 = sc.nextDouble();
       points = new Point2D(x1, y1);
    }
    public double distance(Point2D.Double p1, Point2D.Double p2){
        double distance = Math.pow(p1.getX() - p2.getX(), 2) - Math.pow(p1.getY() - p2.getY(), 2);
        return distance;
    }
    abstract public double area();
    
    public double perimeter(int[] vertices){
        int perimeter;
        int x = perimeter.distance;
        return perimeter;
    }
}
