function LongestWord(sen) { 
  //string to array
  var arr = sen.split(" ");
  //start at beginning of array
  //strip word of any non-alpha characters
  //update counter to length of first word and result to be that word
  //if anything is longer, replace it. otherwise, keep it
  
  var longest = "";
  for (i = 0; i< arr.length; i++){
    //strip word of any non-alpha characters
    var current = arr[i];
    current = current.replace(/[^A-Za-z0-9]/g, '');
    if (current.length > longest.length){
      longest = current;
    }
    
  }

  return longest; 
         
}

var st1 = "I love dogs";
var st2 = "fun&!! time";

console.log(LongestWord(st2));