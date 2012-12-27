package kaplan.net;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Spyder {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException,
			IOException {

		File file = new File("C:\\Users\\Benyjaykay\\Documents\\filing\\ \\");
		Repository rp = new Repository(file);
		rp.deleteCache();
		String url = new String("http://www.touro.edu");
		Webpage wp = new Webpage(url);
		rp.save(wp);
		System.out.println(rp.isCached(wp));
		WorkerThread wt = new WorkerThread(wp, rp);
		wt.start();

	}

}
