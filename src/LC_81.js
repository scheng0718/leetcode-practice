/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var search = function(nums, target) {
  if (!nums || nums.length === 0) return false
  let left = 0
  let right = nums.length - 1
  while (left <= right) {
    let middle = Math.floor((left + right) / 2)
    if (nums[middle] === target) return true
    if (nums[middle] > nums[left]) {
      if (nums[left] <= target && nums[middle] > target) {
        right = middle - 1
      } else {
        left = middle + 1
      }
    } else if (nums[middle] < nums[left]) {
      if (nums[middle] < target && nums[right] >= target) {
        left = middle + 1
      } else {
        right = middle - 1
      }
    } else {
      left++
    }
  }
  return false   
}