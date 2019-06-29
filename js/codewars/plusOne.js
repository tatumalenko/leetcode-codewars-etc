/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let carry = 0;
    let copy = [...digits];

    for (let i = copy.length - 1; i >= 0; i--) {
        if (copy[i] === 9) {
            copy[i] = 0;
            carry = 1;

            if (i === 0) {
                copy.unshift(1);
            }
        } else if (carry > 0) {
            copy[i] += 1;
            break;
        } else {
            copy[i] += 1;
            break;
        }
    }

    return copy;
};

console.log(plusOne([6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3]));
console.log(plusOne([9, 9, 9, 9, 9]));
console.log(plusOne([3, 9, 9, 9, 9]));
console.log(plusOne([3, 9, 9, 9, 8]));
