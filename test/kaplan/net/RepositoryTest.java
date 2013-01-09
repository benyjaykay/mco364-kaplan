package kaplan.net;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import junit.framework.TestCase;

public class RepositoryTest extends TestCase {
	private Repository rp;
	private File file;
	private String url;
	private Webpage wp;

	public void testSave() throws NoSuchAlgorithmException, IOException {
		givenRepo();
		thenFileExists();
		whenSave();
		thenFileExists();
	}

	public void givenRepo() {
		file = new File("tmp/");
		rp = new Repository(file);
	}

	public void whenSave() throws NoSuchAlgorithmException, IOException {
		url = new String("http://www.touro.edu");
		wp = new Webpage(url);
		rp.save(wp);
	}

	public void thenFileExists() {
		file = new File(rp.getDirectory() + "/"
				+ "d29238a17e5594f5e7e8c76faadb8923.txt");
		assertTrue(file.exists());
	}

	public void testIsCached() throws NoSuchAlgorithmException, IOException {
		givenRepo();
		givenUrl();
		thenUrlFileExists();
	}

	public void givenUrl() {
		url = new String("http://www.touro.edu");
	}

	public void thenUrlFileExists() throws UnsupportedEncodingException,
			NoSuchAlgorithmException, IOException {
		wp = new Webpage("http://www.touro.edu");
		assertTrue(rp.isCached(wp));
	}

	public void testRetrieve() throws NoSuchAlgorithmException, IOException {
		givenRepo();
		givenWebpage();
		whenRetrieved();
		thenFileEquals();
	}

	public void givenWebpage() {
		wp = new Webpage("http://www.touro.edu");
	}

	public void whenRetrieved() throws NoSuchAlgorithmException, IOException {
		file = rp.retrieve(wp);
	}

	public void thenFileEquals() {
		assertEquals(file.getName(), "d29238a17e5594f5e7e8c76faadb8923.txt");
	}

	public void testDeleteCache() throws NoSuchAlgorithmException, IOException {
		givenRepo();
		givenWebpage();
		whenDeleteCache();
		thenFileDoesntExist();
	}

	public void whenDeleteCache() throws IOException {
		assertTrue(rp.getDirectory().exists());
		rp.deleteCache();
	}

	public void thenFileDoesntExist() throws UnsupportedEncodingException,
			NoSuchAlgorithmException {
		assertFalse(rp.getDirectory().exists());
	}
	@Before
	public void setUp(){
		file = new File("tmp/");
		rp = new Repository(file);
	}
	@After
	public void tearDown() throws IOException{
		rp.deleteCache();
	}

}
