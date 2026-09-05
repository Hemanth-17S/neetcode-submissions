class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] op = new int[2];
        for(int i = 0; i < nums.length; i++){
            int numToCheck = target - nums[i];
            if(map.containsKey(numToCheck)){
                op[0] = map.get(numToCheck);
                op[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return op;
    }
}
