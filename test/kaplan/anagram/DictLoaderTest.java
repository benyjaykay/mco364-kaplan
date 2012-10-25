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
	public void testThousandRandomSequentialHits() throws FileNotFoundException{
		DictionaryLoader dictLoader = new DictionaryLoader(); 
		for(int i = 0; i<1000;i++){
			Random random = new Random();
			String randomString = RandomStringUtils.randomAlphabetic(showRandomInteger(4,8,random));
			System.out.println(randomString);
			System.out.println(dictLoader.contains(randomString));
		}
	}
}
