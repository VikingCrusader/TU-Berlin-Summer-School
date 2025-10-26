package day9;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIEx1 {

	public static void main(String[] args) {
		
		//设置窗口
		JFrame frame = new JFrame("My First GUI");
		frame.setSize(300, 400); // Pixel
		
		//panel
		JPanel panel = new JPanel ();
		//panel.setLayout(null);
		frame.add(panel);
		
		//设置标签 分层的，后面的Layer会覆盖前面的
		JLabel label1 = new JLabel("This is my first GUI");
		label1.setBounds(20,20,200,50); //using null layout
		panel.add(label1);
		
		JLabel label2 = new JLabel("This is my second line of text");
		panel.add(label2);
		label1.setBounds(20,60,200,50);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口就终止程序
		frame.setVisible(true);
	}

}
