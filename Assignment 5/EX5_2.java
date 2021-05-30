import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX5_2 extends JFrame {
	String expression = "";
	String[] operators = { "+", "-", "/", "*" };
	JPanel resultPanel;
	JPanel clearPanel;
	JPanel calculatePanel;
	


	public EX5_2() {
		setTitle("°è»ê±â");
		setSize(900,900);
		
		// ====== [ Init result panel ]============
		resultPanel = new JPanel();
		JTextField resultField = new JTextField(30);
		
		resultField.setEditable(false);
		resultField.setText(expression);
		
		resultPanel.add(resultField);
		
		// ====== [ Init clear panel ]============
		clearPanel = new JPanel();
		clearPanel.setLayout(new GridLayout(0, 1));
		JButton clearButton = new JButton("C");
		
		clearButton.addActionListener(e ->{
			expression = "";
			resultField.setText(expression);
		});
		clearPanel.add(clearButton);
		
		// ====== [ Init calculate panel ]============
		calculatePanel = new JPanel();
		calculatePanel.setLayout(new GridLayout(4, 4, 3, 3));
		
		// Init operand buttons
		for (int i = 0; i < 10; i++) {
			JButton button = new JButton(i+"");
			
			button.addActionListener(e -> {
				JButton target = (JButton) e.getSource();
				
				if (target == button) {
					expression += (button.getText());
					resultField.setText(expression);
				}
			});
	
			calculatePanel.add(button);
		}
		
		// Init operator buttons
		for (String operator : operators) {
			JButton button = new JButton(operator);

			button.addActionListener(e -> {
				JButton target = (JButton) e.getSource();
				
				if (target == button) {
					expression += (button.getText());
					resultField.setText(expression);
				}
			});
	
			calculatePanel.add(button);
		}
		
		JButton equalButton = new JButton("=");

		equalButton.addActionListener(e -> {
			String operator = getOperator(expression);
			if (operator.length() != 0) {
				String[] parsed = expression.split("\\"+operator);
				int op1 = Integer.parseInt(parsed[0]);
				int op2 = Integer.parseInt(parsed[1]);
				
				if (operator != "/" && op2 != 0) {
					expression = eval(op1, op2, operator) + "";
					resultField.setText(expression);
				}
				
			}
		});
		
		calculatePanel.add(equalButton);
		
		// add panels to frame
		add(resultPanel, BorderLayout.NORTH);
		add(clearPanel, BorderLayout.CENTER);
		add(calculatePanel, BorderLayout.SOUTH);
	
		pack();
		setVisible(true);
	}
	
	private String getOperator(String exp) {
		for (String operator:operators) {
			if (exp.contains(operator)) {
				return operator;
			}
		}
		return "";
	}
	
	private int eval(int op1, int op2, String operator) {
		switch(operator) {
		case "+": return op1 + op2;
		case "-": return op1 - op2;
		case "*": return op1 * op2;
		case "/": return op1 / op2;
		default: return 0;
		}
	}

	public static void main(String[] args) {
		EX5_2 f = new EX5_2();
		
	}

}
