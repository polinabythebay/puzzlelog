
/*@author: Polina Soshnin
*@date: May 4 2014
*@purpose: code jam pratice, africa 2010 qualifier
*/

import java.util.*;
import java.io.*;

public class ReverseWords {

	public void output(BufferedWriter out, int caseNum, String string) throws IOException{
		
		//writes out standard output format 
		out.write("Case #" + caseNum + ":" + string + "\n");
		System.out.println("Case #" + caseNum + ":" + string + "\n");		
	}

	public void solve() throws IOException{
		Scanner in = new Scanner(new File("B-large-practice.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("B-large-practice.out"));
		
		Integer numCases= Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < numCases; i++) {

			
			String[] words = in.nextLine().split(" ");
			
			//reverse order in array
			for (int z=0; z<words.length/2; z++){
				String temp_word = words[z];
				int swap_index = words.length-1-z;
				words[z] = words[swap_index];
				words[swap_index] = temp_word;
			}

			String result ="";
			for (int j=0; j<words.length; j++){
				result = result+" "+words[j];
			}

			//write to output
			output(out, i+1, result);	
		}
		out.close();
	}

	public static void main(String[] args) throws IOException {
		ReverseWords n = new ReverseWords();
		n.solve();
	}
}
