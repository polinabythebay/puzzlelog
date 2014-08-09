
/*@author: Polina Soshnin
*@date: Aug 6 2014
*@purpose: Aspera Coding Challenge: New Grad SW
* 
*/

import java.util.*;
import java.io.*;

public class MinScalar {

	public void output(BufferedWriter out, int caseNum, String string) throws IOException{
		
		//writes out standard output format 
		out.write("Case #" + caseNum + ": " + string + "\n");	
		System.out.println("Case #" + caseNum + ":" + string + "\n");	
	}

	public void solve() throws IOException{
		Scanner in = new Scanner(new File("A-small-practice.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("A-small-practice.out"));
		Integer numCases= Integer.parseInt(in.nextLine());

		for (int i = 0; i < numCases; i++) {

			
			Integer size_vector= Integer.parseInt(in.nextLine());

			String[] v1_string = in.nextLine().split(" ");
			String[] v2_string = in.nextLine().split(" ");

			int[] v1 = new int[size_vector];
      
      		for (int j=0; j < size_vector; j++) {
        		v1[j] = Integer.parseInt(v1_string[j]);
      		}

      		int[] v2 = new int[size_vector];
      
      		for (int k=0; k < size_vector; k++) {
        		v2[k] = Integer.parseInt(v2_string[k]);
      		}

      		//step1: calculate all permutations of both arrays  

      		ArrayList<int[]> v1_perm = gen_permutations(v1);
      		ArrayList<int[]> v2_perm = gen_permutations(v2);

      		//test: print them out 
			//for (int[] s: v1_perm){
			//	for (int k: s){
			//		System.out.print(k);
			//	}
			//	System.out.println();
			//}
				
      		//step2: iterate through both arrays and generate (n!)^2
      		//possible answers
      		//return the smallest answer 

      		//System.out.println("Calculating min scalar product now...");

      		int size_queue = v1_perm.size()*v1_perm.size();
        	PriorityQueue<Integer> queue = new PriorityQueue<Integer>(size_queue);
			
      		for (int[] v1_array: v1_perm){

      			for (int[] v2_array: v2_perm){
      				int current_scalar_product = scalarProduct(v1_array, v2_array);
      				 queue.add(current_scalar_product);
      			}
      		}

      		int min_scalar_product = queue.remove();
        		//System.out.println("min scalar: "+min_scalar_product);
        	String result = Integer.toString(min_scalar_product);

			output(out, i+1, result);	
		}
		out.close();
	}

	/*
	*Given array of ints, generate all n! permutations of that array
	*/
	public static ArrayList<int[]> gen_permutations(int[] array){
		ArrayList<int[]> result = new ArrayList<int[]>();
		permutation(array, 0, result);
		return result;
	}
	public static void permutation(int[] array, int pos, ArrayList<int[]> list){
		if (array.length-pos == 1){
			list.add(array.clone());
		} else {
			for (int i=pos; i<array.length; i++){
				swap(array, pos, i);
				permutation(array, pos+1, list);
				swap(array, pos, i);
			}
		}
	}
	public static void swap(int[] array, int pos1, int pos2){
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}


	/*
	*Return scalar product of two int arrays 
	*/
	public static int scalarProduct(int[] v1, int[] v2){
		int result=0;
		for (int i=0; i<v1.length; i++){
			result=result+v1[i]*v2[i];
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		MinScalar n = new MinScalar();
		n.solve();
	}
}