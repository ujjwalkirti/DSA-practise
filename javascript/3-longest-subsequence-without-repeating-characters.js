/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    const map = new Map();

    let i=0, j=0, max = 0;
    while (j < s.length) {
        if (map.has(s[j])) {
            i = Math.max(i, map.get(s[j]) + 1);
        }
        map.set(s[j], j);
        max = Math.max(max, j - i + 1);
        j++;
    }

    return max;
};


function main() {
    let s = "abcabcbb"
    console.log(lengthOfLongestSubstring(s));
}

main();
