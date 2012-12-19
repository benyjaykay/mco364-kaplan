package kaplan.net;

import java.net.MalformedURLException;
import java.net.URL;

public class Spyder {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		Repository rp = new Repository();
		URL url = new URL("http://www.touro.edu");
		Webpage wp = new Webpage(url);
		WorkerThread wt = new WorkerThread(wp, rp);
		wt.start();
	}

}
