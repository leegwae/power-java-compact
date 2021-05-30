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
	
	String[] types = {"�޺�(10000��)", "��������(11000��)", "�Ұ��(12000��)"};
	String[] toppings = {"�Ǹ�(1000��)", "ġ��(2000��)", "����δ�(3000��)", "������(4000��)"};
	String[] sizes = {"Small(5000��)", "Medium(6000��)", "Large(7000��)"};

	JRadioButton[] typeButtons;
	JRadioButton[] sizeButtons;
	JRadioButton[] toppingButtons;
	
	public EX5_3() {
		setTitle("���� �ֹ��ϱ�!");

		// =========== [ Init Label Panel ]============
		labelPanel = new JPanel();
		labelPanel.add(new JLabel("�ڹ� ���ڿ� ���� ���� ȯ���մϴ�."));
		
		// =========== [ Init Type Panel ]============
		typePanel = new JPanel();
		typePanel.setBorder(BorderFactory.createTitledBorder("����"));
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
		toppingPanel.setBorder(BorderFactory.createTitledBorder("�߰� ����"));
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
		sizePanel.setBorder(BorderFactory.createTitledBorder("ũ��"));
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
		okButton = new JButton("�ֹ�");
		cancelButton = new JButton("���");
		costField = new JTextField(10);
		
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		costField.setEditable(false);
		costField.setText(0 + "��");
		
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
		String[] parsed = name.split("\\(|��");
		int cost = Integer.parseInt(parsed[1]);
		
		return cost;
	}
	
	private void setCostField(int cost) {
		costField.setText(cost + "��");
	}
	
	public static void main(String[] args) {
		EX5_3 f = new EX5_3();
	}

}
