package oppgave3;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;



@SuppressWarnings("serial")
public class Board extends JPanel implements MouseListener
{

	private Timer timer, timer2;
	private final int WIDTH = 640, HEIGHT = 480;
	int DELAY = 1350;
	private int x, y, sirkel_size = 74;
	private int sirkelhalv_size = sirkel_size/2;
	private int points, lastscore = 0, highscore = 0;
	private long startTime;
	private boolean gameover;
	private int timetoend = 40;
	private JButton restart = new JButton ("Restart");
	
	public Board()
	{
		startTime = System.currentTimeMillis();
		timer = new Timer(DELAY, new BoardListener());
		timer2 = new Timer(1000, new countdown());
		timer2.start();
		
		
		Random generator = new Random();
		int rx = generator.nextInt(WIDTH-(sirkel_size*2)) +1;
		int yx = generator.nextInt(HEIGHT-(sirkel_size*2)) +1;
		x = rx;
		y = yx;
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setBackground(Color.black);
		addMouseListener(this);
		add(restart, BorderLayout.PAGE_END);
		restart.addActionListener(new reset());
		restart.setVisible(false);
		gameover = false;
		timer.start();
	}
	
	public void paintComponent (Graphics g)
	{
		
		super.paintComponent(g);
		if(gameover) 
		{	
			
			Font font1 = new Font("Helvetica", Font.PLAIN,  35);
			FontMetrics fm = this.getFontMetrics(font1);
			
			Font font2 = new Font("Helvetica", Font.PLAIN, 15);
			int width = fm.stringWidth("Game Over!");
			g.setColor(Color.RED);
			g.setFont(font1);
			g.drawString("Game Over!", WIDTH / 2 - width / 2, HEIGHT / 2 - 30);
			g.setColor(Color.gray);
			width = fm.stringWidth("Du klarte " + points + "poeng pŒ 40 sekunder.");
			g.drawString("Du klarte " + points + " poeng pŒ 40 sekunder.", WIDTH / 2 - width / 2, HEIGHT / 2 + 30);
			lastscore = points;
			if (points>highscore)
			{
				highscore = points;
				g.setColor(Color.green);
				width = fm.stringWidth("NEW HIGHSCORE!!");
				g.drawString("NEW HIGHSCORE!!",WIDTH / 2 - width / 2,HEIGHT / 2 + 70);
			}
			g.setColor(Color.white);
			g.setFont(font2);
			g.drawString("Bendiksen Development", 470, 475);

		} 
		else 
		{
			
			g.setColor(Color.gray);
			g.fillOval(x, y, sirkel_size, sirkel_size);
			g.setColor(Color.white);
			g.fillOval(x+(sirkelhalv_size/2), y+(sirkelhalv_size/2), sirkelhalv_size, sirkelhalv_size);
		
			g.setColor(Color.WHITE);
			g.drawString("Poeng: " + points, 5, 15);	
			g.setColor(Color.WHITE);
			g.drawString("Tid igjen: ", 5, 30);
			
			if(System.currentTimeMillis() - startTime > 10000)
			{
				if(System.currentTimeMillis() - startTime > 20000)
				{
					
					if(System.currentTimeMillis() - startTime > 30000)
					{
						g.setColor(Color.red);
						g.drawString("Warp SPEED!!", 5, 45);	
					}
					else
					{
						g.setColor(Color.red);
						g.drawString("Raskeste hastighet.", 5, 45);
					}
				}
				
				else 
				{
				g.setColor(Color.orange);
				g.drawString("Hastighet ¿kt.", 5, 45);
				}
			}
			
			g.drawString(timetoend + " sec",70,30);
			g.setColor(Color.white);
			g.drawString("Last Score: " + lastscore, 540,15);
			g.drawString("Highscore: " + highscore, 540,30);
			
			
		}
	}
	
	private class countdown implements ActionListener
	{
		
		public void actionPerformed ( ActionEvent event)
		{
			timetoend--;
			repaint();
		}
	}
	
	private class reset implements ActionListener
	{
		
		public void actionPerformed ( ActionEvent event)
		{
			reset();
		}
	}
	
	public void reset()
	{
		startTime = System.currentTimeMillis();
		timer = new Timer(DELAY, new BoardListener());
		timer2 = new Timer(1000, new countdown());
		timetoend = 40;
		lastscore = points;
		
		points = 0;
		timer2.start();
		
		
		Random generator = new Random();
		int rx = generator.nextInt(WIDTH-(sirkel_size*2)) +1;
		int yx = generator.nextInt(HEIGHT-(sirkel_size*2)) +1;
		x = rx;
		y = yx;
		restart.setVisible(false);
		gameover = false;
		timer.start();
		repaint();
	}
	
	private class BoardListener implements ActionListener
	{
		
		public void actionPerformed ( ActionEvent event)
		{
			Random generator = new Random();
			int rx = generator.nextInt(WIDTH-50) +1;
			int yx = generator.nextInt(HEIGHT-50) +1;
			x = rx;
			y = yx;
			repaint();
			
			if(System.currentTimeMillis() - startTime > 10000)
			{
				if(System.currentTimeMillis() - startTime > 20000)
				{
					if(System.currentTimeMillis() - startTime > 30000)
					{
						timer.setDelay(700);
					}
					else 
						timer.setDelay(900);
				}
				else
				timer.setDelay(1000);
				
			}
			
			if(System.currentTimeMillis() - startTime > 40000) {
				gameover = true;
				x = WIDTH+200;
    	        y = HEIGHT+200;
				repaint();
				timer.stop();
				timer2.stop();
				restart.setVisible(true);
			}
		}
	}	
	
	public void mousePressed(MouseEvent me) 
	{
    	
    	int musX = me.getX();
    	int musY = me.getY();
    	
    	Point musposisjon = new Point(musX, musY);
    	Point sirkelposisjon = new Point(x + sirkelhalv_size, y + sirkelhalv_size);

    	    int avstand = (int) Math.sqrt(Math.pow(musposisjon.getX() - sirkelposisjon.getX(), 2) + Math.pow(musposisjon.getY() - sirkelposisjon.getY(), 2));

    	    if (avstand < (sirkelhalv_size + 1)) {
    	        if (avstand < ((sirkelhalv_size + 1) / 2)) 
    	        {
    	            points += 2;
    	        } 
    	        else 
    	        {
    	            points += 1;
    	        }
    	        
    	        x = WIDTH+200;
    	        y = HEIGHT+200;
    	        repaint();
    	    }
    	
    }
	
    public void mouseExited(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
    public void mouseClicked(MouseEvent me) {}	
    
    
}
