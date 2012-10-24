package kaplan.anagram;

import java.io.FileNotFoundException;
import junit.framework.TestCase;

public class DictLoaderTest extends TestCase {
	public void testSequentialDictSearch() throws FileNotFoundException {
		DictionaryLoader dictLoader = new DictionaryLoader();
		assertTrue(dictLoader.contains("word"));
		assertFalse(dictLoader.contains("zzomfmfmf"));
	}
	public void testBinaryDictSearch()throws FileNotFoundException{
		DictionaryLoader dictLoader = new DictionaryLoader();
		assertTrue(dictLoader.containsBinary("word"));
		assertFalse(dictLoader.containsBinary("zzomfmfmf"));
	}
	public void testHashMapSearch() throws FileNotFoundException{
		DictionaryLoader dictLoader = new DictionaryLoader();
		assertTrue(dictLoader.containsBinary("word"));
		assertFalse(dictLoader.containsBinary("zzomfmfmf"));
	}
}
