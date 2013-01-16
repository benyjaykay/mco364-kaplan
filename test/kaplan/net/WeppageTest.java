package kaplan.net;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;

import junit.framework.TestCase;

public class WeppageTest extends TestCase {
	private Webpage wp;
	private ArrayList<String> listOfLinks;

	public void testHtml() throws IOException {
		givenWebpage();
		whenSetHtml();
		thenExtractLinks();
	}

	public void givenWebpage() {
		wp = new Webpage("http://www.touro.edu");
	}

	public void whenSetHtml() throws IOException {
		wp.setHtml();
	}

	public void thenExtractLinks() throws MalformedURLException {
		wp.setList();

		listOfLinks = wp.getList();
		int index = 0;
		for (String link : listOfLinks) {
			link = listOfLinks.get(index);
			System.out.println(link);
			index++;
		}
		assertEquals(wp.getList().get(0),
				"http://www.touro.edu/nav/current/textmenu.asp");
	}
	public void testGetText() throws IOException{
		givenHtmlPage();
		whenRemoveTags();
		thenNoHtml();
	}
	public void givenHtmlPage() throws IOException{
		String htmlPage = "<html><head><title>This is a webpage</title><body></body></head></html>";
		wp.setText(htmlPage);
	}
	public void whenRemoveTags() throws IOException{
		wp.removeTags();
	}
	public void thenNoHtml() throws IOException{
		String text = wp.getText();
		assertFalse(Pattern.matches("<.*?>",text));
	}
	@Before
	public void setUp() {
		wp = new Webpage("http://www.touro.edu");
	}

	@After
	public void tearDown() throws IOException {
		wp= null;
	}
	

}
