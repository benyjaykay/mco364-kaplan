package kaplan.anagram;
import java.util.Random;
import java.io.FileNotFoundException;

import org.apache.commons.lang3.RandomStringUtils;

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
		assertTrue(dictLoader.containsHash("word"));
		assertFalse(dictLoader.containsHash("zzomfmfmf"));
		assertTrue(dictLoader.containsHash("man"));
		assertFalse(dictLoader.contains("jdjdjdfjglgl"));
	}
	public void testThousandRandomSequentialMisses() throws FileNotFoundException{
		DictionaryLoader dictLoader = new DictionaryLoader(); 
		Clock sequentialClock = new Clock();
		Random random = new Random();
		for(int i = 0; i<1000;i++){
			String randomString = RandomStringUtils.randomAlphabetic(random.nextInt(5)+4);
			//System.out.println(randomString);
			assertFalse(dictLoader.contains(randomString));
		}
		System.out.println(sequentialClock.tick());
	}
	public void testMillionRandomBinaryMisses() throws FileNotFoundException{
		DictionaryLoader dictLoader = new DictionaryLoader();
		Clock binaryClock = new Clock();
		Random random = new Random();
		for(int i = 0;i<100;i++){
			String randomString = RandomStringUtils.randomAlphabetic(random.nextInt(5)+4).toLowerCase();
			//System.out.println(randomString);
			assertFalse(dictLoader.containsBinary(randomString));
		}
		System.out.println(binaryClock.tick());
	}
	public void testMillionRandomHashmapMisses()throws FileNotFoundException{
		DictionaryLoader dictLoader = new DictionaryLoader();
		Clock hashClock = new Clock();
		Random random = new Random();
		for(int i = 0;i<100;i++){
			String randomString = RandomStringUtils.randomAlphabetic(random.nextInt(5)+4).toLowerCase();
			//System.out.println(randomString);
			assertFalse(dictLoader.containsHash(randomString));
		}
		System.out.println(hashClock.tick());
	}
}
