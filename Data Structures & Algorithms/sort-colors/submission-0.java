class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i=0; i<= end; i++){
            if(nums[i] == 0){
                swap(nums, start, i);
                if (start != i) i--;
                start++;
            } else if(nums[i] == 2){
                swap(nums, end, i);
                end--;
                i--;
            }
        }
        return;
    }

    public void swap(int[]nums, int pointer, int moving){
        int temp = nums[pointer];
        nums[pointer] = nums[moving];
        nums[moving] = temp;
        return;
    }
}