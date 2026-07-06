function fizzBuzzArray(arr: number[]): string[] {
  return arr.map((num) => {
    if (num % 15 === 0) return "FizzBuzz";
    if (num % 3 === 0) return "Fizz";
    if (num % 5 === 0) return "Buzz";
    return num.toString();
  });
}

let input = [1, 2, 3, 4, 5, 15, 20];
console.log(fizzBuzzArray(input));
