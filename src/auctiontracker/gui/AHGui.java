package auctiontracker.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import auctiontracker.Auctiontracker;
import constants.Constants;

public class AHGui {
	
	public int panelcount;
	public int page = 0;
	
	public String player;

	public void AuctionGui() {
		
		
		
		JFrame main = new JFrame("Skyblock Auction Tracker");
		main.setSize(817, 500);
		main.getContentPane().setBackground(Color.decode("#212424"));
		main.setResizable(false);
		main.setLayout(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
		
		JLabel playername = new JLabel();
		playername.setForeground(Color.WHITE);
		
		playername.setBounds(130, 50, 200, 30);
		
		JPanel moreinfo = new JPanel();
		moreinfo.setBackground(Color.decode("#212424"));
		moreinfo.setLayout(null);
		moreinfo.setBounds(518, 0, 300, 500);
		
		Button search = new Button("suchen");
		search.setBounds(0, 0, 100, 30);
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(Color.decode("#212424"));
		mainpanel.setBounds(0, 0, 500, 500);
		

			Button next = new Button("nächste Seite");
			next.setBounds(110, 0, 100, 30);
			next.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					page++;
					
				}
				
				
			});

	
			
				Auctiontracker track = new Auctiontracker();
				try {
					track.AuctionApi(page);
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}

				mainpanel.removeAll();
				
				JLabel bodyrender = new JLabel();
				bodyrender.setBounds(5, 5, 120, 111);
				
		System.out.println("start");
		for(int i = 0; i <= track.jsonstring().length(); i++) {
			
		//	if(i >= 1000) {
			//	break;
			//	}
			String itemname;
			String price;
			String binyn;
			String uuid;
			String bin;
			
			JSONObject hypixeljson = new JSONObject(track.jsonstring());
			itemname = hypixeljson.getJSONArray("auctions").getJSONObject(i).getString("item_name") + "";
			price = hypixeljson.getJSONArray("auctions").getJSONObject(i).getInt("starting_bid") + " Coins";
			binyn = hypixeljson.getJSONArray("auctions").getJSONObject(i).getBoolean("bin") + "";
			uuid = hypixeljson.getJSONArray("auctions").getJSONObject(i).getString("auctioneer") + "";

			
			if(Boolean.parseBoolean(binyn) == true) {
				bin = "Type: BIN";	
			} else {	
				bin = "Type: Auction";	
			}
			
			
			panelcount = i;
			
			JPanel ahpanel = new JPanel();
			ahpanel.setLayout(null);
			ahpanel.setBorder(new LineBorder(Color.decode("#1F51FF"), 5, true));
			ahpanel.setBackground(Color.BLACK);
			ahpanel.setPreferredSize(new Dimension(100, 150));
			
			JLabel itemlabel = new JLabel(itemname);
			itemlabel.setForeground(Color.WHITE);
			itemlabel.setBounds(5, 5, 200, 30);
			
			JLabel typelabel = new JLabel(bin + "");
			typelabel.setForeground(Color.WHITE);
			typelabel.setBounds(5, 45, 100, 30);

			
			JLabel pricelabel = new JLabel(price);
			pricelabel.setForeground(Color.WHITE);
			pricelabel.setBounds(5, 25, 100, 30);
			
			Map<String, JPanel> buttonMap = new HashMap<>();
			
			buttonMap.put(uuid, ahpanel);
			
			Map.Entry<String, JPanel> firstEntry = buttonMap.entrySet().iterator().next();

			ahpanel.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					
					moreinfo.setVisible(true);
					
					try {
						bodyrender.setIcon(new ImageIcon(new URL(Constants.skinrender + firstEntry.getKey())));
						
						track.AuctionMojang(firstEntry.getKey());
						
						JSONObject mojangjson = new JSONObject(track.playername);
						
						player = mojangjson.getString("name");
						
						playername.setText(player);
						
					} catch (IOException e1) {
					
						e1.printStackTrace();
					}
					
					moreinfo.add(bodyrender);
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					ahpanel.setBorder(new LineBorder(Color.CYAN, 5, true));
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					ahpanel.setBorder(new LineBorder(Color.decode("#1F51FF"), 5, true));
				}
				
				
			});
			
			ahpanel.removeAll();
			
			ahpanel.add(itemlabel);
			ahpanel.add(pricelabel);
			moreinfo.add(playername);
			ahpanel.add(typelabel);
			
			mainpanel.add(ahpanel);
			
			
			mainpanel.setLayout(new GridLayout(Math.round(i / 2), 1, 10, 10));
			
		
			
		}
		System.out.println("done");
		
		
		//headrender.setIcon(new ImageIcon(new URL("https://crafatar.com/renders/head/" + uuid + "?scale=64")));
		
		
		
		
		final JScrollPane scroll_1 = new JScrollPane(mainpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll_1.setBounds(0, 35, 500, 411);
		scroll_1.getVerticalScrollBar().setUnitIncrement(10);
		scroll_1.repaint();
		
		main.add(scroll_1);
		
	//	main.add(search);
		
		main.setSize(816, 499);
		main.setSize(817, 500);
		main.repaint();
		
		main.add(next);
		
		
				}
				
				
			});
			
		
			
			main.add(moreinfo);
			main.add(search);
		
	}
				
				

}
