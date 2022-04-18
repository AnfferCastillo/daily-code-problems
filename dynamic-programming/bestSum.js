/**
 * EScribe una función que tome por parametros un numero targetSum y un arreglo de numeros.
 * La funcion debe retornar un arreglo con la combinación mas corta de numeros que sumen
 * el targetSum.
 */

const bestSum = (targetSum, numbers) => {
  const table = Array(targetSum + 1).fill(null);
  table[0] = [];

  for (let i = 0; i <= targetSum; i++) {
    if (table[i]) {
      for (const number of numbers) {
        if (i + number <= targetSum) {
          if (!table[i + number] || table[i + number].length > table[i].length + 1)
            table[i + number] = [...table[i], number];
        }
      }
    }
  }

  return table[targetSum];
};

console.log(bestSum(8, [2, 3, 5])); // [3,5]
console.log(bestSum(4, [2, 3, 5])); // [2,2]
console.log(bestSum(5, [2, 3, 5])); // [5]
console.log(bestSum(6, [2, 3, 5])); // [3,3]
console.log(bestSum(10, [15, 30, 22])); //null
console.log(bestSum(7, [5, 3, 4, 7])); //[7]
console.log(bestSum(8, [1, 4, 5])); // [4,4]
console.log(bestSum(100, [1, 2, 5, 25])); //[25,25,25,25]
