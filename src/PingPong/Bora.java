package PingPong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bora {
	double XV; 
	double YV;
	public double DX, DY;
	public double SPEEDOSTAR = 10;
	public static int WIDTHER = 20;
	public static int HEIGHTER = 20;
	
	public Bora(int X, int Y){
		XV = X;
		YV = Y;
		
		int Angle = new Random().nextInt(60);
		
		DY = Math.sin(Math.toRadians(Angle));
		DX = Math.cos(Math.toRadians(Angle));
		
	}
	
	public void Casting(){
		if(YV + (DY * SPEEDOSTAR) + HEIGHTER >= Game.HEIGHT*Game.SCALE){
			DY *= -1;
			
		} else if(YV + (DY * SPEEDOSTAR) < 0) {
			DY *= -1;
			
		}
		
		if(XV >= Game.WIDTH*Game.SCALE){
			new Game();
			return;
			
		} else if(XV < 0){
			new Game();
			return;
			
		}
		
		Rectangle Bownling = new Rectangle((int)(YV + (DY * SPEEDOSTAR)),(int)(XV + (DX * SPEEDOSTAR)),HEIGHTER,WIDTHER);
		Rectangle Playering = new Rectangle(Player.YR,Player.XR,Player.HEIGHTER,Player.WIDTHER);
		Rectangle Playering2 = new Rectangle(Player2.YR,Player2.XR,Player2.HEIGHTER,Player2.WIDTHER);
		Rectangle Villaining = new Rectangle((int)Game.Villain.YL,(int)Game.Villain.XL,Enemy.HEIGHTER,Enemy.WIDTHER);
		int Angle = new Random().nextInt(60);
		
		if(Bownling.intersects(Playering)){
			DX *= -1;
			DY = Math.sin(Math.toRadians(Angle));
			if(DX < 0){
				DX *= -1;
				
			}
			
		} else if(!Game.TwoPlayer) {
			if(Bownling.intersects(Villaining)){
				DX *= -1;
				DY = Math.sin(Math.toRadians(Angle));
				if(DX > 0){
					DX *= -1;
					
				} 
				
			
			}
			
		} else {
			if(Bownling.intersects(Playering2)) {
				DX *= -1;
				DY = Math.sin(Math.toRadians(Angle));
				if(DX > 0){
					DX *= -1;
					
				}
			}
			
		}
	
		
		YV += DY*SPEEDOSTAR;
		XV += DX*SPEEDOSTAR;
		
	}
	public void Magic(Graphics Graph){
		Graph.setColor(new Color(255,255,255));
		Graph.fillRect((int)XV, (int)YV, WIDTHER, HEIGHTER);
		
	}
}
