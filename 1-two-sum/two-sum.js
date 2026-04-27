/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const map= new Map();

    for(let i=0; i<nums.length; i++){
        const curnum= nums[i];
        const comp= target - curnum;

        if(map.has(comp)){
            return [map.get(comp),i];
        }
        map.set(curnum,i);
    }
    return [];
};