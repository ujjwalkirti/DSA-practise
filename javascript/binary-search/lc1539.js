/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var findKthPositive = function (arr, k) {
    let low = 0;
    let high = arr.length - 1;

    while (low <= high) {
        let mid = Math.floor(low + (high - low) / 2);
        let missing = arr[mid] - (mid + 1);

        if (missing < k) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    // kth missing number
    return low + k;
};


function main() {
    const nums = [2, 3, 4, 7, 11];
    const target = 5;
    console.log(findKthPositive(nums, target));
}

main();
