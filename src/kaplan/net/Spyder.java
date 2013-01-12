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

		
		File file = new File("tmp/");
		Repository rp = new Repository(file);
		LinkedBlockingQueue<String> linkList = new LinkedBlockingQueue<String>();
		String url = "http://en.wikipedia.org/";
		linkList.add(url);
		WorkerThread wt = new WorkerThread(rp,linkList);
		WorkerThread wt2 = new WorkerThread(rp, linkList);
		WorkerThread wt3 = new WorkerThread(rp, linkList);
		
		
		
		wt.start();
		wt2.start();
		wt3.start();

	}

}
