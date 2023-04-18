/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    var result = init;
    for (var i = 0; i < nums.length; i++) {
        result = fn(result, nums[i]);
    }
    return result;
};