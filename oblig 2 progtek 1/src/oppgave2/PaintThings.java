package oppgave2;
import java.text.DecimalFormat;
public class PaintThings
	{
	//-----------------------------------------
	// Creates some shapes and a Paint object
	// and prints the amount of paint needed
	// to paint each shape.
	//-----------------------------------------
	public static void main (String[] args)
	{
		final double COVERAGE = 350;
		Paint paint = new Paint(COVERAGE);
		Rectangle deck;
		Sphere bigBall;
		Cylinder tank;

		double deckAmt, ballAmt, tankAmt;
		// Instantiate the three shapes to paint
		bigBall = new Sphere(15);
		deck = new Rectangle(20,30);
		tank = new Cylinder(10,30);
		
		// Compute the amount of paint needed for each shape
		ballAmt = bigBall.area()/COVERAGE;
		deckAmt = deck.area()/COVERAGE;
		tankAmt = tank.area()/COVERAGE;
		
		bigBall.setShapeName("Big Ball");
		deck.setShapeName("Deck");
		tank.setShapeName("Tank");
		
		paint.amount(bigBall);
		paint.amount(deck);
		paint.amount(tank);
		// Print the amount of paint for each.

		DecimalFormat fmt = new DecimalFormat("0.#");
		
		
		System.out.println ("\nNumber of gallons of paint needed...");
		System.out.println ("Deck " + fmt.format(deckAmt));
		System.out.println ("Big Ball " + fmt.format(ballAmt));
		System.out.println ("Tank " + fmt.format(tankAmt));
		
		System.out.println ("\nTotal: " + fmt.format(tankAmt+ballAmt+deckAmt) + " gallons");
	}
}