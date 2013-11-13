package swingPractice;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen implements ItemListener {
	
	private JFrame frame;
	private JPanel panel;
	private JPanel cards;
	
	private Card card1;
	private Card card2;
	private Card card3;

	private final String CARD1STRING = "Card with GridBagLayout";
	private final String CARD2STRING = "Card #2 TBD";
	private final String CARD3STRING = "Card #3 TBD";
	
	public Screen() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(320, 240));
		panel = new JPanel();
		BoxLayout b = new BoxLayout(panel, 1);
		panel.setLayout(b);
		cards = new JPanel(new CardLayout());

		JPanel comboBoxPane = new JPanel();
		String comboBoxItems[] = { CARD1STRING, CARD2STRING, CARD3STRING };
		JComboBox<String> cb = new JComboBox<String>(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);
		
		card1 = new Card(0);
		cards.add(card1, CARD1STRING);
		
		card2 = new Card(0);
		cards.add(card2, CARD2STRING);
		
		card3 = new Card(2);
		cards.add(card3, CARD3STRING);
		
		panel.add(comboBoxPane);
		panel.add(cards);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public void itemStateChanged(ItemEvent evt) {
	    CardLayout cl = (CardLayout)(cards.getLayout());
	    cl.show(cards, (String)evt.getItem());
	    frame.pack();
	}
}
