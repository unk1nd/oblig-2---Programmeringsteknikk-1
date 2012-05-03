package oppgave1;
import java.text.DecimalFormat;

public class Commission extends Hourly
{
	double totalSales = 0;
	double earnrate = 0; 
	
	public Commission (String eName, String eAddress, String ePhone, String socSecNumber, double rate, double earnrate)
	{
		super (eName, eAddress, ePhone, socSecNumber, rate);
		this.earnrate = earnrate;
	}
	
	public void addSales(double totalSales)
	{
		this.totalSales = totalSales;
	}
	
	public double getSumPercent()
	{
		return ((totalSales*earnrate)/100);
	}
	
	public double getTotalSales() 
	{
		return totalSales;
	}
	
	public String getPercent()
	{
		DecimalFormat df1 = new DecimalFormat("###.##");
        return (df1.format(earnrate));
		
	}
	
	public double pay()
	{
		double payment = super.pay() + getSumPercent();
		totalSales = 0;
		return payment;
		// trenger ikke Œ sette timene til 0 pga hourly klassen setter hoursWorked til 0
		
	}
	
	public String toString()
	{
		String result = super.toString();
		result += "\nCurrent bonus: " + getPercent() + "% of " + getTotalSales() + " = " + getSumPercent();
		return result;
	}
}
