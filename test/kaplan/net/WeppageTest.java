package kaplan.net;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
public class WeppageTest extends TestCase {
	private Webpage wp;
	private ArrayList<String> listOfLinks;
public void testHtml() throws IOException{
	givenWebpage();
	whenSetHtml();
	thenExtractLinks();
}
public void givenWebpage(){
	wp  = new Webpage("http://www.touro.edu");
}
public void whenSetHtml() throws IOException{
	wp.setHtml();
}
public void thenExtractLinks() throws MalformedURLException{
	wp.setList();
	
	listOfLinks = wp.getList();
	int index = 0;
	for(String link :  listOfLinks){
		link = listOfLinks.get(index);
		System.out.println(link);
		index++;
	}
	assertEquals(wp.getList().get(0),"http://www.touro.edu/nav/current/textmenu.asp");
}


}
