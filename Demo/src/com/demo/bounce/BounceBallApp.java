package com.demo.bounce;
import java.awt.*;
import javax.swing.*;

public class BounceBallApp extends JApplet {
	public BounceBallApp() {
		add(new BallControl());
	}
}