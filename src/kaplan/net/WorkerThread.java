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
	private WorkerThread wt;
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
			listOfLinks = wp.extractLinks();
			
			while ((linko = queue.take()) != null) {
				wp = new Webpage(linko);
				System.out.println(this.getId() + " " + linko);
				wp.setText();
				repo.save(wp);
			}
			for (String link : listOfLinks) {
				queue.add(link);
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
