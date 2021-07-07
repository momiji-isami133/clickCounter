package com.clicCounter.window;

import javax.swing.JLabel;

public class NumberArea extends JLabel {
	
	public NumberArea() {
		super();
	}
	
	public NumberArea(Integer n) {
		super(n.toString());
	}
	
	public void setNumber(Integer n) {
		super.setText(n.toString());
	}
}
