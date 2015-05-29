package com.demo.bounce;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.util.ArrayList;


public class BallBox extends JPanel { 
	private ArrayList ballArray = new ArrayList();
	private int delay = 10;
	private Timer timer = new Timer(delay, new TimerListener());
	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i=0; i<6; i++){
			Ball ball =(Ball)ballArray.get(i);
			ball.ballMove(g);
		}
	}
	public BallBox(){
		init();
	}
	public void init(){
		timer.start();
		for (int i=0; i<6; i++){
			Ball ball = new Ball(this);
			ballArray.add(ball);
			ball.invis();
		}
		Ball ball =(Ball)ballArray.get(0);
		ball.revis();
	}
	public void setVis(int i){
			for(int j=0; j<i; j++){
				Ball ball =(Ball)ballArray.get(j);
				ball.revis();
			} for (int j=i; j<6; j++){
				Ball ball =(Ball)ballArray.get(j);
				ball.invis();
			}
	}
}