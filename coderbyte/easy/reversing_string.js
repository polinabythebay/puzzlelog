//reversing a string

//iterative solution
//time: n (linear)
//space: 1 (constant)

var reverseString = function(str){
    //turn string to array
    var arr = str.split("");
    var result = "";
    
    for (i = arr.length-1; i >= 0; i--){
        result = result+arr[i]
    }

    return result;
}

var st1 = "cat dog"

console.log(reverseString(st1));


//reversing a string recursively

//recursive solution

var reverseRecur = function(str){
    //if just one char, return char
    if (str.length === 1){
        return str;
    } else {
        return str.slice(-1)+reverseRecur(str.slice(0,-1));
    }
}

var st2 = "taco cat";
console.log(reverseRecur(st2));