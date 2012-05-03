package oppgave2;

public class Rectangle extends Shape{

	private double height, length;  
	
	public Rectangle(double h, double l)
	{
		height = h;
		length = l;
	}
	

	public double area()
	{
		return height*length;
	}

	public String toString()
	{
		return super.toString() + " of lenght " + length + " and height " + height;
	}
}