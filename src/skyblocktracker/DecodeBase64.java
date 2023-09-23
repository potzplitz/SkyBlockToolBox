package skyblocktracker;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

@SuppressWarnings("unused")
public class DecodeBase64 {
	
	public  String finaloutput;
	
	public String decode64(String encoded64) {
		
		String data = encoded64;
		
		byte[] decodedBytes = Base64.getDecoder().decode(data);
		
		String jsonString = new String(decodedBytes, StandardCharsets.UTF_8);
		
		
		ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedBytes);
        try {
			GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = gzipInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        byte[] decompressedBytes = outputStream.toByteArray();

        // Entpackte Daten als String ausgeben
        String decompressedString = new String(decompressedBytes, "UTF-8");
        
        finaloutput = decompressedString;
        
        // Ressourcen schlieﬂen
        gzipInputStream.close();
        outputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
        return finaloutput;
		

}

}