/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function (g, s) {
    // sort the arrays
    // descending order
    g.sort((a, b) => b - a);
    // ascending order
    s.sort((a, b) => a - b);
    let count = 0;
    for (let i = g.length - 1; i >= 0; i--) {
        for (let j = 0; j < s.length; j++) {
            if (g[i] <= s[j]) {
                s[j] = -1;
                count++;
                break;
            }
        }
    }
    return count;
};


function main() {
    let g = [10,9,8,7];
    let s = [10,9,8,7];
    console.log(findContentChildren(g, s));
}

main();
