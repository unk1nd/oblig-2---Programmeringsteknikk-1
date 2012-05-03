package oppgave2;

public class Cylinder extends Shape{

	private double height, radius;  
	
	public Cylinder(double r, double h)
	{
		height = h;
		radius = r;
	}

	public double area()
	{
		return Math.PI*radius*radius*height;
	}

	public String toString()
	{
		return super.toString() + " of radius " + radius + " and height " + height;
	}
}