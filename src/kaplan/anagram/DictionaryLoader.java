package kaplan.anagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class DictionaryLoader {
	private List<String> arrDictList = new ArrayList<String>();
	private Object[] arrDictArray;
	private File file;
	public DictionaryLoader() throws FileNotFoundException {
	 file = new File("word_list_moby_crossword_flat.txt");
		try {
			arrDictList = FileUtils.readLines(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arrDictArray = new String[arrDictList.size()];
		arrDictArray = arrDictList.toArray();
	}

	public boolean contains(String word) {
		return arrDictList.contains(word);
	}
	public boolean containsBinary(String word){
		 if(Arrays.binarySearch(arrDictArray, word)>=0)
			 return true;
		 else
			 return false;
	}
	public boolean containsHash(String word){
		HashMap<String, String> hm = new HashMap(); 
		// Put elements to the map 
		hm.putAll((Map<String, String>) arrDictList);
		if(hm.containsValue(word))return true;
		return false;
	}
	
}
