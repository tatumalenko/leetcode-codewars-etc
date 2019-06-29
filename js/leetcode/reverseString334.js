const assert = require('assert');

/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
const reverseString = function(s) {
    let temp;
    for (let i = 0, j = s.length - 1; i < j; i += 1, j -= 1) {
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    return s;
};

assert.deepEqual(reverseString(['h','e','l','l','o']), ['o','l','l','e','h']);
assert.deepEqual(reverseString(['H','a','n','n','a','h']), ['h','a','n','n','a','H']);