package kaplan.net;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Spyder {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException,
			IOException {

		LinkedBlockingQueue<String> linkList = new LinkedBlockingQueue<String>();
		
		File file = new File("tmp/");
		Repository rp = new Repository(file);
		rp.deleteCache();
		String url = new String("http://www.wikipedia.org");
		Webpage wp = new Webpage(url);
		rp.save(wp);
		System.out.println(rp.isCached(wp));
		WorkerThread wt = new WorkerThread(rp,linkList);
		WorkerThread wt2 = new WorkerThread(rp, linkList);
		WorkerThread wt3 = new WorkerThread(rp, linkList);
		for(String link: wt.getListOfLinks())
			linkList.add(link);
		
		
		wt.start();
		wt2.start();
		wt3.start();

	}

}
