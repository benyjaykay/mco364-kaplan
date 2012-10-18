package kaplan.anagram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class DictionaryLoader {
	private Scanner sc;
	private ArrayList<String> arrDictList;
	private String arrDictArray[];
	public DictionaryLoader() throws FileNotFoundException {
		sc = new Scanner(new File("word_list_moby_crossword_flat.txt"));
		arrDictList = new ArrayList<String>();
		IOUtils.readLines(input);
		while (sc.hasNext()) {
			arrDictList.add(sc.next());
		}
		arrDictArray = new String[arrDictList.size()];
		arrDictArray = (String[]) arrDictList.toArray();
	}

	public boolean contains(String word) {
		return arrDictList.contains(word);
	}
	public boolean containsBinary(String word){
		return Arrays.binarySearch(arrDictArray, key);
	}
}
