package constants;

public interface Constants {
	
	// API Stuff
	
	public static String apikey = "?key=4a3b2d7c-9b74-4ed6-80a1-88d452cc4e13"; // API-Key
	
	// Links
	
	public static String hypixelurl = "https://api.hypixel.net/skyblock"; // URL for the Hypixel API connection
	public static String mojangurl = "https://api.mojang.com/users/profiles/minecraft/"; // URL for the Mojang API connection
	public static String mojangsessionserver = "https://sessionserver.mojang.com/session/minecraft/profile/"; // Retrieve the UUID of Players
	public static String skinrender = "https://crafatar.com/renders/head/"; // minecraft head render api
	
	// API Access types
	
	public static String profiles = "/profiles"; // SkyBlock profiles access token
	public static String bingo = "/bingo"; // SkyBlock bingo access token
	public static String firesales = "/firesales"; // SkyBlock firesales access token
	public static String auctions_active = "/auctions"; //SkyBlock active auctions access token

}
