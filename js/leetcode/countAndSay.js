const assert = require('assert');

const collectByConseqNumbersAs2dArray = function collectByConseqNumbersAs2dArray(str) {
  const strAsCharArray = str.split('');
  const charArraySize = strAsCharArray.length;
  const output = [];

  if (charArraySize === 1 && strAsCharArray[0] === '1') { return [['1', '1']]; }

  let prev = strAsCharArray[0];
  let prevInnerSize = 1;
  for (let i = 1; i < charArraySize; i += 1) {
    const curr = strAsCharArray[i];
    if (curr === prev) {
      prevInnerSize += 1;
    } else {
      output.push([prev, prevInnerSize]);
      prev = curr;
      prevInnerSize = 1;
    }

    if (i === charArraySize - 1) {
      output.push([prev, prevInnerSize]);
    }
  }

  return output;
};

/**
 * @param {number} n
 * @return {string}
 */
const countAndSay = function countAndSay(n) {
  if (n == 1) { return '1'; }
  let curr = '';
  let prev = '1';
  for (let i = 1; i < n; i += 1) {
    const collectedByConseqNumbersAs2dArray = collectByConseqNumbersAs2dArray(prev);
    curr = collectedByConseqNumbersAs2dArray
      .reduce((acc, [k, v]) => acc += `${v}${k}`, '');
    prev = curr;
  }

  return curr;
};

const map = {
  1: '1',
  2: '11',
  3: '21',
  4: '1211',
  5: '111221',
  6: '312211',
  7: '13112221',
  8: '1113213211',
  9: '31131211131221',
};

Object.entries(map).forEach(([input, expected]) => {
  assert(countAndSay(input) === expected);
});
