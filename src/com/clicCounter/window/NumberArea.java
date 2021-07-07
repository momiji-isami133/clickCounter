package com.clicCounter.window;

import javax.swing.JLabel;

/**
 * 
 * @author momiji-isami133
 *
 *整数型の値を格納するラベルクラス
 */
public class NumberArea extends JLabel {
	
	/**
	 * コンストラクタ
	 */
	public NumberArea() {
		super();
	}
	
	/**
	 * コンストラクタ
	 * @param n 整数型の値
	 */
	public NumberArea(Integer n) {
		super(n.toString());
	}
	
	/**
	 * 整数型の値をセット
	 * @param n 整数型の値
	 */
	public void setNumber(Integer n) {
		super.setText(n.toString());
	}
}
