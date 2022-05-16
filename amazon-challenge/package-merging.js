/**
 * Existe un arreglo de N numeros que representan el peso de N cantidad de paquetes.
 * Podemos unir el paquete i con el paquete i+1 si y solo si el peso del paquete i es menor o igual al paquete i+1.
 * Una vez unidos los paquetes podemos despreciar el paquete i + 1.
 * Escribe una funcion que devuelva el peso maximo alcanzado por un paquete luego de unir cualquier cantidad
 * de veces posibles dos paquetes.
 *
 * Ejemplo:
 * weights = [2, 9, 10, 3, 7]
 *
 * Si unimos el paquete weights[i] y wieghts[2] nos queda
 * weights = [2, 19, 3, 7]
 *
 * uniendo weights[0] y weights[1]
 * weights = [21, 3, 7]
 *
 * Por ultimo unimos weights[1] y wieghts[2]
 * weights = [21, 10]
 *
 * 21 > 10 entonces el resultado es 21
 *
 * constraints: wiehgts length >= 1
 */

const maxPackage = (weights) => {
  const stack = [];
  let i = 0;
  while (i < weights.length) {
    stack.push(weights[i]);
    let j = i + 1;
    while (j < weights.length && weights[j] > weights[j - 1]) {
      stack.push(weights[j]);
      j++;
    }

    if (stack.length >= 2) {
      const weightA = stack.pop();
      const weightB = stack.pop();
      if (weightA >= weightB) stack.push(weightA + weightB);
      else {
        stack.push(weightB);
        stack.push(weightA);
      }
    }

    i = j;
  }

  while (stack.length > 1) {
    const weightA = stack.pop();
    const weightB = stack.pop();
    if (weightA >= weightB) stack.push(weightA + weightB);
    else stack.push(weightB);
  }
  return stack[0];
};

const packageMergin2 = (weights) => {
  if (weights.length == 2) {
    if (weights[1] > weights[0]) return weights[0] + weights[1];
  }

  while (weights.length >= 2) {
    const weightB = weights.pop();
    const weightA = weights.pop();

    if (weightB > weightA) weights.push(weightB + weightA);
    else weights.push(weightA);
  }

  return weights[0];
};

console.log(packageMergin2([2, 9, 10, 3, 7])); // 21
console.log(packageMergin2([2, 9, 10, 3, 20])); // 44
console.log(packageMergin2([30, 15, 5, 9])); // 30
console.log(packageMergin2([6, 7, 10, 20, 1, 16, 14, 18, 15, 19])); // 126
console.log(packageMergin2([6, 7, 10, 20, 1, 1, 1, 1, 1, 1])); // 43
console.log(packageMergin2([2, 2])); //2
