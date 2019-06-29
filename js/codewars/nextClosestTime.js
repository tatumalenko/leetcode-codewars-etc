function nextClosestTime(time) {
    const array = time.split('').filter(e => e !== ':');
    const timeAsNumber = Number(array.join(''));
    let permutes = permutations(array);
    const allTimes = permutes
        .map(permute => Number(permute.join('')))
        .filter(e => e <= 2359);
    // .map(e => String(e).split(''))
    // .map(e => `${e[0]}${e[1]}:${e[2]}${e[3]}`);

    const allUniqueTimes = Array.from(new Set(allTimes)).filter(
        e => e !== timeAsNumber
    );

    const nextClosestTime = String(
        allUniqueTimes.reduce((prev, curr) =>
            curr < prev && curr > timeAsNumber ? curr : prev
        )
    ).split('');

    return `${nextClosestTime[0]}${nextClosestTime[1]}:${nextClosestTime[2]}${
        nextClosestTime[3]
    }`;
}

function permutations(array) {
    const results = [];

    if (array.length === 1) {
        results.push(array);
        return results;
    }

    for (let i = 0; i < array.length; i++) {
        const firstChar = array[i];
        const charsLeft = [...array.slice(0, i), ...array.slice(i + 1)];
        const innerPermutations = permutations(charsLeft);
        for (let j = 0; j < innerPermutations.length; j++) {
            results.push([...firstChar, ...innerPermutations[j]]);
        }
    }
    return results;
}

console.log(nextClosestTime('23:35'));
console.log(nextClosestTime('19:34'));
// permutations2(['2', '3', '3', '5'], 0, 3);
// console.log(permutations(['2', '3', '3', '5']));
// console.log(permutations(['1', '2', '3', '4']));
