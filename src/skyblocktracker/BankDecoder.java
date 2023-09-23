package skyblocktracker;

import org.json.JSONException;

public class BankDecoder {

	public String convertedcoins;
	public String coins;
	
	public String purse;
	
	public String returnpurse;
	
	public String error;
	
	@SuppressWarnings("static-access")
	public void Bank() {
		
		boolean err = false;
		
		Skyblocktracker sbtrack = new Skyblocktracker();
	
		try {
			
		coins = sbtrack.skyblockprofile.getJSONObject("banking").optString("balance");
		
		} catch (JSONException e) {
			
			error = "Banking API nicht Aktiviert!";
			
			err = true;
		}
		
		if(err == false) {

		String suffix = "";
		
		float coinsnumber = Float.parseFloat(coins);
		
		int roundedcoins = Math.round(coinsnumber);
		
		double convertedNumber = roundedcoins;
		
		if (roundedcoins >= 1_000_000_000) {
	        convertedNumber = roundedcoins / 1_000_000_000.0;
	        suffix = "B";
	    } else if (roundedcoins >= 1_000_000) {
	        convertedNumber = roundedcoins / 1_000_000.0;
	        suffix = "M";
	    } else if (roundedcoins >= 1_000) {
	        convertedNumber = roundedcoins / 1_000.0;
	        suffix = "K";
	    }
		
		convertedcoins = convertedNumber + "";
		
		char separator = '.';
		
		int separatorindex = convertedcoins.indexOf(separator);
		
		String extractedString = convertedcoins.substring(0, separatorindex + 2);

		convertedcoins = extractedString  + suffix;
		}
		
		if(err == true) {
			
			convertedcoins = error; 
			
		}
		
		err = false;
		
		String index = "";
		
		purse = Math.floor(sbtrack.memberdatafinish.getFloat("coin_purse")) + "";
		
		float val = Float.parseFloat(purse);
		
		if(val >= 1_000_000_000) {
			
			val = val / 1_000_000_000;
			index = "B";
			
		 } else if (val >= 1_000_000) {
			 
	        val = val / 1_000_000;
	        index = "M";
	        
	    } else if (val >= 1_000) {
	        val = val / 1_000;
	        index = "K";
	    }
		
		String purseString = val + "";
		
		char separator = '.';
		
		int separatorindex = purseString.indexOf(separator);
		
		String extractedString = purseString.substring(0, separatorindex + 2);
		
		System.out.println(extractedString + index);
		
		returnpurse = extractedString  + index;
		
		
	}
	
	public String returnBank() {
		
		return convertedcoins;
		
	}
	
	public String returnPurse() {
		
		return returnpurse;
		
	}
	
}
