package view;

import javax.swing.*;

public class GUI {

	private JTextField addLatency;
	private JTextField subLatency;
	private JTextField mulLatency;
	private JTextField divLatency;
	private JTextField stLatency;
	private JTextField ldLatency;
	private JTextArea codeText;
	private JButton simulateButton;

	public String getAddLatency() {
		return addLatency.getText();
	}

	public String getSubLatency() {
		return subLatency.getText();
	}

	public String getMulLatency() {
		return mulLatency.getText();
	}

	public String getDivLatency() {
		return divLatency.getText();
	}

	public String getStLatency() {
		return stLatency.getText();
	}

	public String getLdLatency() {
		return ldLatency.getText();
	}

	public String getCodeText() {
		return codeText.getText();
	}

	public JButton getSimulateButton() {
		return simulateButton;
	}

	public GUI() {
		JFrame frame = new JFrame("Tomasulo");

		JLabel addLabel = new JLabel("Addition Latency:");
		addLabel.setBounds(30, 30, 150, 20);
		frame.add(addLabel);

		addLatency = new JTextField("2");
		addLatency.setBounds(190, 30, 150, 20);
		frame.add(addLatency);

		JLabel subLabel = new JLabel("Subtraction Latency:");
		subLabel.setBounds(30, 60, 150, 20);
		frame.add(subLabel);

		subLatency = new JTextField("2");
		subLatency.setBounds(190, 60, 150, 20);
		frame.add(subLatency);

		JLabel mulLabel = new JLabel("Multiplication Latency:");
		mulLabel.setBounds(30, 90, 150, 20);
		frame.add(mulLabel);

		mulLatency = new JTextField("10");
		mulLatency.setBounds(190, 90, 150, 20);
		frame.add(mulLatency);

		JLabel divLabel = new JLabel("Division Latency:");
		divLabel.setBounds(30, 120, 150, 20);
		frame.add(divLabel);

		divLatency = new JTextField("40");
		divLatency.setBounds(190, 120, 150, 20);
		frame.add(divLatency);

		JLabel stLabel = new JLabel("Store Latency:");
		stLabel.setBounds(30, 150, 150, 20);
		frame.add(stLabel);

		stLatency = new JTextField("2");
		stLatency.setBounds(190, 150, 150, 20);
		frame.add(stLatency);

		JLabel ldLabel = new JLabel("Load Latency:");
		ldLabel.setBounds(30, 180, 150, 20);
		frame.add(ldLabel);

		ldLatency = new JTextField("2");
		ldLatency.setBounds(190, 180, 150, 20);
		frame.add(ldLatency);

		JLabel codeLabel = new JLabel("Assembly Code(MIPS):");
		codeLabel.setBounds(30, 210, 150, 20);
		frame.add(codeLabel);

		codeText = new JTextArea();
		JScrollPane scroll = new JScrollPane(codeText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(30, 240, 350, 150);
		frame.add(scroll);

		simulateButton = new JButton("Simulate");
		simulateButton.setBounds(200, 410, 100, 20);
		frame.add(simulateButton);

		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

}
