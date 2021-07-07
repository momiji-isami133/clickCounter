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

public class Window extends JFrame implements ActionListener{
	private NumberArea numberArea;
	private ArrayList<JButton> buttons;
	private Integer count;
	private Container contentPane;
	private JPanel buttonPane;
	private JLabel textArea;
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
		initializeFrame(width, height, title);
		
		for(JButton button:buttons) {
			button.addActionListener(this);
			buttonPane.add(button);
		}
		contentPane.add(textArea, BorderLayout.PAGE_START);
		contentPane.add(numberArea, BorderLayout.CENTER);
		contentPane.add(buttonPane, BorderLayout.PAGE_END);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
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
	
	public void initializeFrame(int width,int height,String title) {
//		getContentPane().setLayout(new FlowLayout());
		
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		font = new Font("Times new roman", Font.PLAIN, 24);
		
		buttons = initializeButton();
		count = 0;
		numberArea = new NumberArea(count);
		numberArea.setFont(font);
		numberArea.setHorizontalAlignment(JLabel.CENTER);
		textArea = new JLabel("0以上の整数でカウント");
		textArea.setFont(new Font("",Font.BOLD,24));
		textArea.setHorizontalAlignment(JLabel.CENTER);
		contentPane = getContentPane();
		buttonPane = new JPanel();
	}
	
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
