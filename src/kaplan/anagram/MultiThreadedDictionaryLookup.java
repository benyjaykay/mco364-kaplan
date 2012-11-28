package kaplan.anagram;

import java.io.FileNotFoundException;


public class MultiThreadedDictionaryLookup {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		SequentialSearchThread sst = new SequentialSearchThread();
		System.out.println("About to start a thread");
		sst.start();
		System.out.println("I just started a thread");
		BinarySearchThread bst = new BinarySearchThread();
		System.out.println("About to start a second thread");
		bst.start();
		System.out.println("I just started a second thread");
		HashSearchThread hst = new HashSearchThread();
		System.out.println("About to start a third thread");
		hst.start();
		System.out.println("I just started a third thread");
}
}