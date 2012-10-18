package kaplan.anagram;

import java.io.FileNotFoundException;
import junit.framework.TestCase;

public class DictLoaderTest extends TestCase {
	public void testDictLoader() throws FileNotFoundException {
		DictionaryLoader dictLoader = new DictionaryLoader();
		assertTrue(dictLoader.contains("word"));
		assertFalse(dictLoader.contains("zzomfmfmf"));
	}
}
