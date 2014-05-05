
/*@author: Polina Soshnin
*@date: May 4 2014
*@purpose: code jam template for java
* because I realized I was rewriting this i/o code 
* for every single problem
*/

import java.util.*;
import java.io.*;

public class Template {

	public void output(BufferedWriter out, int caseNum, String string) throws IOException{
		
		//writes out standard output format 
		out.write("Case #" + caseNum + ": " + string + "\n");	
		//System.out.println("Case #" + caseNum + ":" + string + "\n");	
	}

	public void solve() throws IOException{
		Scanner in = new Scanner(new File("A-small-practice.in"));
		//BufferedWriter out = new BufferedWriter(new FileWriter("A-small-practice.out"));
		Integer numCases= Integer.parseInt(in.nextLine());

		for (int i = 0; i < numCases; i++) {

			int c = in.nextInt();
			int numItems = in.nextInt();

			//handle customized input from here
			//write to output
			//output(out, caseNum, output string);	
		}
		//out.close();
	}

	public static void main(String[] args) throws IOException {
		Template n = new Template();
		n.solve();
	}
}