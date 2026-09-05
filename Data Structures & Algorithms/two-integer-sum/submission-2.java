class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int numToCheck = target - nums[i];
            if(map.containsKey(numToCheck)){
                 return new int[]{map.get(numToCheck), i};
            } else {
                map.put(nums[i], i);
            }
        }
       return new int[] {0, 0};
    }
}
