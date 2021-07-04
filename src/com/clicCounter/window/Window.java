package com.clicCounter.window;

import javax.swing.JFrame;

public class Window extends JFrame{
	/** 引数なしコンストラクタ */
	public Window() {	}
	
	/**
	 * 引数ありコンストラクタ
	 * @param width 横幅
	 * @param height 縦幅
	 * @param title タイトル
	 */
	public Window(int width,int height,String title) {
		super.setTitle(title);
		super.setSize(width, height);
	}
}
