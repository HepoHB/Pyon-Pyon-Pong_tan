package PingPong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	double XL; 
	double YL;
	public static int WIDTHER = 20;
	public static int HEIGHTER = 120;
	public Enemy(int X, int Y){
		this.XL = X;
		this.YL = Y;
		
	}
	
	public void Casting(){
		YL += (Game.Ball.YV - YL - 6) * 0.25;
		
		if(YL + HEIGHTER < Game.HEIGHT){
			YL = Game.HEIGHT - Player.HEIGHTER;
			
		} else if(YL > Game.HEIGHT+120) {
			YL = Game.HEIGHT+120;
			
		}
		
	}
	public void Magic(Graphics Graph){
		Graph.setColor(new Color(255,255,255));
		Graph.fillRect((int)XL, (int)YL, WIDTHER, HEIGHTER);
		
	}

}
