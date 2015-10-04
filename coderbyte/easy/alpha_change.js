
//assumes any char of the alphabet (can be non letter)

var LetterChanges = function(str) { 
  //replace every letter with letter following it in the alphabet
  //capitalize every vowel
  //return it
  
  //turn string into array
  //iterate through array.
  //change the letter and then check if it's a vowel
  
  var arr = str.split("");
  console.log(arr);
  
  for (i = 0; i < arr.length; i++){
      
    if (/[a-z]/.test(arr[i])){  
    arr[i] =  String.fromCharCode(arr[i].charCodeAt() + 1)
    console.log(arr[i]);
        }
    
    if (/[aeiou]/.test(arr[i])){
      arr[i] = arr[i].toUpperCase();
        }
    }
 
  //turn array back into a string
    return arr.join("");

}

//"abc" "bcd" "cdE"

var str = "+bcd*";
console.log(LetterChanges(str));