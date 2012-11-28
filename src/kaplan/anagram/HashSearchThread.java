package kaplan.anagram;

import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class HashSearchThread extends Thread {
	public void run(){
		DictionaryLoader dictLoader;
		try {
			dictLoader = new DictionaryLoader();
			Clock hashClock = new Clock();
			Random random = new Random();
			for(int i = 0; i<100000;i++){
				
				String randomString = RandomStringUtils.randomAlphabetic(random.nextInt(5)+4).toLowerCase();
				//System.out.println(randomString);
				dictLoader.containsHash(randomString);
			}
			System.out.println("Hash" + hashClock.tick());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
}
}