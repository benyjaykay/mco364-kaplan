package kaplan.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class Webpage {
	private String html;
	private String text;
	private String url;
	private String anchor;
	private String anchorUrl;
	private final Pattern anchorPattern = Pattern
			.compile("<a .*?href=\"(.*?)\"");
	private final Pattern javaScriptPattern = Pattern.compile("^(<script .*?>).*(</script>)?");
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

	public void setUrl(String url) {
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
			if (anchor.charAt(0) == '/'){
				anchorUrl = url + anchor;
				linkList.add(anchorUrl);
			}
			else if(anchor.startsWith("http://www.touro.edu")){
				anchorUrl = anchor;
				linkList.add(anchorUrl);
			}
			else if(anchor.startsWith("http://touro.edu")){
				anchorUrl = anchor;
				linkList.add(anchorUrl);
			}
			else
			continue;
		}
		return linkList;
	}

	public void setList() throws MalformedURLException {
		linkList = extractLinks();
	}

	public ArrayList<String> getList() {
		return linkList;
	}

	public Pattern getAnchorPattern() {
		return anchorPattern;
	}
	public void setText() throws IOException{
		setHtml();
		
		text = getHtml().replaceAll("\\<.*?>","");
	}
	public String getText() throws IOException{
		setText();
		return text;
	}
	
	
	
}
