package com.demo.bounce;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

public class Ball {
	private int x = 20;
	private int y = 20; // current ball position
	private int radius = 5; // ball radius
	private long dx = Math.round(Math.random()*4-2); // increment on ball's x-coordinate
	private long dy = Math.round(Math.random()*4-2); // increment on ball's y-coordinate
	private boolean vis = true;
	private Graphics grafx;
	private BallBox bBox;
	
	private Color myColor = Color.red;

	public Ball(BallBox b) {
		bBox=b;
	}


	public void ballMove(Graphics g) {
		g.setColor(myColor);

		// check boundaries
		if (x < radius){
			dx = Math.abs(dx);
			changeColor();
		} if (x > bBox.getWidth() - radius){
			dx = -Math.abs(dx);
			changeColor();
		} if (y < radius){
			dy = Math.abs(dy);
			changeColor();
		} if (y > bBox.getHeight() - radius){
			dy = -Math.abs(dy);
			changeColor();
		}
		
		// adjust ball position
		x += dx;
		y += dy;
		if (vis)
			g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	public void invis(){
		vis=false;
	}
	public void revis(){
		vis=true;
	}
	
	public void changeColor() {
		double myNum = Math.random() *10;
		if (myNum > 8){
			myColor = Color.blue;
		} else if (myNum > 6){
			myColor = Color.black;
		} else if (myNum > 4){
			myColor = Color.cyan;
		} else if (myNum > 2){
			myColor = Color.green;
		} else {
			myColor = Color.orange;
		}
	}
}