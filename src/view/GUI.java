package view;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Main;

public class GUI{
	
	private JTextField addLatency;
	private JTextField subLatency;
	private JTextField mulLatency;
	private JTextField divLatency;
	private JTextArea codeText;
	private JButton simulateButton;
	
	public GUI() {
		Rectangle sizeRec = new Rectangle(30, 30, 150, 20);
		JFrame frame = new JFrame("Tomasulo");
		
		JLabel addLabel = new JLabel("Addition Latency:");
		addLabel.setBounds(30, 30, 150, 20);
		frame.add(addLabel);
		
		addLatency = new JTextField();
		addLatency.setBounds(190, 30, 150, 20);
		frame.add(addLatency);
		
		JLabel subLabel = new JLabel("Subtraction Latency:");
		subLabel.setBounds(30, 60, 150, 20);
		frame.add(subLabel);
		
		subLatency = new JTextField();
		subLatency.setBounds(190, 60, 150, 20);
		frame.add(subLatency);
		
		JLabel mulLabel = new JLabel("Multiplication Latency:");
		mulLabel.setBounds(30, 90, 150, 20);
		frame.add(mulLabel);
		
		mulLatency = new JTextField();
		mulLatency.setBounds(190, 90, 150, 20);
		frame.add(mulLatency);
		
		JLabel divLabel = new JLabel("Multiplication Latency:");
		divLabel.setBounds(30, 120, 150, 20);
		frame.add(divLabel);
		
		divLatency = new JTextField();
		divLatency.setBounds(190, 120, 150, 20);
		frame.add(divLatency);
		
		JLabel codeLabel = new JLabel("Assembly Code(MIPS):");
		codeLabel.setBounds(30, 150, 150, 20);
		frame.add(codeLabel);
		
		codeText = new JTextArea();
		JScrollPane scroll = new JScrollPane (codeText, 
				   JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(30, 170, 350, 150);
		frame.add(scroll);
		
		simulateButton = new JButton("Simulate");
		simulateButton.setBounds(200, 350, 100, 20);
		frame.add(simulateButton);
		
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void bindButton(Main listener) {
		simulateButton.addActionListener(listener);
	}
	
	public static void main(String []args) {
		new GUI();
	}

	
	
	

}
