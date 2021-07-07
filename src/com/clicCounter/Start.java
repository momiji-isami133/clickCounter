package com.clicCounter;

import com.clicCounter.window.Window;

/**
 * 
 * @author momiji-isami133
 *
 *アプリケーション実行用クラス
 */
public class Start {

	/**
	 * メインクラス
	 * @param args 特に使わない引数
	 */
	public static void main(String[] args) {
		var window = new Window(400,300,"Click Counter");
		window.setVisible(true);
	}

}
