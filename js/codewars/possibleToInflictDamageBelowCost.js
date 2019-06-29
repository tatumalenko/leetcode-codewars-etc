function possibleToInflictDamageBelowCost(
    totalMoney,
    totalDamage,
    costs,
    damages
) {
    const size = costs.length;
    const idxs = [...Array(size).keys()];
    const allIdxCombinations = [[]];
    for (const idx of idxs) {
        const copy = [...allIdxCombinations];
        for (const previousIdxCombination of copy) {
            const idxCombination = [...previousIdxCombination, idx];
            allIdxCombinations.push(idxCombination);
            const thisCost = sum(idxCombination.map(i => costs[i]));
            const thisDamage = sum(idxCombination.map(i => damages[i]));
            if (thisCost <= totalMoney && thisDamage >= totalDamage)
                return true;
        }
    }

    return false;
}

function combinations1(array, n) {
    const lists = [];
    const M = 1 << array.length; // 2**array.length

    for (let i = 1; i < M; ++i) {
        // const sublist = array.filter((c, k) => (i >> k) & 1);

        const sublist = [];
        for (let k = 0; k < array.length; k++) {
            if ((i >> k) & 1) {
                sublist.push(array[k]);
            }
        }

        // if (sum(sublist) <= n) lists.push(sublist);
        lists.push(sublist);
    }

    return lists;
}

function combinations(array) {
    // O(2^n)
    const results = [[]];
    for (const value of array) {
        const copy = [...results];
        for (const prefix of copy) {
            results.push([...prefix, value]);
        }
    }
    return results.slice(1);
}

function sum(nums) {
    let sigma = 0;

    for (let i = 0; i < nums.length; i++) sigma += nums[i];

    return sigma;
}
// console.log(combinations([1, 2, 3, 4, 5]));
// console.log(sum([1, 2, 3, 4, 5]));
console.log(possibleToInflictDamageBelowCost(5, 4, [4, 5, 1], [1, 2, 3]));
console.log(possibleToInflictDamageBelowCost(1, 4, [4, 5, 1], [1, 2, 3]));
console.log(possibleToInflictDamageBelowCost(1, 4, [4, 5, 1], [1, 2, 3]));
