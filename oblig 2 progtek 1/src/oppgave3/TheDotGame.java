package oppgave3;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class TheDotGame {
	
	static JFrame ramme = new JFrame ("The Dot Game");
	static JFrame gameintro = new JFrame ("The Dot Game");
	static JButton start = new JButton ("Start");
	
	public static void main (String[] arps)
	{
		new TheDotGame();
	}
	
		

	public TheDotGame() 
	{
		String topmessage = "<html><br><br>The Dot Game</html>";
    	String message = 
    				"<html>"+
    				"Trykk på ringen som kommer på skjermen. <br><br>"+	
    				"Hvite feltet gir 2 poeng.<br> "+
    				"Grå feltet gir 1 poeng.<br><br>"+
    				"Hvor mange poeng klarer du på 40 sekunder?<br>"+
    				"NB: Hastigheten økes."+
    				"</html> ";
        
    	
        start.addActionListener (new startgame());
        
       
        JLabel tekst = new JLabel(message, SwingConstants.CENTER); 
        JLabel toptekst = new JLabel(topmessage, SwingConstants.CENTER);
        
        Font font = new Font("Helvetica", Font.BOLD, 15);
        tekst.setFont(font);
        
        Font font2 = new Font("Helvetica", Font.BOLD, 35);
        toptekst.setFont(font2);
        
        
        gameintro.setTitle("The Dot Game");
        
        gameintro.add(tekst);
        
        gameintro.add(toptekst, BorderLayout.PAGE_START);
        JPanel nedredel = new JPanel();
        
        nedredel.add(start);
        
        gameintro.add(nedredel, BorderLayout.PAGE_END);
        gameintro.setSize(400, 400);
        gameintro.setLocationRelativeTo(null);
        gameintro.setVisible(true);
        gameintro.setResizable(false);
		
	}

	 private class startgame implements ActionListener
	    {
	      
	       public void actionPerformed (ActionEvent event)
	       {
	    	   ramme.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    	   ramme.getContentPane().add(new Board());
	    	   ramme.pack();
	    	   ramme.setAlwaysOnTop(true);
	    	   ramme.setVisible(true);
	    	   ramme.setResizable(false);
	    	   ramme.setLocationRelativeTo(null);
	    	   gameintro.dispose();
	       }
	    }
}
