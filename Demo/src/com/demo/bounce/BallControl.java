package com.demo.bounce;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSpinner;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

public class BallControl extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3627190973870041069L;
	private JButton jbtSuspend = new JButton("Suspend");
	private JButton jbtResume = new JButton("Resume");
	private JScrollBar jsbDelay = new JScrollBar();
	private JSpinner jspBalls = new JSpinner();
	private BallBox bBox = new BallBox();

	public BallControl() {
		
		// group buttons in a panel
		JPanel panel = new JPanel();
		panel.add(jbtSuspend);
		panel.add(jbtResume);
		panel.add(jspBalls);


		// add ball and buttons to the panel
		jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
		
		jspBalls.setValue(1);
		
		setLayout(new BorderLayout());
		add(jsbDelay, BorderLayout.NORTH);
		add(panel, BorderLayout.SOUTH);
		add(bBox, BorderLayout.CENTER);
		
		
		bBox.setBorder(new javax.swing.border.LineBorder(Color.red));
		bBox.setDelay(jsbDelay.getMaximum());
		

		// register listeners
		jbtSuspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bBox.suspend();
			}
		});

		jbtResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bBox.resume();
			}
		});

		jsbDelay.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				bBox.setDelay(jsbDelay.getMaximum() - e.getValue());
				
			}
		});
		jspBalls.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSpinner spin = (JSpinner)e.getSource();
				int i = (Integer)spin.getValue();
				if (i<=0)
					spin.setValue(1);
				else if (i<=6){
					bBox.setVis(i);
				} else {
					spin.setValue(6);
				}
			}
		});
	}
}