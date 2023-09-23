package skyblocktracker;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.json.JSONException;


public class Gui {
	
	
	
	@SuppressWarnings("static-access")
	public void SkyblockGui() {
		
		JFrame main = new JFrame("Skyblock Tracker");
		main.setSize(500, 500);
		main.getContentPane().setBackground(Color.decode("#212424"));
		main.setResizable(false);
		main.setLayout(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JTextField name = new JTextField();
		name.setBackground(Color.decode("#023020"));
		name.setForeground(Color.WHITE);
		name.setBounds(1, 1, 363, 30);
		
		JPanel skills = new JPanel();
		skills.setBorder(new LineBorder(Color.decode("#1F51FF"), 5, true));
		skills.setLayout(null);
		skills.setBackground(Color.BLACK);
		skills.setBounds(10, 80, 215, 200);
		
		JPanel money = new JPanel();
		money.setBorder(new LineBorder(Color.decode("#1F51FF"), 5, true));
		money.setLayout(null);
		money.setBackground(Color.BLACK);
		money.setBounds(250, 80, 215, 200);
		
		JPanel misc = new JPanel();
		misc.setBorder(new LineBorder(Color.decode("#1F51FF"), 5, true));
		misc.setLayout(null);
		misc.setBackground(Color.BLACK);
		misc.setBounds(10, 310, 455, 100);
		
		JLabel skillinfo = new JLabel("Skills (nur total xp weil api scheiﬂe)");
		skillinfo.setBounds(5, 0, 200, 30);
		skillinfo.setBackground(Color.BLACK);
		skillinfo.setForeground(Color.CYAN);
		
		JLabel moneyinfo = new JLabel("Geld");
		moneyinfo.setBounds(5, 0, 100, 30);
		moneyinfo.setForeground(Color.CYAN);
		
		JLabel bank = new JLabel("Kontostand");
		bank.setBounds(10, 25, 200, 30);
		bank.setBackground(Color.BLACK);
		bank.setForeground(Color.CYAN);
		
		JLabel purse = new JLabel("Purse");
		purse.setBounds(10, 45, 200, 30);
		purse.setBackground(Color.BLACK);
		purse.setForeground(Color.CYAN);
		
		JLabel fairysouls = new JLabel("Fairy Souls");
		fairysouls.setBounds(10, 10, 300, 30);
		fairysouls.setBackground(Color.BLACK);
		fairysouls.setForeground(Color.CYAN);
		
		JLabel joined = new JLabel("first joined");
		joined.setBounds(10, 30, 300, 30);
		joined.setBackground(Color.BLACK);
		joined.setForeground(Color.CYAN);
		
		@SuppressWarnings("rawtypes")
		JComboBox profiles = new JComboBox();
		profiles.setBounds(1, 33, 363 ,30);
		
		
		Button tracker = new Button("Suchen");
		tracker.setBounds(365, 1, 120, 30);
		tracker.setBackground(Color.GRAY);
		tracker.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {

				if(!name.getText().equalsIgnoreCase("")) {
					
					profiles.removeAllItems();
					
					Skyblocktracker sbtracker = new Skyblocktracker();
					try {
						sbtracker.skyblocktrackerapi(name.getText());
						
						for(int i = 0; i <= sbtracker.profilelist.size() - 1; i++) {
							
							profiles.addItem(sbtracker.profilelist.get(i));	
							
						}
					} catch (JSONException | IOException e1) {	e1.printStackTrace();	}			
				}				
			}
		});
		
		Button search = new Button("Ausw‰hlen");
		search.setBounds(365, 33, 120, 30);
		
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Skyblocktracker sbtracker = new Skyblocktracker();
				
				Map<String, Integer> valToNumber = new HashMap<>();
				
				for(int i = 0; i <= sbtracker.profilelist.size() - 1; i++) {

					valToNumber.put(sbtracker.profilelist.get(i), i);
				}
				
				String selectedValue = (String) profiles.getSelectedItem();
				
					try {
						sbtracker.apiReader(valToNumber.get(selectedValue));
					} catch (JSONException e1) {
						
						e1.printStackTrace();
					}
					
					BankDecoder decoder = new BankDecoder();
					decoder.Bank();
				
				bank.setText("Bank: " + decoder.returnBank() + " coins");
				purse.setText("Purse: " + decoder.returnPurse() + " coins");
				
				
				FairySouls souls = new FairySouls();
				souls.DecodeFairySouls();
				
				fairysouls.setText("Fairy Souls: " + souls.fairysouls + " / 240");
				
				DecodeTime time = new DecodeTime();
				time.Time();
				
				joined.setText("First Joined: " + time.date());

				Calculator calc = new Calculator();
				calc.calculateskills();

				Chop64 chop = new Chop64();
				chop.chop("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");
				
				
			
				
			}
			
			
			
		});
		
		
		tracker.setVisible(true);
		
		main.add(tracker);
		main.add(name);
		main.add(skills);
		main.add(money);
		main.add(misc);
		main.add(profiles);
		main.add(search);
		
		money.add(moneyinfo);
		
		money.add(purse);
		
		misc.add(fairysouls);
		misc.add(joined);
		
		money.add(bank);
		skills.add(skillinfo);
		main.setVisible(true);
		
		
		
	}

}
