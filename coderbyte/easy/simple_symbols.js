function SimpleSymbols(str) { 
  
  //iterate through string
  //if it finds an alpha, needs to check both ends to see if there's a plus sign
  
  for (var i = 0; i < str.length; i ++) {
        
     if (/[a-z]/.test(str.charAt(i))) {
       if ((str.charAt(i-1) === "+") && 
       (str.charAt(i+1) === "+")){
           //keep going
        } else {
            return false;
        }
       } else {
           //keep going
       }
  }
  
  return true; 
         
}