package kaplan.net;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Repository {
	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isCached(String url) {
		file = new File(url);
		return file.exists();
	}

	public void save(Webpage webpage) throws IOException, NoSuchAlgorithmException{
	byte[] bytesOfMessage = webpage.getHtml().getBytes("UTF-8");
	MessageDigest md = MessageDigest.getInstance("MD5");
	byte[] thedigest = md.digest(bytesOfMessage);
	BigInteger bigInt = new BigInteger(1, thedigest);
	String filer = bigInt.toString(16);
	 file = new File("files//"
			+ filer + ".txt");
	BufferedWriter out = new BufferedWriter(new FileWriter("files//"
			+ filer + ".txt"));
	out.write(webpage.getHtml());
	out.close();
}
	public void deleteCache() {
		String[] files = file.list();
		for (String f : files) {
			file = new File(f);
			file.delete();
		}
	}
}
