package kaplan.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import org.apache.commons.io.IOUtils;

public class WorkerThread extends Thread {

	private Webpage wp;
	private Repository repo;
	public WorkerThread(Webpage wp, Repository repo){
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
		HttpURLConnection connection = null;
		connection = (HttpURLConnection) wp.getUrl().openConnection();
		InputStream in = connection.getInputStream();
		String html = IOUtils.toString(in);
		wp.setHtml(html);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
