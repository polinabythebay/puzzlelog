function multiply(a,b){
	return a*b;
}

function FirstFactorial(num) { 
 var result = 1;
  for (var i = num; i > 0; i--){
	result = multiply(result, i);
  }
  // code goes here  
  return result; 
         
}
   
// keep this function call here 
// to see how to enter arguments in JavaScript scroll down
FirstFactorial(readline());   