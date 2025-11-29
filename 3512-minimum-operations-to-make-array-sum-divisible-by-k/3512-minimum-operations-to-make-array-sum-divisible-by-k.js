/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const minOperations = (nums, k) => nums.reduce((prev,curr) => prev + curr ,0)%k;