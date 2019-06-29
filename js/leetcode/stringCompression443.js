const assert = require('assert');

/**
 * @param {character[]} chars
 * @return {number}
 */
const compress = function(chars) {
    const charsSize = chars.length;
    let rightIdx = charsSize - 1;
    let right = chars[rightIdx];
    let left;
    for (let i = charsSize - 2; i >= 0; i -= 1) {
        left = chars[i];
        if (left !== right) {
            const nCompressed = rightIdx - i;
            const nCompressedAsCharArray = String(nCompressed).split('');
            if (nCompressed === 1) {
                chars.splice(i + 1, nCompressed, right);
            } else {
                chars.splice(i + 1, nCompressed, right, ...nCompressedAsCharArray);
            }
            rightIdx = i;
            right = chars[rightIdx];
        }
        
        if (i === 0) {
            const nCompressed = rightIdx + 1;
            const nCompressedAsCharArray = String(nCompressed).split('');
            if (nCompressed === 1) {
                chars.splice(i, nCompressed, right);
            } else {
                chars.splice(i, nCompressed, right, ...nCompressedAsCharArray);
            }
            
        }
    }

    return chars;
};

const map = [
    [["a","a","b","b","c","c","c"], ["a","2","b","2","c","3"]],
    [["a"], ["a"]],
    [["a","b","b","b","b","b","b","b","b","b","b","b","b"], ["a","b","1","2"]]
];

map.forEach(([input, expected]) => {
    assert.deepEqual(compress(input), expected);
});