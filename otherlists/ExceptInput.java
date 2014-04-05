/*
 * @author:Polina Soshnin
 * @email: psoshnin@wellesley.edu
 * @date created: Dec 30, 2013
 * @purpose: 
 * Given a list of integers, write a program to output an
 * integer-valued list of equal length such that the 
 * output elt at index i is the product of all input
 * elts except for the input elt i
 */ 
import java.util.Scanner;

public class ExceptInput{
  
  /*
   * Given index n in a1, update the Value integer at 
   * indexes 0...n such that the Value integer is the product
   * of all Key integers except for the Key integer at each index
   */
  public static void shareKeys(IntPair[] a1, Integer n, Integer k){
    
    //update Value integer if n-k is a valid index
    if(n-k>=0){
      multKeys(a1, n, n-k);
      shareKeys(a1, n, k+1);
    }
  }
  
  /*
   * Given two indexes i and j in a1, update Value integer
   * at index j to be the product of itself and the Key integer at index i 
   * and vice versa 
   */
  public static void multKeys(IntPair[] a1, Integer i, Integer j){
    
    Integer iKey= a1[i].getKeyInteger();
    Integer jKey= a1[j].getKeyInteger();
    Integer iValue= a1[i].getValueInteger();
    Integer jValue= a1[j].getValueInteger();
    
    a1[i].setValueInteger(iValue*jKey);
    a1[j].setValueInteger(jValue*iKey);
  }
  
  
/*
 * Helper class for QuestionThree.java 
 * Creates a pair of two integers, the first 
 * of which is the input elt (known as "Key") 
 * and the second of which is the output elt
 * (known as "Value")
 */
  private static class IntPair {
  
  //keyInteger represents the input elt
  //valueInteger represents the output elt 
  private Integer keyInteger;
  private Integer valueInteger;
  
  public IntPair(Integer aKey, Integer aValue) {
    this.setKeyInteger(aKey);
    this.setValueInteger(aValue);
  }
  
  public Integer getKeyInteger() {
    return keyInteger;
  }
  
  public void setKeyInteger(Integer keyInteger) {
    this.keyInteger = keyInteger;
  }
  
  public Integer getValueInteger() {
    return valueInteger;
  }
  
  public void setValueInteger(Integer valueInteger) {
    this.valueInteger = valueInteger;
  }
}

  
  public static void main(String[] args){
    
    //max array of 1000
    IntPair array[]= new IntPair[1000];
    
    Scanner reader= new Scanner(System.in);
    String line="";
    
    line= reader.nextLine();
    
    //first line of input contains n, number of elts in list 
    //assume n>=2
    Integer n= Integer.parseInt(line);

    //counter
    Integer counter=0;
    
    while(counter<n){
      //Next n lines will each contain an integer 
      String elt= reader.nextLine();
      Integer j= Integer.parseInt(elt);
      
      //add an integer pair to the list
      //where the first integer is the 
      //input elt ("Key") at index k and the second
      //integer is the output elt ("Value") at index k
      IntPair p1= new IntPair(j, 1);
      array[counter]= p1;
     
      //share current input elts such that
      //the output elt at index k is the product
      //of all current input elts except input elt at 
      //index k
      shareKeys(array, counter, 1);
      counter++;  
    }
    
    //Print the output elts (Values) at index i 
    for(Integer i=0; i<n; i++){
      System.out.println(array[i].getValueInteger());
    }
  }
}
  
  
  