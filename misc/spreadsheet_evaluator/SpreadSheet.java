
/*
 * @author:Polina Soshnin
 * @email: psoshnin@wellesley.edu
 * @purpose: console spreadsheet evaluator
 * See README for details
 * 
*/

import java.util.*;
import java.io.*;
import au.com.bytecode.opencsv.CSVReader;

public class SpreadSheet {

	//key = cell reference (Ai....Zi)
	//value = CSV input
	HashMap<String, String> sheet = new HashMap<String, String>();

	/*
	*Reads in standard CSV (no variable character delimiters) and outputs
	*evaluated CSV to STDOUT
	*
	* @param strFileName 	Input CSV file, cannot be more than 26 cols across
	*						and 1000000 rows long. Rows can be variable length. 
	*/
	public void solve(String strFileName){
		readCSV(strFileName);
		writeSTDOUT();
	}

	/*
	*Reads in CSV and assigns its values to keys of the following form:
	* A1..Z1
	* A2..Z2 etc.
	* 
	* @param strFileName	Input CSV file
	*/

	public void readCSV(String strFileName) {
		try {
			CSVReader reader = new CSVReader(new FileReader(strFileName));
			List<String[]> csvEntries = reader.readAll();
			Iterator<String[]> Iter = csvEntries.iterator();

			Integer current_row = 1;

			while ( Iter.hasNext()) {
				String [] strArray = Iter.next();
				char letter = 'A';
				 
				for (int i=0; i < strArray.length; i++){
					String index = Integer.toString(current_row);
					String key = letter+index;
					sheet.put(key, strArray[i]);
					letter++;
				}
				current_row++;
			}
		reader.close();
		}
		catch ( FileNotFoundException fnfe ) {
			System.err.println("File Not Found Exception");
		} 
		catch ( IOException ioe ) {
			System.err.println("IO Exception");
		}
	}

	/*
 	*Evaluates a cell of the input CSV for one of three
 	*cases:
 	*Basic File Parsing: returns cell if it's a number
 	*Single Operation Arithmetic: returns result of calculation
 	*Single Cell Reference: returns the referenced cell
 	* 
 	* @param 	str 	cell to evaluate
 	* @return 	String 	evaluated cell
	*/

	public String evaluate(String str){
		
		String result = str;
		String[] eval = result.split("\\s");

		if (eval.length ==1){	
			
			//If cell reference with multi cell referencing
			if (eval[0].charAt(0) == '='){

				String key = eval[0].substring(1);
				result = evalCellRef(key);
				return result;

			//If number 
			} else {
				return result;
			}

			//If arithmetic operation
		} else {

			//call multiple operation basic arithmetic

			double num_eval = 0.0;

			num_eval = evalMultArith(eval);

			// System.out.println("here's the result "+num_eval);

			//remove zero if whole number 
			if (Math.floor(num_eval) == num_eval) {
				int k = (int)num_eval;
				result = Integer.toString(k);
				return result;
			} else {
				result = Double.toString(num_eval);
				return result;
			}
		}
	}


	/*
	* Evaluates multiple operation arithmetic
	*/

	public double evalMultArith(String[] str){
		double result = 0.0;

		//if the beginning number has an equals
		if (str[0].charAt(0) == '='){
			str[0] = str[0].substring(1);
		}

		//it's a number
		if (str.length ==1){
			result = Double.parseDouble(str[0]);
			return result;
		} else {
			//evaluate it once and then keep going 
	
			//if str[0] is cell reference, evaluate cell reference

			double i = 0.0;

			if (sheet.containsKey(str[0])){
				String cellref = evalCellRef(str[0]);
				i = Double.parseDouble(cellref);
			} else {
				i = Double.parseDouble(str[0]);
			}

			// double i = Double.parseDouble(str[0]);

			String op = str[str.length-1];

			String a1[] = Arrays.copyOfRange(str, 1, str.length-1);
		
			if (op.equals("+")){

				result= i+(evalMultArith(a1));
			}
			if (op.equals("*")){
				result= i*(evalMultArith(a1));
			}
			if (op.equals("-")){
				result= i-(evalMultArith(a1));
			}
			if (op.equals("/")){
				result= i/(evalMultArith(a1));
			}
			return result;
		}
	}


	/*
	* Evaluates a cell reference until it resolves to a number:
	* Allows multi cell referencing
	*/
	public String evalCellRef(String str){
		String result = str;

		//format =A1 to A1
		if (result.charAt(0) == '='){
			result = result.substring(1);
		}

		//if string references another cell
		if (sheet.containsKey(result)){
			String cell = sheet.get(result);

			//evaluate cell reference until you find a number
			return evalCellRef(cell);

		//if string doesn't reference another cell, it's a number
		} else {
			
			return result;
		}
	}

	/*
	*Writes to output the evaluated results of the input file
	*/
	public void writeSTDOUT(){
			
			for (int i = 1; i<= 1000000; i++){	

				if (sheet.containsKey("A"+Integer.toString(i))){

					//output spreadsheet by row
					ArrayList<String> row = new ArrayList<String>();
					
					for(char alpha='A';alpha<='[';alpha++){
			    		String next_key = alpha+Integer.toString(i);

		        		if (sheet.containsKey(next_key)){
		    
		        			String result = evaluate(sheet.get(next_key));
		        			row.add(result); 
		        			
		        		} else {
		        			String formatOutput = row.toString().replace("[", "")
		        												.replace("]", "")
		        												.replace(" ", "");
		        			System.out.println(formatOutput);
		        			break;
		        		}

		        	}
		        } else {
		        	break;
		        }
		    }
	}

	public static void main(String[] args) throws IOException {
		
		SpreadSheet s = new SpreadSheet();
		s.solve(args[0]);

	}
}
