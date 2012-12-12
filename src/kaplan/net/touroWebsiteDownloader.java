package kaplan.net;

import java.io.File;

public class touroWebsiteDownloader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("files");
		String[] files = file.list();
		for(String f:files){
			file = new File(f);
			file.delete();
		}
		WebsiteDownloader touro = new WebsiteDownloader("http://www.touro.edu");
		touro.start();
	}

}
