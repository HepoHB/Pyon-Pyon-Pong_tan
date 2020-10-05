package PingPong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable,KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 210;
	public static final int HEIGHT = 120;
	public static final int SCALE = 3;
	public boolean isRunning = true;
	public static boolean TwoPlayer;
	public boolean FT = false;
	public BufferedImage Layer = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	public static Player User;
	public static Player2 User2;
	public static Enemy Villain;
	public static Bora Ball;
	
	public Game(){
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		this.addKeyListener(this);
		User = new Player(0,160);
		Ball = new Bora(WIDTH*SCALE/2-20,HEIGHT*SCALE/2-20);
		Villain = new Enemy(610,HEIGHT*SCALE-107*3);
		User2 = new Player2(610,HEIGHT*SCALE-107*3);

	}
	

	public static void main(String[] args){
		Game Gamer = new Game();
		JFrame Windows = new JFrame("Pong");
		Windows.setResizable(false);
		Windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Windows.setVisible(true);
		Windows.add(Gamer);
		Windows.pack();
		Windows.setLocationRelativeTo(null);
		
		new Thread(Gamer).start();
		
	}
	
	public void Casting(){
		User.Casting();
		if(!TwoPlayer){
			Villain.Casting();
		} else{
			User2.Casting();
			
		}
		Ball.Casting();
		
	}
	public void Magic(){
		requestFocus();
		BufferStrategy BS = this.getBufferStrategy();
		if(BS == null){
			this.createBufferStrategy(3);
			return;
			
		}
		Graphics Graph = Layer.getGraphics();
		Graph = BS.getDrawGraphics();
		Graph.drawImage(Layer,0,0,WIDTH*SCALE,HEIGHT*SCALE,null);
		Graph.setColor(new Color(0,0,0));
		Graph.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		Player.Magic(Graph);
		Ball.Magic(Graph);
		if(!TwoPlayer) {
			Villain.Magic(Graph);			
			
		} else {
			Player2.Magic(Graph);		
			
		}

		BS.show();
		
	}
	
	@Override
	public void run(){
		final double FPS = 60.0;
		long lastTime = System.nanoTime();
		final double NS = 1000000000 / FPS;
		double Timer = 0;
		double MiliTimer = System.currentTimeMillis();
		int Frame = 0;
		while(isRunning){
			if(FT){
				
				
			} else {
				long Now = System.nanoTime();
				Timer += (Now - lastTime) / NS;
				lastTime = Now;
				if(Timer >= 1){
					Casting();
					Magic();
					Frame++;
					Timer--;
					
				}
				if(System.currentTimeMillis() - MiliTimer >=1 ){
					System.out.println("FPS: " + Frame);
					Frame = 0;
					MiliTimer += 1000;
					
				}
		
			}
			
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case  KeyEvent.VK_W:
				User2.UPPER = false;
				User2.BOTTOM = true;
			break;
			case KeyEvent.VK_S:
				User2.BOTTOM = false;
				User2.UPPER = true;
			break;
			case  KeyEvent.VK_UP:
				User.UPPER = false;
				User.BOTTOM = true;
			break;
			case KeyEvent.VK_DOWN:
				User.BOTTOM = false;
				User.UPPER = true;
			break;
			case KeyEvent.VK_1:
				TwoPlayer = false;
				new Game();
				return;
		case KeyEvent.VK_2:
				TwoPlayer = true;
				new Game();
				return;
				
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
			User.BOTTOM = false;
			User.UPPER = false;
		
		} else if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
			User2.BOTTOM = false;
			User2.UPPER = false;	
			
		}
		
	}
	

}
