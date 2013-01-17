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
		linkList.clear();
		String url = "http://en.wikipedia.org/wiki/Lionel_Messi";
		linkList.add(url);
		WorkerThread wt;
		for(int i = 0; i <20;i++){
		 wt = new WorkerThread(rp,linkList);
		 wt.start();

	}
	}
}
