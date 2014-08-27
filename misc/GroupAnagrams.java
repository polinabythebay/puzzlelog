
/*
@author: Polina Soshnin
*@email: psoshnin@wellesley.edu
*@purpose: Given a set a strings, group all of the anagrams together
*
*@solution:
*Use the normal string hash function on whatever your platform is. 
*The important thing is to make the key for your hash table the idea of a 
*"sorted word" - where the word is sorted by letter, so "car" => "acr". 
*All anagrams will have the same "sorted word".
*Just have a hash from "sorted word" to "list of words for that sorted word".
*/

import java.util.*;
import java.io.*;

public class GroupAnagrams {



}