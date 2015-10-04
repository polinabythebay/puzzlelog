function LetterCapitalize(str) { 
  //turn string to array
  var array = str.split(" ");
  
  //iterate through array and capitalize the first char of each elt
  for (var i = 0; i < array.length; i ++){
	array[i] = array[i].charAt(0).toUpperCase() + array[i].slice(1);
  }

  // array to string
  var result = array.join(" ");
  return result; 
         
}
   
// keep this function call here 
// to see how to enter arguments in JavaScript scroll down
LetterCapitalize(readline()); 