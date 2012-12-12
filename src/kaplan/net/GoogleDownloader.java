package kaplan.net;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class GoogleDownloader {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	private static final Pattern anchorPattern = Pattern
			.compile("<a .*?href=\"(.*?)\"");

	public static void fileDownloader(String webpage)
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

	public static void main(String[] args) throws UnknownHostException,
			IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		/*
		 * final String requestString = "GET /index.html\n\n"; Socket s = new
		 * Socket("www.google.com",80); OutputStream out = s.getOutputStream();
		 * out.write(requestString.getBytes()); out.flush(); InputStream in =
		 * s.getInputStream(); String webpage = IOUtils.toString(in); s.close();
		 * System.out.println(webpage);
		 */
		URL url = new URL("http://www.touro.edu");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = connection.getInputStream();
		String webpage = IOUtils.toString(in);
		in.close();
		System.out.println(webpage);
		Matcher anchorMatcher = anchorPattern.matcher(webpage);
		String anchor;
		WebsiteDownloader wd;
		while (anchorMatcher.find()) {
			System.out.println(anchorMatcher.group());
			anchor = anchorMatcher.group(1);
			String anchorUrl = "http://www.touro.edu/" + anchor;
			wd = new WebsiteDownloader(anchorUrl);
			wd.start();
		}
	}

}
