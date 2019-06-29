const assert = require('assert');

/**
 * @param {string[]} strs
 * @return {string}
 */
const longestCommonPrefix = function(strs) {
    if (strs.length === 0 || strs.some(str => str.length === 0)) { return ''; }
    if (strs.length === 1) { return strs[0]; }
    
    let prefix = strs[0];
    for (let i = 1; i < strs.length; i += 1) {
        const str = strs[i];
        for (let j = 0; j < Math.min(prefix.length, str.length); j += 1) {
            if (str.charAt(j) !== prefix.charAt(j)) {
                prefix = prefix.substr(0, j);
            } else if (j === str.length - 1 && str.length < prefix.length) {
                prefix = prefix.substr(0, str.length);
            }
        }
    }
    
    return prefix;
};

assert.equal(longestCommonPrefix(['flower','flow','flight']), 'fl');
assert.equal(longestCommonPrefix(['aa', 'a']), 'a');
assert.equal(longestCommonPrefix(['aa', 'a', '']), '');