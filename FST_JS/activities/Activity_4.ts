let input = [1,2,3,4,5,6];
let output : number[] = [];

input.map((num) => {
     if(num % 2 == 0) {
        output.push(num * num) 
    }
});

console.log(output);
   
