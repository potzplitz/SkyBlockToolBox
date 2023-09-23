package skyblocktracker;

public class FairySouls {
	
	public String fairysouls;
	
	public void DecodeFairySouls() {
		
		Skyblocktracker sbtrack = new Skyblocktracker();
		fairysouls = sbtrack.memberdatafinish.getInt("fairy_souls_collected") + "";
		
	}
	
	public String souls() {
		
		return fairysouls;
		
	}

}
