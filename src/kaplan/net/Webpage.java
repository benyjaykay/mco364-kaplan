package kaplan.net;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class Webpage {
	private String html;
	private String url;
	private String anchor;
	private String anchorUrl;
	private final Pattern anchorPattern = Pattern
			.compile("<a .*?href=\"(.*?)\"");
	private ArrayList<String> linkList;

	public Webpage(String url) {
		this.setUrl(url);
	}

	public String getHtml() {
		return html;
	}

	public void setHtml() throws IOException {
		URL url = null;
			url = new URL(getUrl());
			HttpURLConnection connection = null;
			connection = (HttpURLConnection) url.openConnection();
			InputStream in = connection.getInputStream();
			html = IOUtils.toString(in);
			in.close();
	}

	public void setUrl(String url){
	 this.url = url;
 }

	public String getUrl() {
		return url;
	}

	public ArrayList<String> extractLinks() throws MalformedURLException {
		Matcher anchorMatcher = anchorPattern.matcher(html);
		linkList = new ArrayList<String>();
		while (anchorMatcher.find()) {
			anchor = anchorMatcher.group(1);
			if (anchor.charAt(0) == '/')
				anchorUrl = url + anchor;
			else
				anchorUrl = anchor;
			
			linkList.add(anchorUrl);
		}
		return linkList;
	}

	public void setList() throws MalformedURLException{
		linkList = extractLinks();
	}
	public ArrayList<String> getList(){
		return linkList;
	}
	public Pattern getAnchorPattern() {
		return anchorPattern;
	}
}
