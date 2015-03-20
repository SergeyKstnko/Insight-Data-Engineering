//wordCount.java

/**
*This program reads content from all the files in the specified directory.
*Calculates amount of unique words and outputs the list of words and
*their count into the specified file.
*
*@author Sergii Kostenko
*@version 3/19/15
**/
import java.util.*;
import java.io.*;

class wordCount
{
	static final String PATH = "../wc_input";
	static final String OUTPUTFILE = "../wc_output/wc_result.txt";

	public static void main(String [] args)
		throws FileNotFoundException {
		
		File f = new File(PATH);
		PrintStream output = new PrintStream(new File(OUTPUTFILE));
		Hashtable<String, Integer> dictionary = new Hashtable<String, Integer>();

		for(File subF: f.listFiles()) {
			Scanner content = new Scanner(subF);

			while(content.hasNext()) {
				String word = content.next();
				word = word.toLowerCase();
				word = word.replaceAll("[\\[\\]'|?:!.,;'']*([a-z]+)[\\[\\]?':!.,;'']*", "$1");
				if(word.charAt(0) >= 'a' && word.charAt(0) <= 'z'){					
					if (dictionary.containsKey(word))
						dictionary.put(word, (dictionary.get(word)+1));
					else dictionary.put(word, 1);
				}
			}
		}
				
		//sorts the list of words in alphabetical order
		List<String> v = new ArrayList<String>(dictionary.keySet());
    	Collections.sort(v);
    	
    	//records words and their count into the file
    	for (String str : v)
    		output.printf("%-13s %s\n", str, dictionary.get(str));		
	}
}
