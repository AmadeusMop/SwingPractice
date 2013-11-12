package swingPractice;

import java.awt.*;
import javax.swing.*;

public class Screen {
	
	private JFrame frame;
	private JPanel panel;
	private JPanel cardSelector;
	private JPanel cards;
	
	private JPanel card1;
	private JPanel card2;
	private JPanel card3;
	
	public Screen() {
		frame = new JFrame();
		panel = new JPanel();
		
		cardSelector = new JPanel();
		cards = new JPanel(new CardLayout());
		cards.add(card1);
		constructCardWithGridBagLayout(card1);
		
		panel.add(cards);
		
		frame.setContentPane(panel);
	}
	
	private void constructCardWithGridBagLayout(JPanel card) {
		GridBagLayout layout = new GridBagLayout();
		card.setLayout(layout);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton button1 = new JRadioButton("JRadioButton 1");
		JRadioButton button2 = new JRadioButton("JRadioButton 2");
		JRadioButton button3 = new JRadioButton("JRadioButton 3");
		group.add(button1);
		group.add(button2);
		group.add(button3);
		
		JCheckBox checkbox1 = new JCheckBox("JCheckBox 1");
		JCheckBox checkbox2 = new JCheckBox("JCheckBox 2");
		
		JToggleButton toggleButton = new JToggleButton("JToggleButton");
		
		JTextArea textArea = new JTextArea("JTextArea");
		JScrollPane scrollPane = new JScrollPane(textArea);

		card.add(button1);
		card.add(button2);
		card.add(button3);
		card.add(checkbox1);
		card.add(checkbox2);
		card.add(toggleButton);
		card.add(scrollPane);
	}
}
