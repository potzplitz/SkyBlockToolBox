package skyblocktracker;

public class Chop64 {
	
	public void chop(String input) {
		
		DecodeBase64 decoder = new DecodeBase64(); 
		
		decoder.decode64(input);
		
		for(int i = 0; i <= 3; i++) {
			
			String cut = decoder.finaloutput;
			
			int index = cut.indexOf("Name");
			
			String result = cut.substring(index + "Name".length());
			
			int furtherindex = result.indexOf("ExtraAttributes");
			
			String more = result;
			
			String end = result.substring(0,furtherindex);
			
			
			
	        System.out.println(end.trim());
	        
	        cut = result;
			
		}
		
		
		
	}
	

}
