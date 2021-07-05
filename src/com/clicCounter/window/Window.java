package com.clicCounter.window;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Window extends JFrame{
	/** 引数なしコンストラクタ */
	public Window() {}
	
	/**
	 * 引数ありコンストラクタ
	 * @param width 横幅
	 * @param height 縦幅
	 * @param title タイトル
	 */
	public Window(int width,int height,String title) {
		getContentPane().setLayout(new FlowLayout());
		
		super.setTitle(title);
		super.setSize(width, height);
		super.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
