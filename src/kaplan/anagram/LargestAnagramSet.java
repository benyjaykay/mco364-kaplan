package kaplan.anagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class LargestAnagramSet {

	private Map<String, ArrayList<String>> anagramMap;

	LargestAnagramSet() throws IOException{
	anagramMap = new HashMap<String,ArrayList<String>>();
	File file = new File("word_list_moby_crossword_flat.txt");
	
		List<String> arrDictList = new ArrayList<String>(); 
		arrDictList = (ArrayList<String>) FileUtils.readLines(file);
		for(String word:arrDictList){
			char[] c1;
			c1 = word.toCharArray();
			Arrays.sort(c1);
		
			  String sortedWord = new String(c1);
			if(anagramMap.containsKey(sortedWord)){
				anagramMap.get(sortedWord).add(word);
			}
			else{
			anagramMap.put(sortedWord,new ArrayList<String>());
			anagramMap.get(sortedWord).add(word);
			}
		}
		List<String>valueList = new ArrayList<String>();
		int highestAnagramSize = 0;
		String highestAnagramName = "none";
		for (Entry<String, ArrayList<String>> entry : anagramMap.entrySet()) {
		    valueList = entry.getValue();
		    int anagramSize = valueList.size();
		    if(anagramSize > highestAnagramSize){
		    	highestAnagramSize = anagramSize;
		    	highestAnagramName = entry.getKey();
		    }
		}
		System.out.println(highestAnagramName);
		
		
}
}
