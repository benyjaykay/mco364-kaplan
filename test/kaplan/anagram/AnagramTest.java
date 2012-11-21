package kaplan.anagram;
import junit.framework.TestCase;
public class AnagramTest extends TestCase{

	public void testIsAnagram(){
		assertTrue(anagram.isAnagram("race","acer"));
		assertFalse(anagram.isAnagram("bull", "ball"));
				
	}
}
