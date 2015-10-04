function ArrayAdditionI(arr) {
  arr.sort(function(a,b){
    return a - b;
  });
  var largest = arr.pop();
  
  // code goes here  
  return recursion(arr, largest); 
         
}

function recursion(arr, target) {
    console.log('recursion start');
    console.log(arr);
    console.log(target);
  if (target === 0) {
      console.log('returning true');
    return true;
  }
  
  for (var i = 0; i < arr.length; i++) {
      console.log('arr length ' + arr.length + ';' + arr);
      console.log('looping');
    var next = arr[i];
    if (next === target) {
        console.log(next);
      console.log('returning true2');
      return true;
    }
    
    var next_array = arr.slice();
    next_array.splice(i, 1);
    if (recursion(next_array, target - next)) {
      return true;
    }
  }

  return false;
}

// keep this function call here 
// to see how to enter arguments in JavaScript scroll down
console.log(ArrayAdditionI([4,6,10,1,3,23]));