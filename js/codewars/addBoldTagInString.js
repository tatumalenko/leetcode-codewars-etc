/**
 * @param {string} s
 * @param {string[]} dict
 * @return {string}
 */
var addBoldTag = function(s, dict) {
    const subIndices = dict.map(e => [
        s.indexOf(e),
        s.indexOf(e) + e.length - 1
    ]);

    return subIndices;
};

console.log(addBoldTag('abcxyz123', ['abc', '123'])); // "<b>abc</b>xyz<b>123</b>"
console.log(addBoldTag('aaabbcc', ['aaa', 'aab', 'bc'])); // "<b>aaabbc</b>c"
