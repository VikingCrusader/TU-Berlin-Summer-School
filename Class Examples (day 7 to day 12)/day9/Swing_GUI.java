package day9;

import javax.swing.*;

public class Swing_GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("我的第一个GUI");
        JButton button = new JButton("点我");

        // 点击按钮时弹出对话框
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Hello, Java GUI!"));

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
