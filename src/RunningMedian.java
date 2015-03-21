//RunningMedian.java

/**
*Keeps track of the median for a stream of numbers, updating
*the median for each new number. For a stream of numbers it uses
*count of words in the line for every line in the file.
*
*@author Sergey Kostenko
*@version 3/20/15
**/

import java.io.*;
import java.util.*;

class RunningMedian
{
	static final String INPUT = "../wc_input/";
	static final String OUTPUT = "../wc_output/med_result.txt";

	public static void main (String [] args)
	throws FileNotFoundException{

		File f = new File(INPUT);
		ArrayList<String> sortedListFiles = new ArrayList<String>();
		ArrayList<Double> numberOfWords = new ArrayList<Double>();
		PrintStream output = new PrintStream(new File(OUTPUT));
		double median;
		
		//sorting files in the folder
		for (File subF: f.listFiles())
			sortedListFiles.add(subF.getName());
		Collections.sort(sortedListFiles);
		
		for(int i = 0; i < sortedListFiles.size(); i++){
			Scanner content = new Scanner(new File(""+ INPUT +sortedListFiles.get(i)));
			while(content.hasNextLine()){
				Scanner currentLine = new Scanner(content.nextLine());
				double wordCount = 0.0;
				while(currentLine.hasNext()) {
					currentLine.next();
					wordCount++;
				}
				
				sortCount(wordCount, numberOfWords, 0, numberOfWords.size());
				
				median = findMedian(numberOfWords);
				
				output.println(median);		
			}
		}
	}

	/**
	*Binary placement of the key into the array in the sorted order. 
	*It is recutsive method.
	*
	*@param		double 		Key - element we need to place in the array
	*@param		ArrayList 	Array where we need to place our key
	*@param 	int 		Min - current beginning index of the array
	*@param 	int 		Max - current end index of the array
	**/
	private static void sortCount(double key, ArrayList<Double> array, int min, int max)
	{
		if(min > max) return;
		int midpoint = (min + max)/2;
		if(min == max) array.add(min, key);
		else if(array.get(midpoint) == key) array.add(midpoint, key);
		else if(array.get(midpoint) < key) sortCount(key, array, midpoint+1, max);
		else if(array.get(midpoint) > key) sortCount(key, array, min, midpoint);
	}

	/**
	*This method helps us to find median of the current array
	*
	*@param		ArrayList 	Array we are looking for median of
	*@return	double 
	**/
	private static double findMedian(ArrayList<Double> array)
	{
		if (array.size() == 1) return array.get(0);
		else if (array.size()%2 != 0) {
			int index = array.size()/2;
			return array.get(index);
		}
		else if (array.size()%2 == 0) {
			int index = array.size()/2;
			return (array.get(index) + array.get(index-1))/2;
		}
		return -1.0;
	}
}
