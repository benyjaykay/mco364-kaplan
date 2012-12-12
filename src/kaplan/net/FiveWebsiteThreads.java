package kaplan.net;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FiveWebsiteThreads {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 WebsiteDownloader yahoo = new WebsiteDownloader("http://www.yahoo.com");
 yahoo.start();
 WebsiteDownloader bing = new WebsiteDownloader("http://www.bing.com");
 bing.start();
 WebsiteDownloader google = new WebsiteDownloader("http://www.google.com");
 google.start();
 

	}

}
