package skyblocktracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import constants.Constants;





public class Skyblocktracker {
	
	public static String arrin;
	public static String mojangin;
	public static String coins;
	
	public static List<String> profilelist;
	
	public static String convertedcoins;
	 
	public static JSONObject memberdatafinish;
	public static JSONObject skyblockprofile;
	
	public static String uuid;
	
	public void skyblocktrackerapi(String name) throws IOException, JSONException {

		String linkmojang = Constants.mojangurl + name;

		
		URL apireqmojang = new URL(linkmojang);
		URLConnection conmojang = apireqmojang.openConnection();
		BufferedReader inmojang = new BufferedReader(new InputStreamReader(conmojang.getInputStream()));

		
		String inputLinemojang = inmojang.readLine();
		mojangin = "" + inputLinemojang + "";
		
		StringBuilder responseBuilder = new StringBuilder();
		String inputline;
		while ((inputline = inmojang.readLine()) != null) {
		    responseBuilder.append(inputline);
		}
		inmojang.close();
		
		String jsonResponse = "{" + responseBuilder.toString();

		
		JSONObject mojangjson = new JSONObject(jsonResponse.toString());
		
		
		
		
		
		uuid = mojangjson.getString("id");

		
		String link = Constants.hypixelurl + Constants.profiles + Constants.apikey + "&uuid=" + uuid;
		
		System.out.println(link);
		
		URL apireq = new URL(link);
		URLConnection con = apireq.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine = in.readLine();
		arrin = "" + inputLine + "";

		int i = 0;
		
		JSONObject hypixeljson = new JSONObject(arrin.toString());

		JSONArray profiles = hypixeljson.getJSONArray("profiles");
		
		
		profilelist = new ArrayList<String>();
		
		for(int i1 = 0; i1 <= profiles.length() - 1; i1++) {
			
			profilelist.add(profiles.getJSONObject(i1).getString("cute_name"));
		
		}
		
	}
	
	public void apiReader(int profile) {
		
		int i = profile;
		
		JSONObject hypixeljson = new JSONObject(arrin.toString());

		JSONArray profiles = hypixeljson.getJSONArray("profiles");
		
		 skyblockprofile = profiles.getJSONObject(i);
		memberdatafinish = skyblockprofile.getJSONObject("members").getJSONObject(uuid);
		

		
		
		
	}
	
	public String bankbalance() {
		
		return convertedcoins;
		
	}
	
	
	public List<String> profiles() {
		
		return profilelist;
			
	}
	
	public JSONObject returnApi() {
		
		return memberdatafinish;
	}

	public JSONObject returnSbProfile() {
		
		return skyblockprofile;
		
	}

}
