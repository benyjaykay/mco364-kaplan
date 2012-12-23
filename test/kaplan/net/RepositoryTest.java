package kaplan.net;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import junit.framework.TestCase;
public class RepositoryTest extends TestCase {
	private Repository rp;
	private File file;
	private String url;
	public void testSave() throws NoSuchAlgorithmException, IOException{
		givenRepo();
		whenSave();
		thenFileExists();
	}
	public void givenRepo(){
		 file = new File("C:\\Users\\Benyjaykay\\Documents\\Filing\\\\");
		rp = new Repository(file);
	}
	public void whenSave() throws NoSuchAlgorithmException, IOException{
		url = new String("http://www.touro.edu");
		Webpage wp = new Webpage(url);
		rp.save(wp);
	}
	public void thenFileExists(){
		file = new File(rp.getDirectory() + "d29238a17e5594f5e7e8c76faadb8923.txt");
		assertTrue(file.exists());
	}
	public void testIsCached() throws NoSuchAlgorithmException, IOException{
		givenUrl();
		thenUrlFileExists();
	}
	public void givenUrl(){
		url = new String("http://www.touro.edu");
		
	}
	public void thenUrlFileExists() throws UnsupportedEncodingException, NoSuchAlgorithmException, IOException{
		
		url = new String("http://www.touro.edu/");
		System.out.println(rp.isCached(url));
		rp.isCached(url);
		
	}
	public void testDeleteCache() throws UnsupportedEncodingException, NoSuchAlgorithmException{
		whenDeleteCache();
		thenFileDoesntExist();
	}
	public void whenDeleteCache(){
		rp.deleteCache();
	}
	public void thenFileDoesntExist() throws UnsupportedEncodingException, NoSuchAlgorithmException{
		assertFalse(rp.isCached(url));
	}
}
