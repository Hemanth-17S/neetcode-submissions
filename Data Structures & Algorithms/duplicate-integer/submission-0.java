class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet unq = new HashSet();
        for(int num : nums)
        {
            if(unq.contains(num)){
                return true;
            } else {
                unq.add(num);
            }
        }
        return false;
    }
}
