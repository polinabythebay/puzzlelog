
/*Polina Soshnin
*Given the pointer/reference to the head of a singly linked list, 
*reverse it and return the pointer/reference to the 
*head of the reversed linked list
*/

public class LinkedListProblemClass {
	

//Given the pointer/reference to the head of a single linked list
//Reverse it and return the pointer/reference to the head of the
//reversed linked list 

	//Solution #1: Use Recursion
	public static LinkedListNode reverseRec (LinkedListNode head){

		//Base case
		if (head == null || head.next == null){
			return head;
		}	

		LinkedListNode reversed_list_head = reverseRec (head.next);

		head.next.next = head;
		head.next = null;

		return reversed_list_head;

	}


	//Solution #2: Use iteration 
	public static LinkedListNode reverseIter (LinkedListNode head){

		//base case
		if (head == null || head.next == null){
			return head;
		}

		LinkedListNode list_to_iterate = head.next;
		LinkedListNode final_list = head;

		//first set final_list to point to null
		final_list.next = null;

		//next, iterate through remaining list 

		while (list_to_iterate != null){
			LinkedListNode temp = list_to_iterate;
			list_to_iterate = list_to_iterate.next;

			temp.next = final_list;
			final_list = temp;
		}

		return final_list;

	}

}
