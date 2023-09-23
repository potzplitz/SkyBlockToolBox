package auctiontracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import constants.Constants;

public class Auctiontracker {
	
	public String arrin;
	public String playername;
	
	public void AuctionApi(int page) throws IOException {
		
		String link = Constants.hypixelurl + Constants.auctions_active + "?limit=50&page=" + page;
		
		URL apireq = new URL(link);
		URLConnection con = apireq.openConnection();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		arrin = "" + inputLine + "";
		
		System.out.println(arrin);
		
		System.out.println(link);
		
		
	}
	
	public void AuctionMojang(String uuid) throws IOException {
		
		String linkmojang = Constants.mojangsessionserver + uuid;

		
		URL apireq = new URL(linkmojang);
		URLConnection con = apireq.openConnection();
		
		System.out.println(con.getContentLength());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		playername = "" + inputLine + "";

		
		StringBuilder responseBuilder = new StringBuilder();
		String inputline;
		while ((inputline = in.readLine()) != null) {
		    responseBuilder.append(inputline);
		}
		in.close();
		
		String jsonResponse = "{" + responseBuilder.toString();
		
		playername = jsonResponse;
		
		System.out.println(playername);
		
		

		System.out.println(linkmojang);

		
	}
	
	public String jsonstring() {
		
		return arrin;
		
	}
	
	public String playername() {
		
		return playername;
		
	}

}
