package swingPractice;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class Card extends JPanel {
	
	private JRadioButton button1;
	private JRadioButton button2;
	private JRadioButton button3;
	
	private JCheckBox checkbox1;
	private JCheckBox checkbox2;
	
	private JToggleButton toggleButton;
	
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	public Card(int layoutType) {
		super();
		
		button1 = new JRadioButton("JRadioButton 1", true);
		button2 = new JRadioButton("JRadioButton 2");
		button3 = new JRadioButton("JRadioButton 3");
		
		checkbox1 = new JCheckBox("JCheckBox 1");
		checkbox2 = new JCheckBox("JCheckBox 2");
		
		toggleButton = new JToggleButton("JToggleButton");
		
		textArea = new JTextArea("JTextArea");
		scrollPane = new JScrollPane(textArea);
		
		ButtonGroup group = new ButtonGroup();
		group.add(button1);
		group.add(button2);
		group.add(button3);
		
		layOut(layoutType);
	}
	
	public Card() {
		this(0); //Default is GridBagLayout
	}
	
	public Card(int i, String s) {
		this(i);
	}
	
	private void layOut(int type) {
		switch(type) {
		case 0:
			constructWithGridBagLayout();
			break;
		case 2:
			break;
		default:
			throw new IllegalArgumentException("Invalid layout type");
		}
	}
	
	private void constructWithGridBagLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		c.insets = new Insets(5, 5, 5, 5);
		
		c.gridx = 0;
		c.gridy = 0;
		add(button1, c);
		
		c.gridy = 1;
		add(button2, c);
		
		c.gridy = 2;
		add(button3, c);
		
		c.gridx = 1;
		c.gridy = 0;
		add(checkbox1, c);
		
		c.gridy = 1;
		add(checkbox2, c);

		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.NONE;
		add(toggleButton, c);
		
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 3;
		c.fill = GridBagConstraints.BOTH;
		add(scrollPane, c);
	}
}
