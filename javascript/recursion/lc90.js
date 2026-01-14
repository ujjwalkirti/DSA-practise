/**
 *
 * @param {number[]} arr
 * @param {number} start_index
 * @param {number[]} sub
 * @param {Map} map
 */
function helperFunction(arr, start_index, sub, map) {
    if (map.get(sub) || start_index >= arr.length) return;
    map.set(sub);
    sub.push(arr[start_index]);
    helperFunction(arr, start_index + 1, sub, map);
}

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function (nums) {
    let ans = [[]];
    const map = new Map();
    for (let i = 0; i < nums.length; i++) {
        let sub = []
        helperFunction(nums, i, sub, map)
    }
    for (const key of Object.keys(map)) {
        ans.push(key)
    }
    return ans;
};

function main() {
    const nums = [1, 2, 2]

    console.log(subsetsWithDup(nums))
}

main()
