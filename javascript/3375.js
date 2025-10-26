/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function (nums, k) {
    let noOfOperations = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < k) {
            return -1;
        }
    }
    let unique = new Set(nums);
    unique = Array.from(unique);
    noOfOperations = unique.length;

    if (unique.includes(k)) {
        noOfOperations -= 1;
    }

    return noOfOperations;
};

function main() {
    let nums = [9, 7, 5, 3];
    let k = 1;
    console.log(minOperations(nums, k));
}


main()
