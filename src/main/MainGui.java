package main;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import org.json.JSONException;

import skyblocktracker.Gui;
import skyblocktracker.Skyblocktracker;
import auctiontracker.gui.*;

public class MainGui {
	
	public static void main(String[] args) {
		
		JFrame main = new JFrame("Skyblock Toolbox");
		main.setSize(500, 500);
		main.setResizable(false);
		main.setLayout(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
		
		Button tracker = new Button("Skyblock Tracker");
		tracker.setBounds(100, 100, 100, 30);
		tracker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				Gui gui = new Gui();
				gui.SkyblockGui();
				
			}
			
			
		});
		
		Button auction = new Button("Auction Tracker");
		auction.setBounds(200, 100, 100, 30);
		auction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				AHGui gui = new AHGui();
				gui.AuctionGui();
				
			}
			
			
		});
		tracker.setVisible(true);
		
		main.add(tracker);
		main.add(auction);
		
	}

}
