/*@author: Polina Soshnin
*@email: psoshnin@wellesley.edu
*@purpose: generate the powerset of the string: that is, the 
* set of all subsets. For n elts, powerset contains 2^n elts
*/
import java.util.*;
import java.io.*;


public class PowerSet {

	public void output(BufferedWriter out, int caseNum, String string) throws IOException{
	//writes out standard output format
	out.write("Case #" + caseNum + ": " + string + "\n");	
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