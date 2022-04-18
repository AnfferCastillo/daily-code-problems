/**
 * Escribe una función que determine si es posible construir un string a partir de un arreglo de strings.
 *
 * Ejemplo:
 * phrase: 'probando'
 * A = [ 'p', 'ban', 'r', 'o' , 'orirra', 'do']
 * result: true .> p + r + o + ban + do
 */

const canConstruct = (phrase, words, memo = {}) => {
  if (phrase in memo) return memo[phrase];
  if (phrase == '') return true;

  for (let word of words) {
    if (phrase.startsWith(word)) {
      const newPhrase = phrase.substring(word.length);

      if (canConstruct(newPhrase, words, memo)) {
        memo[phrase] = true;
        return true;
      }
    }
  }
  memo[phrase] = false;
  return false;
};

const canConstructTab = (target, wordBank) => {
  const table = Array(target.length + 1).fill(false);
  table[0] = true;

  for (let i = 0; i <= target.length; i++) {
    if (table[i]) {
      for (const word of wordBank) {
        if (target.slice(i, i + word.length) === word) {
          table[i + word.length] = true;
        }
      }
    }
  }

  return table[target.length];
};

console.log(canConstruct('probando', ['p', 'ban', 'r', 'o', 'orirra', 'do'])); //true
console.log(canConstruct('skateboard', ['bo', 'rd', 'ate', 't', 'ska', 'sk', 'boar'])); //false
console.log(
  canConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eee',
    'eeee',
    'eeeee',
    'eeeeee',
  ])
); // false

console.log(canConstructTab('probando', ['p', 'ban', 'r', 'o', 'orirra', 'do'])); //true
console.log(canConstructTab('skateboard', ['bo', 'rd', 'ate', 't', 'ska', 'sk', 'boar'])); //false
console.log(
  canConstructTab('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eee',
    'eeee',
    'eeeee',
    'eeeeee',
  ])
); // false
