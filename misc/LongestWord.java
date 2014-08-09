
/*
@author: Polina Soshnin
*@email: psoshnin@wellesley.edu
*@purpose: reads in list of words, outputs first and second longest words
* that can be composed of words in the list 
*/

import java.util.*;
import java.io.*;

public class LongestWord {

	public void solve() throws IOException{

		Scanner in = new Scanner(new File("wordsforproblem.txt"));
		Scanner scan = new Scanner(new File("wordsforproblem.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("solution.txt"));
		Set<String> set = new HashSet<String>();
		Integer totalWords = 0;
		TreeMap<Integer, LinkedList <String>> words = 
										new TreeMap(Collections.reverseOrder());

		//reads file containing sorted list of words and adds
		//them to a set for constant lookup
		while(in.hasNext()){
			set.add(in.nextLine());		
		}
		
		//iterates through sorted list of words and identifies
		//how many words can made from other words in the list

		while(scan.hasNext()){
			
			String word = scan.nextLine();

			//determines how many words can be made from other words in list
			Integer numWords = hasWords(word, set);
			
			//adds words that contain 2 or more words as key value pairs 
			//to track longest containing words
			if (numWords > 1){

				//tracks total count of how many words can be constructed
				//from other words
				totalWords++;
				if (words.containsKey(word.length())){
					words.get(word.length()).add(word);
				} else {
				LinkedList<String> wordList = new LinkedList();
				words.put(word.length(), wordList);
				words.get(word.length()).add(word);
				}
			}
		}

		String longestWord = "";
		String secondLongest = "";

		//outputs 1st, 2ndlongest word in file that can be constructed from
		//other words in the list 

		if (words.get(words.firstKey()).size() > 1){
			longestWord = words.get(words.firstKey()).removeFirst();
			secondLongest = words.get(words.firstKey()).removeFirst();
			} else {
			longestWord = words.get(words.firstKey()).removeFirst();
			words.remove(words.firstKey());
			secondLongest = words.get(words.firstKey()).removeFirst();
		}
		
		output(out, longestWord, secondLongest, totalWords);
		out.close();
	}

	/**
	* Returns the number of words contained within a given word, if the
	* the word can be constructed from other words in the list. Assumes
	* all words at 2 or more letters.
	*
	* @param  word  	a word in the list
	* @param  set 		entire list of words
	* @return integer  	1 or 0 if word does not contain other words
	*					2+n if word contains 2 or more words   
	*/

	public Integer hasWords(String word, Set<String> set){
		Integer counter = 0;
		
		//cannot have 2 or more words
		if (word.length() <= 3 ){
			return counter;
		}

		String subWord = word;
		boolean foundWord = false;

		while (!subWord.equals("")){ 
			
			for(int i = 0; i < word.length(); i++){
				
				//If every letter except the last 
				//letter of the word cannot be constructed 
				//into another word
				if (word.length()==1){
					subWord= "";
					counter= 0;
					break;
				} else {
					//start with first two letters of word
					subWord = word.substring(0,2+i);
				}

				//If it is the first word found
				if (set.contains(subWord) && (foundWord == false)){
					foundWord = true;
				}

				//If the next letter of the first word found does not 
				//make it another complete word then an entire word 
				//has been found
				if (!(set.contains(subWord)) && (foundWord == true)){
					word = word.substring(i+1, word.length());
					subWord = subWord.substring(0,subWord.length()-1);
					foundWord = false;
					counter++;
					break;
				}

				//If the remaining part of the word does not make a complete word
				if (!(set.contains(subWord)) && (subWord.length() == word.length())){
					subWord = "";
					counter = 0;
					break;
				}

				//If the remaining part of the word is the entire word 	
				if (subWord.equals(word)) {
					subWord = "";
					counter++;
					break;
				}
			}
		}
		return counter;
	}


	/**
	* Writes to output containing highest word, second highest word, and total
	*
	* @param  out  			BufferedWriter
	* @param  longestWord 	Highest word that can be concatenated from list
	* @param  nextLongest  	Second highest word that can be concatenated from list
	* @param  total 		Total number of words that can be constructed from 
	*						other words				  
	*/

	public void output(BufferedWriter out, String longestWord, String nextLongest,
					 Integer total) throws IOException{
		
		 out.write("Longest Word: " + longestWord + "\n" + "Next Longest Word: " + 
		 	nextLongest + "\n" + "Total words: " + total);		
	}

	public static void main(String[] args) throws IOException {
		LongestWord n = new LongestWord();
		n.solve();
	}


}