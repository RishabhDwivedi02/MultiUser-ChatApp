package com.multi.chatapp.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	int counter;
	public UserView() {
		counter = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setResizable(false);
		setTitle("Login");
		setLocationRelativeTo(null);//always place an item in center.
//		setLocation(510, 160);//helps to place an item where u want to place it.
		JLabel welcome = new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		Container c = this.getContentPane();
		c.setLayout(null);
		welcome.setBounds(100, 50, 150, 60);
		c.add(welcome);
		JButton button = new JButton("count");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				counter++;
				welcome.setText("count" +counter);
			}
		});
		setVisible(true);
	    button.setBounds(100, 159, 100, 50);
   	    c.add(button);
  }
	public static void main(String[] args) {
		UserView userview = new UserView();
	}
}
