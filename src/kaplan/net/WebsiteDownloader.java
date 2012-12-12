package kaplan.net;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class WebsiteDownloader extends Thread {
	private String website;
	private final Pattern anchorPattern = Pattern
			.compile("<a .*?href=\"(.*?)\"");
	public WebsiteDownloader(String website) {
		this.website = website;
	}
	public void fileDownloader(String webpage)
			throws NoSuchAlgorithmException, IOException {
		byte[] bytesOfMessage = webpage.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		BigInteger bigInt = new BigInteger(1, thedigest);
		String filer = bigInt.toString(16);
		BufferedWriter out = new BufferedWriter(new FileWriter("files//"
				+ filer + ".txt"));
		out.write(webpage);
		out.close();
	}

	public void run() {
		URL url = null;
		try {
			url = new URL(website);
			HttpURLConnection connection = null;
			connection = (HttpURLConnection) url.openConnection();
			InputStream in = connection.getInputStream();
			String webpage = IOUtils.toString(in);
			fileDownloader(webpage);
			in.close();
			
			Matcher anchorMatcher = anchorPattern.matcher(webpage);
			String anchor;
			WebsiteDownloader wd;
			while (anchorMatcher.find()) {
				anchor = anchorMatcher.group(1);
				String anchorUrl = website + anchor;
				wd = new WebsiteDownloader(anchorUrl);
				wd.start();
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
