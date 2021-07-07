package com.clicCounter.window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author momiji-isami133
 * 
 * ウィンドウを作成するクラス
 */
public class Window extends JFrame implements ActionListener{
	/** 増減ボタン */
	private ArrayList<JButton> buttons;
	/** カウント */
	private Integer count;
	/** 画面 */
	private Container contentPane;
	/** ボタン配置用パネル */
	private JPanel buttonPane;
	/** カウント表示領域 */
	private NumberArea numberArea;
	/** テキスト表示領域 */
	private JLabel textArea;
	/** フォント */
	private Font font;;
	
	/** 引数なしコンストラクタ */
	public Window() {}
	
	/**
	 * 引数ありコンストラクタ
	 * @param width 横幅
	 * @param height 縦幅
	 * @param title タイトル
	 */
	public Window(int width,int height,String title) {
		count = 0;
		// ウィンドウの初期化
		initializeFrame(width, height, title);
		
		// ボタンを一つずつ登録
		for(JButton button:buttons) {
			button.addActionListener(this);
			buttonPane.add(button);
		}
		// 画面上部にテキストを表示
		contentPane.add(textArea, BorderLayout.PAGE_START);
		// 画面中央にカウントを表示
		contentPane.add(numberArea, BorderLayout.CENTER);
		// 画面下部にボタンを表示
		contentPane.add(buttonPane, BorderLayout.PAGE_END);
		
	}
	
	/**
	 * ボタン押下時の制御
	 * @param e ボタン押下時のイベント
	 */
	public void actionPerformed(ActionEvent e) {
		// 押されたボタンを取得
		String cmd = e.getActionCommand();
		// ボタンに応じて処理を切り替え
		switch(cmd) {
		case "-10":
			count -= 10;
			if(count < 0) {
				count = 0;
			}
			numberArea.setNumber(count);
			break;
		case "-1":
			count--;
			if(count < 0) {
				count = 0;
			}
			numberArea.setNumber(count);
			break;
		case "clear":
			count = 0;
			numberArea.setNumber(count);
			break;
		case "+1":
			count++;
			numberArea.setNumber(count);
			break;
		case "+10":
			count += 10;
			numberArea.setNumber(count);
			break;
		default:
			count = 0;
			numberArea.setText("error! count is initialize!");
		}
	}
	
	/**
	 * ウィンドウ作成時の初期化
	 * @param width 画面の横幅
	 * @param height 画面の立幅
	 * @param title 画面名
	 */
	public void initializeFrame(int width,int height,String title) {
		// 画面名の設定
		setTitle(title);
		// 画面サイズの設定
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 画面のリサイズの可否設定
		setResizable(false);
		
		// フォント設定
		font = new Font("Times new roman", Font.PLAIN, 24);
		
		// ボタン初期化
		buttons = initializeButton();
		
		numberArea = new NumberArea(count);
		numberArea.setFont(font);
		numberArea.setHorizontalAlignment(JLabel.CENTER);
		textArea = new JLabel("0以上の整数でカウント");
		textArea.setFont(new Font("",Font.BOLD,24));
		textArea.setHorizontalAlignment(JLabel.CENTER);
		contentPane = getContentPane();
		buttonPane = new JPanel();
	}
	
	/**
	 * ボタンを初期化する
	 * @return 初期化されたボタンのリスト
	 */
	public ArrayList<JButton> initializeButton() {
		JButton[] buttnList = {
			new JButton("-10"),
			new JButton("-1"),
			new JButton("clear"),
			new JButton("+1"),
			new JButton("+10")
		};
		ArrayList<JButton> buttons = new ArrayList<JButton>(Arrays.asList(buttnList));
		for(JButton button : buttons) {
			button.setFont(font);
		}
		return buttons;
	}
}
