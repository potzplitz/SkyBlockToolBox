package skyblocktracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DecodeTime {
	
	long firstjoin;
	int firstjoindecoded;
	
	String done;
	
	@SuppressWarnings("static-access")
	public void Time() {
		
		Skyblocktracker track = new Skyblocktracker();
		
		firstjoin = track.memberdatafinish.getLong("first_join");
		
		System.out.println(firstjoin);
		
		Date time = new Date (firstjoin);
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		date.setTimeZone(TimeZone.getDefault());
		
		done = date.format(time);
		
		System.out.println(done + "");
		
	}
	
	public String date() {
		
		return done;
		
	}

}
