package kaplan.anagram;

import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class SequentialSearchThread extends Thread {

	/**
	 * @param args
	 */
	public void run(){
		DictionaryLoader dictLoader;
		try {
			dictLoader = new DictionaryLoader();
			Clock sequentialClock = new Clock();
			Random random = new Random();
			for(int i = 0; i<10000;i++){
				
				String randomString = RandomStringUtils.randomAlphabetic(random.nextInt(5)+4);
				//System.out.println(randomString);
				dictLoader.contains(randomString.toLowerCase());
			}
			System.out.println("Sequential " + sequentialClock.tick());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	}

