/*
 * @author: Polina Soshnin
 * @email: psoshnin@wellesley.edu
 * @date created: Dec 30, 2013
 * @purpose: 
 * Implement a circular buffer of size N. Allow the caller to append, 
 * remove and list the contents of the buffer. Implement the buffer 
 * to achieve maximum performance for each of the operations.
 * 
 * There are four types of commands.
 * "A" n - Append the following n lines to the buffer. 
 * "R" n - Remove first n elements of the buffer. 
 * "L" - List the elements of buffer in order of their inserting time.
 * "Q" - Quit.
 */

import java.util.Arrays;
import java.util.Scanner;

public class CircularBuffer {
  
  private String[] circularBuffer; 
  private int startIndex;
  private int currentIndex; 
  private int numberItems;
 
  public CircularBuffer(int size){
    circularBuffer = new String[size];
  }
  
  /*
   * Updates an index such that it 
   * wraps around if it gets to end of the buffer
   */
  
  private void updateIndex(int index){
    index++;
    if (index >= circularBuffer.length){
      index= 0;
    }
  }
  
  private void updateNumberItems(){
    if (numberItems < circularBuffer.length){
      numberItems++;
    }
  }

  /*
   * Appends item to the buffer.
   * If the buffer is full, replaces the oldest items.
   */
  
  public void appendItem(String item){

    if (startIndex == currentIndex && circularBuffer[currentIndex]!= null){
      updateIndex(startIndex);
    } 
    
    circularBuffer[currentIndex] = item;

    updateIndex(currentIndex);
    updateNumberItems();
  }
  
  /*
   * Removes item from the buffer.
   */
  
  public void removeItem(){

    circularBuffer[startIndex]= null;
    updateIndex(startIndex);
    numberItems--;
  }
  
  /*
   * Prints the items in the buffer in order of their insertion time.
   */
  
  public void listItems(){
    int printCounter= startIndex;
    for (int i= numberItems; i>0; i--){
      System.out.println(circularBuffer[printCounter]);
      printCounter = updatePrintCounter(printCounter);
    } 
  }
  
  private int updatePrintCounter(int counter){
    counter++;
    if (counter >= circularBuffer.length){
      return 0;
    }
    return counter;
  }
  
  
  public static void main(String[] args){
    
    Scanner reader= new Scanner(System.in);
    String line= reader.nextLine();
    CircularBuffer buffer = new CircularBuffer(Integer.valueOf(line));
    
    while(true) {
     
      line = reader.nextLine();
      
      if (line.equals("Q")){
        System.exit(0);
      }
      
      if (line.equals("L")){
        buffer.listItems();   
       } 
      
      String[] split = line.split(" ");
      
      if(split.length==2){ 

        if (split[0].equals("A")){
          Integer n= Integer.parseInt(split[1]);
          while(n>0){
            String elt= reader.nextLine();
            buffer.appendItem(elt);
            n--;
          }
        } 
        
        if (split[0].equals("R")){
          Integer n= Integer.parseInt(split[1]);
           while(n>0){
            buffer.removeItem();
            n--;
          }
        }
      }   
    }
  } 
}

