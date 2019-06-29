/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
const lengthOfLongestSubstringKDistinct = function(s, k) {
    if (k === 0) return 0;

    const letters = s.split('');
    let dupLetters = [];
    let dupCounts = [];

    let start = 0;
    let end = 0;

    while (start <= letters.length - 1) {
        end = getEndIndex(letters, start);
        dupLetters.push(letters[start]);
        dupCounts.push(end - start + 1);
        start = end + 1;
    }

    let maxSum = 0;
    let maxStart = 0;
    let maxEnd = 0;
    start = 0;
    end = 0;
    while (end < dupLetters.length) {
        const { sum, end } = getWindowSum(dupLetters, dupCounts, start, k);

        if (end > dupLetters.length) break;

        if (sum > maxSum) {
            maxSum = sum;
            maxStart = start;
            maxEnd = end;
        }

        start += 1;
    }

    return maxSum;
};

function getWindowSum(dupLetters, dupCounts, start, k) {
    let end = start;

    while (
        !(new Set(dupLetters.slice(start, end + 1)).size > k) &&
        end + 1 <= dupLetters.length
    ) {
        end += 1;
    }
    end = end - 1 < 0 ? 0 : end - 1;

    let sum = 0;
    for (let i = start; i <= end; i++) {
        sum += dupCounts[i];
    }

    return { sum, end };
}

function getEndIndex(array, start) {
    let end = start;

    for (let i = start + 1; i <= array.length; i++) {
        if (array[i] === array[start]) {
            end = i;
        } else {
            break;
        }
    }

    return end;
}

// console.log(getEndIndex('eeeeeecceeeba'.split(''), 0)); // 5
// console.log(getEndIndex('eeeeeecceeeba'.split(''), 6)); // 7
// console.log(getEndIndex('eeeeeecceeeba'.split(''), 8)); // 10
// console.log(getEndIndex('eeeeeecceeeba'.split(''), 11)); // 11
// console.log(getEndIndex('eeeeeecceeeba'.split(''), 12)); // 12

console.log(getWindowSum(['e', 'c', 'e', 'b', 'a'], [6, 2, 3, 1, 1], 0, 2)); // 11
console.log(getWindowSum(['e', 'c', 'e', 'b', 'a'], [6, 2, 3, 1, 1], 2, 2)); // 4
console.log(getWindowSum(['e', 'c', 'e', 'b', 'a'], [6, 2, 3, 1, 1], 0, 3)); // 12
console.log(getWindowSum(['e', 'c', 'e', 'b', 'a'], [6, 2, 3, 1, 1], 0, 4)); // 13

console.log(lengthOfLongestSubstringKDistinct('eceba', 2)); // 3
console.log(lengthOfLongestSubstringKDistinct('aa', 1)); // 2
console.log(lengthOfLongestSubstringKDistinct('eeeeeecceeeba', 2)); //
