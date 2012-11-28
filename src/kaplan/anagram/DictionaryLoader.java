package kaplan.anagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import org.apache.commons.io.FileUtils;

public class DictionaryLoader {
	private List<String> arrDictList = new ArrayList<String>();
	private Object[] arrDictArray;
	private File file;
	private HashMap<String, String> hm = new HashMap<String, String>();
	public DictionaryLoader() throws FileNotFoundException {
	 file = new File("word_list_moby_crossword_flat.txt");
		try {
			arrDictList = FileUtils.readLines(file);
			arrDictArray = new String[arrDictList.size()];
			arrDictArray = arrDictList.toArray();
			 
			// Put elements to the map 
			for(String word: arrDictList){
			hm.put(word, word);
		}} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		if(hm.containsKey(word))return true;
		return false;
	}
	
}
