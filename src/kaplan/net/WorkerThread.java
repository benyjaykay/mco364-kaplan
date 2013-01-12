package kaplan.net;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkerThread extends Thread {

	private Webpage wp;
	private Repository repo;
	private ArrayList<String> listOfLinks;
	private LinkedBlockingQueue<String> queue;

	public WorkerThread(Repository rp, LinkedBlockingQueue<String> linkList) {
		this.setQueue(linkList);
		setRepo(rp);
	}

	
	public void setQueue(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public Queue<String> getQueue() {
		return queue;
	}

	public ArrayList<String> getListOfLinks() {
		return listOfLinks;
	}

	public Repository getRepo() {
		return repo;
	}

	public void setRepo(Repository repo) {
		this.repo = repo;
	}

	public Webpage getWp() {
		return wp;
	}

	public void setWp(Webpage wp) {
		this.wp = wp;
	}

	public void run() {
		String linko;
		try {

			
			while ((linko = queue.take()) != null) {
				wp = new Webpage(linko);
				wp.setHtml();
				System.out.println(this.getId() + " " + linko);
				listOfLinks = wp.extractLinks();
				for (String link : listOfLinks) {
					if(!queue.contains(link))
							queue.add(link);
				}
				wp.removeTags();
				repo.save(wp);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
