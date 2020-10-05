package PingPong;

import java.awt.Color;
import java.awt.Graphics;

public class Player2{
	
	public boolean UPPER;
	public boolean BOTTOM;
	public static int YR;
	public static int XR;
	public static int WIDTHER = 20;
	public static int HEIGHTER = 120;
	
	public Player2(int R, int L){
		Player2.XR = R;
		Player2.YR = L;
		
	}
	
	public void Casting(){
		if(UPPER){
			YR += 5;
			
		} else if(BOTTOM){
			YR -= 5;
			
		}
		
		if(YR + HEIGHTER < Game.HEIGHT){
			YR = Game.HEIGHT - Player.HEIGHTER;
			
		} else if(YR > Game.HEIGHT+120) {
			YR = Game.HEIGHT+120;
			
		}
		
	}
	public static void Magic(Graphics Graph){
		Graph.setColor(new Color(255,255,255));
		Graph.fillRect(XR, YR, WIDTHER, HEIGHTER);
		
	}

}
