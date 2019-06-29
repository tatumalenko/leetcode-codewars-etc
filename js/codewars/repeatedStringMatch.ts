function repeatedStringMatch(A: string, B: string): number {
    // const repeatedA : string = A;
    // const repeats : number = 1;
    // const maxLength : number = B.length;
    // const maxRepeats : number = Math.floor(maxLength / A.length);

    // for (let i = 0; i < maxRepeats; i++) {
    //     repeatedA += A;
    //     repeats++;
    // }

    if (A.includes(B)) return 1;

    if (A.length >= B.length && (A + A).includes(B)) return 2;

    // Else A.length < B.length
    let repeatedA: string = A;
    let repeats: number = 1;
    while (repeatedA.length < B.length) {
        repeatedA += A;
        repeats += 1;
    }

    return repeatedA.includes(B) ? repeats : -1;
}

console.log(repeatedStringMatch('aaaaaaaaaaab', 'ba'));
