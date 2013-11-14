package swingPractice;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class Card extends JPanel {
	public static final int GRID_BAG = 0;
	public static final int GROUP = 1;
	public static final int OTHER = 2;
	
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
		this(GRID_BAG); //Default is GridBagLayout
	}
	
	private void layOut(int type) {
		switch(type) {
		case GRID_BAG:
			constructWithGridBagLayout();
			break;
		case GROUP:
			constructWithGroupLayout();
		case OTHER:
			break;
		default:
			throw new IllegalArgumentException("Invalid layout type for Card: ");
		}
	}
	
	private void constructWithGroupLayout() {
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup()
										.addComponent(button1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(button2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(button3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										)
							    .addGroup(layout.createParallelGroup()
							    		.addComponent(checkbox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							    		.addComponent(checkbox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							    		.addComponent(toggleButton)
							    		)
							    )
						.addComponent(scrollPane)
				);
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
							.addComponent(button1)
				    		.addComponent(checkbox1)
				    		)
					.addGroup(layout.createParallelGroup()
							.addComponent(button2)
				    		.addComponent(checkbox2)
				    		)
				    .addGroup(layout.createParallelGroup()
							.addComponent(button3)
				    		.addComponent(toggleButton)
							)
				    .addComponent(scrollPane)
				);
		
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
	
	public void showState() {
		System.out.println("Enabled Buttons:");
		if(button1.isSelected()) System.out.println("\tJRadioButton 1");
		if(button2.isSelected()) System.out.println("\tJRadioButton 2");
		if(button3.isSelected()) System.out.println("\tJRadioButton 3");
		if(checkbox1.isSelected()) System.out.println("\tJCheckBox 1");
		if(checkbox2.isSelected()) System.out.println("\tJCheckBox 2");
		if(toggleButton.isSelected()) System.out.println("\tJToggleButton");
		System.out.print("Text box text: \"");
		System.out.print(textArea.getText());
		System.out.println("\"\n");
	}
}
