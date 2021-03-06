// GOOGLE QUESTION #1 FALL 2018

function solution(A) {
    let numOfIndicesWhoReachedEnd = 0;

    for (let j = 0; j < A.length; j++) {
        let reachedEndOrUndefined = false;
        let jump = 1;

        let q = j;

        while (!reachedEndOrUndefined) {
            const pair = findMinIndexPair(A, q, jump);

            if (!pair) {
                reachedEndOrUndefined = true;
            } else q = pair[1];

            if (q === A.length - 1) {
                reachedEndOrUndefined = true;
                numOfIndicesWhoReachedEnd += 1;
            }

            jump += 1;
        }

        reachedEndOrUndefined = false;
    }

    return numOfIndicesWhoReachedEnd;
}

function allIndexPairs(array, k) {
    const pairs = [[]];
    for (let i = 0; i < array.length; i++) {
        if (i !== k) {
            pairs.push([k, i]);
        }
    }
    return pairs.slice(1);
}

function findMinIndexPair(array, k, jump) {
    const pairs = allIndexPairs(array, k);
    const differences =
        jump % 2 === 0
            ? pairs.map(e => array[e[0]] - array[e[1]])
            : pairs.map(e => -array[e[0]] + array[e[1]]);

    let minIndex = -1;
    let minDifference = Number.MAX_SAFE_INTEGER;
    for (let i = 1; i < differences.length; i++) {
        if (differences[i] >= 0 && i > k && differences[i] < minDifference) {
            minDifference = differences[i];
            minIndex = i;
        }
    }

    return pairs[minIndex];
}

// console.log(allIndexPairs([1, 2, 3, 4, 5], 3));
// console.log(findMinIndexPairEven([1, 2, 3, 4, 5], 3));
// console.log(findMinIndexPairOdd([10, 13, 12, 14, 15], 1));
// console.log(findMinIndexPairEven([10, 13, 12, 14, 15], 3));
console.log(solution([10, 13, 12, 14, 15]));
