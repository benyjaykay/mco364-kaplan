package kaplan.net;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class WebsiteDownloader {
public WebsiteDownloader(String website) throws IOException{
	URL url = new URL(website);
	HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	InputStream in  = connection.getInputStream();
	String webpage = IOUtils.toString(in);
	File file = new File(webpage);
	in.close();
}
}
