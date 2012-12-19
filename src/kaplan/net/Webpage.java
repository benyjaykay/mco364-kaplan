package kaplan.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class Webpage {
 private String html;
 private URL url;
 private String anchor;
 private String anchorUrl;
 private final Pattern anchorPattern = Pattern
			.compile("<a .*?href=\"(.*?)\"");
 private List<URL> linkList;
 public String getHtml(){
	 return html;
 }
 public void setHtml(String html){
	 	this.html = html;
 }
 public URL getUrl(){
	 return url;
 }
 public List<URL> extractLinks() throws MalformedURLException{
	 Matcher anchorMatcher = anchorPattern.matcher(html);
	 while (anchorMatcher.find()) {
			anchor = anchorMatcher.group(1);
			if(anchor.charAt(0)== '/')
			 anchorUrl = url + anchor;
			else
				anchorUrl = anchor;
			url = new URL(anchorUrl);
			linkList.add(url);
	 }
	 return linkList;
 }
public Pattern getAnchorPattern() {
	return anchorPattern;
}
}