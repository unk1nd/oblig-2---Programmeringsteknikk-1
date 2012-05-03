package oppgave2;

public abstract class Shape {

	public String ShapeName;
	public double area;
	
	public void setShapeName(String ShapeName)
	{
		this.ShapeName = ShapeName;
	}
	
	public abstract double area();
	
	public String toString()
	{
		return ShapeName;
	}
}
