//Polina Soshnin
//May 4, 2014
//Code Jam practice
//Africa 2010 qualification round

import java.util.*;

public class StoreCredit{

  public static int[] pickItems(int[] list, int credit){
    
    int[] result = new int[2];
    
    for (int i=0; i<list.length; i++){
      for (int j=i+1; j<list.length; j++){
        if (list[i]+list[j]== credit){    
        result[0]= i+1;
        result[1]= j+1;
        return result;
      }
    } 
  }
    return result;
  }

 public static void main(String[] args){

   Scanner reader= new Scanner(System.in);
    
    Integer num_tests= Integer.parseInt(reader.nextLine());
    
    for (int i=0; i<num_tests; i++){

      Integer credit = Integer.parseInt(reader.nextLine());
      Integer size_list = Integer.parseInt(reader.nextLine());
      String[] items = reader.nextLine().split(" ");
      
      int[] ints = new int[items.length];
      
      for (int j=0; j < items.length; j++) {
        ints[j] = Integer.parseInt(items[j]);
      }
      
     int[] result = pickItems(ints, credit);
     
      int case_num = i+1;
      System.out.println("Case #"+case_num+": "+result[0]+" "+result[1]);
      
    }
 }
}