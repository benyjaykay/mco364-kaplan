package kaplan.net;

public class touroWebsiteDownloader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebsiteDownloader touro = new WebsiteDownloader("http://www.touro.edu");
		touro.start();
	}

}
