/**
 * @param {number[]} nums
 * @return {number}
 */
const specialTriplets = nums => {
    const leftFreq = {},rightFreq={};
    let res = 0;
    const MOD = 1_000_000_007;
    nums.forEach((value,index) => (rightFreq[value] = rightFreq[value] !== undefined ? rightFreq[value]+1 : 1));
    nums.forEach((num,index) =>{
        const target = num * 2;
        if(leftFreq[target] !== undefined && rightFreq[target] !== undefined){
            let left = leftFreq[target],right=rightFreq[target];
            if(target==0) right -= 1;
            res = (res+(left*right))%MOD;
        }
        leftFreq[num] = leftFreq[num] !== undefined ? leftFreq[num] + 1 : 1;
        rightFreq[num] = rightFreq[num] - 1;
    });
    return res;
};