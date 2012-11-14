package kaplan.anagram;
import java.util.Random;
import java.io.FileNotFoundException;

import org.apache.commons.lang3.RandomStringUtils;

import junit.framework.TestCase;

public class DictLoaderTest extends TestCase {
	
	 private static int showRandomInteger(int aStart, int aEnd, Random aRandom){
		    if ( aStart > aEnd ) {
		      throw new IllegalArgumentException("Start cannot exceed End.");
		    }
		    //get the range, casting to long to avoid overflow problems
		    long range = (long)aEnd - (long)aStart + 1;
		    // compute a fraction of the range, 0 <= frac < range
		    long fraction = (long)(range * aRandom.nextDouble());
		    int randomNumber =  (int)(fraction + aStart);    
		    return randomNumber;
		  }
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
	public void testThousandRandomSequentialMisses() throws FileNotFoundException{
		DictionaryLoader dictLoader = new DictionaryLoader(); 
		Clock sequentialClock = new Clock();
		for(int i = 0; i<1000;i++){
			Random random = new Random();
			String randomString = RandomStringUtils.randomAlphabetic(showRandomInteger(4,8,random));
			//System.out.println(randomString);
			assertFalse(dictLoader.contains(randomString));
		}
		System.out.println(sequentialClock.tick());
	}
	public void testMillionRandomBinaryMisses() throws FileNotFoundException{
		DictionaryLoader dictLoader = new DictionaryLoader();
		Clock binaryClock = new Clock();
		for(int i = 0;i<1000000;i++){
			Random random = new Random();
			String randomString = RandomStringUtils.randomAlphabetic(showRandomInteger(4,8,random)).toLowerCase();
			//System.out.println(randomString);
			assertFalse(dictLoader.containsBinary(randomString));
		}
		System.out.println(binaryClock.tick());
	}
	public void testMillionRandomHashmapMisses()throws FileNotFoundException{
		DictionaryLoader dictLoader = new DictionaryLoader();
		Clock hashClock = new Clock();
		for(int i = 0;i<1000000;i++){
			Random random = new Random();
			String randomString = RandomStringUtils.randomAlphabetic(showRandomInteger(4,8,random)).toLowerCase();
			System.out.println(randomString);
			assertFalse(dictLoader.containsHash(randomString));
		}
		System.out.println(hashClock.tick());
	}
}
