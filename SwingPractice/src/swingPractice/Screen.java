package swingPractice;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen implements ItemListener, ActionListener {
	
	private JFrame frame;
	private JPanel panel;
	private JPanel cards;
	
	private Card current;
	
	private Card card1;
	private Card card2;
	private Card card3;

	private static final String CARD1STRING = "Card with GridBagLayout";
	private static final String CARD2STRING = "Card with GroupLayout";
	private static final String CARD3STRING = "Card with MigLayout";
	
	private List<String> CARDLIST = new ArrayList<String>();
	
	public Screen() {
		frame = new JFrame("Swing Practice");
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
		
		JButton submitButton = new JButton("Print State");
		submitButton.addActionListener(this);
		
		card1 = new Card(0);
		current = card1;
		cards.add(card1, CARD1STRING);
		
		card2 = new Card(1);
		cards.add(card2, CARD2STRING);
		
		card3 = new Card(2);
		cards.add(card3, CARD3STRING);
		
		CARDLIST.add(CARD1STRING);
		CARDLIST.add(CARD2STRING);
		CARDLIST.add(CARD3STRING);
		
		panel.add(comboBoxPane);
		panel.add(cards);
		panel.add(submitButton);
		
		frame.setContentPane(panel);
		
		show();
	}
	
	public void show() {
		frame.pack();
		frame.setVisible(true);
	}

	public void itemStateChanged(ItemEvent evt) {
		String s = (String)evt.getItem();
	    CardLayout cl = (CardLayout)(cards.getLayout());
	    cl.show(cards, s);
	    current = (Card) cards.getComponent(CARDLIST.indexOf(s));
	    frame.pack();
	}

	public void actionPerformed(ActionEvent arg0) {
		current.showState();
	}
}
