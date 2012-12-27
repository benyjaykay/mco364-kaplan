package kaplan.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.FileUtils;

public class Repository {
	private File file;
	private File directory;

	public Repository(File directory) {
		this.directory = directory;
		directory.mkdirs();
	}

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isCached(Webpage webpage)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		byte[] bytesOfMessage = webpage.getUrl().getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		BigInteger bigInt = new BigInteger(1, thedigest);
		String filer = bigInt.toString(16);
		System.out.println(filer);
		setFile(new File(getDirectory() + "/" + filer + ".txt"));
		return file.exists();
	}

	public void save(Webpage webpage) throws IOException,
			NoSuchAlgorithmException {
		byte[] bytesOfMessage = webpage.getUrl().getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		BigInteger bigInt = new BigInteger(1, thedigest);
		String filer = bigInt.toString(16);
		setFile(new File(getDirectory() + "/" + filer + ".txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter(getFile()));
		webpage.setHtml();
		out.write(webpage.getHtml());
		out.close();
	}

	public void deleteCache() throws IOException {
		FileUtils.deleteDirectory(getDirectory());
	}

	public File retrieve(Webpage webpage) throws NoSuchAlgorithmException,
			IOException {
		byte[] bytesOfMessage = webpage.getUrl().getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		BigInteger bigInt = new BigInteger(1, thedigest);
		String filer = bigInt.toString(16);
		String path = getDirectory() + "/" + filer + ".txt";
		BufferedReader in = new BufferedReader(new FileReader(path));
		String line = null;
		while ((line = in.readLine()) != null) {
			// process each line in some way
			System.out.println(line);
		}
		in.close();
		setFile(new File(getDirectory() + "/" + filer + ".txt"));
		return getFile();
	}
}