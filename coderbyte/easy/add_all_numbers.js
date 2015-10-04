var SimpleAdding = function(num) { 
	
  var counter = 1;
  var result = 0;
  while(counter<=num){
      result = result+counter;
      counter++;
  }
  return result;      
}

console.log(SimpleAdding(2));