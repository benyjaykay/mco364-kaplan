package kaplan.net;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class WorkerThread extends Thread {

	private Webpage wp;
	private Repository repo;
	private ArrayList<String> listOfLinks;
	private WorkerThread wt;

	public WorkerThread(Webpage wp, Repository repo) {
		this.setWp(wp);
		this.setRepo(repo);
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
		try {
			wp.setHtml();
			repo.save(wp);
			listOfLinks = wp.extractLinks();

			for (String link : listOfLinks) {
				wp = new Webpage(link);
				wt = new WorkerThread(wp, repo);
				wt.start();
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
