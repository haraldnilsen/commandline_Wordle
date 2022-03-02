package controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SpillWordleGUI implements ActionListener {

	private int count = 0;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JTextField input;

	public void startSpill() {
		frame = new JFrame();
		panel = new JPanel();
		
		
		JLabel guess11 = new JLabel("A");
		JLabel guess12 = new JLabel("B");
		JLabel guess13 = new JLabel("C");
		JLabel guess14 = new JLabel("D");
		JLabel guess15 = new JLabel("E");
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		input = new JTextField(5);
		
		panel.add(input);
		gbc.gridy = 0;
		panel.add(guess11,gbc);
		gbc.gridy = 1;
		panel.add(guess12,gbc);
		panel.add(guess13,gbc);
		panel.add(guess14,gbc);
		panel.add(guess15,gbc);
		
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
	}
}
