package kaplan.anagram;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;



public class BinarySearchThread extends Thread {

	public void run(){
		DictionaryLoader dictLoader;
		try {
			dictLoader = new DictionaryLoader();
			Clock binaryClock = new Clock();
			for(int i = 0;i<400000;i++){
				Random random = new Random();
				String randomString = RandomStringUtils.randomAlphabetic(random.nextInt(5)+4).toLowerCase();
				//System.out.println(randomString);
				dictLoader.containsBinary(randomString);
			}
			System.out.println("Binary" + binaryClock.tick());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
}
