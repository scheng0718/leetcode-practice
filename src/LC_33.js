/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if (!nums || nums.length === 0) return -1
    let left = 0
    let right = nums.length - 1
    while (left <= right) {
        let middle = Math.floor((left + right) / 2)
        if (nums[middle] === target) return middle
        
        if (nums[middle] >= nums[left]) {
            if (nums[left] <= target && nums[middle] > target) right = middle - 1
            else left = middle + 1
        } else {
            if (nums[right] >= target && nums[middle] < target) left = middle + 1
            else right = middle - 1
        }
    }  
    return -1
}