import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class EX5_3 extends JFrame implements ActionListener{

	private JPanel labelPanel;
	private JPanel typePanel;
	private JPanel toppingPanel;
	private JPanel sizePanel;
	private JPanel costPanel;
	private JTextField costField;
	private JButton okButton, cancelButton;
	
	String[] types = {"콤보(10000원)", "포테이토(11000원)", "불고기(12000원)"};
	String[] toppings = {"피망(1000원)", "치즈(2000원)", "페페로니(3000원)", "베이컨(4000원)"};
	String[] sizes = {"Small(5000원)", "Medium(6000원)", "Large(7000원)"};

	JRadioButton[] typeButtons;
	JRadioButton[] sizeButtons;
	JRadioButton[] toppingButtons;
	
	public EX5_3() {
		setTitle("피자 주문하기!");

		// =========== [ Init Label Panel ]============
		labelPanel = new JPanel();
		labelPanel.add(new JLabel("자바 피자에 오신 것을 환영합니다."));
		
		// =========== [ Init Type Panel ]============
		typePanel = new JPanel();
		typePanel.setBorder(BorderFactory.createTitledBorder("종류"));
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
		
		ButtonGroup typeButtonGroup = new ButtonGroup();
		typeButtons = new JRadioButton[3];
		
		for (int i = 0; i < typeButtons.length; i++) {
			int cost = 10000 + 1000 * i;
			typeButtons[i] = new JRadioButton(types[i]);
			typeButtonGroup.add(typeButtons[i]);
			typePanel.add(typeButtons[i]);
		}
		
		// =========== [ Init Topping Panel ]============
		toppingPanel = new JPanel();
		toppingPanel.setBorder(BorderFactory.createTitledBorder("추가 토핑"));
		toppingPanel.setLayout(new BoxLayout(toppingPanel, BoxLayout.Y_AXIS));
		
		ButtonGroup toppingButtonGroup = new ButtonGroup();
		toppingButtons = new JRadioButton[4];
		
		for (int i = 0; i < toppingButtons.length; i++) {
			int cost = 1000 + 1000 * i;
			toppingButtons[i] = new JRadioButton(toppings[i]);
			toppingButtonGroup.add(toppingButtons[i]);
			toppingPanel.add(toppingButtons[i]);
		}
		
		// =========== [ Init Size Panel ]============
		sizePanel = new JPanel();
		sizePanel.setBorder(BorderFactory.createTitledBorder("크기"));
		sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
		
		ButtonGroup sizeButtonGroup = new ButtonGroup();
		sizeButtons = new JRadioButton[3];
		
		for (int i = 0; i < sizeButtons.length; i++) {
			int cost = 1000 + 1000 * i;
			sizeButtons[i] = new JRadioButton(sizes[i]);
			sizeButtonGroup.add(sizeButtons[i]);
			sizePanel.add(sizeButtons[i]);
		} 
		
		// =========== [ Init Cost Panel ]============
		costPanel = new JPanel();
		okButton = new JButton("주문");
		cancelButton = new JButton("취소");
		costField = new JTextField(10);
		
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		costField.setEditable(false);
		costField.setText(0 + "원");
		
		costPanel.add(okButton);
		costPanel.add(cancelButton);
		costPanel.add(costField);
		
		// Add panels to window
		add(labelPanel, BorderLayout.NORTH);
		add(typePanel, BorderLayout.WEST);
		add(toppingPanel, BorderLayout.EAST);
		add(sizePanel, BorderLayout.CENTER);
		add(costPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		int cost = 0;
		JButton target = (JButton) e.getSource();
		JRadioButton[] buttons;

		if (target == okButton) {
			for (JRadioButton button : typeButtons) {
				if (button.isSelected()) {
					cost += getSelectedCost(button);
					break;
				}
			}
			
			for (JRadioButton button : sizeButtons) {
				if (button.isSelected()) {
					cost += getSelectedCost(button);
					break;
				}
			}
			
			for (JRadioButton button : toppingButtons) {
				if (button.isSelected()) {
					cost += getSelectedCost(button);
					break;
				}
			}
		}
		
		setCostField(cost);
	}
	
	private int getSelectedCost(JRadioButton selected) {
		String name = selected.getText();
		String[] parsed = name.split("\\(|원");
		int cost = Integer.parseInt(parsed[1]);
		
		return cost;
	}
	
	private void setCostField(int cost) {
		costField.setText(cost + "원");
	}
	
	public static void main(String[] args) {
		EX5_3 f = new EX5_3();
	}

}
