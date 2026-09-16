class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int inputArrLen = nums.length;
        ArrayList<Integer>[] arr = new ArrayList[inputArrLen + 1];
        for(int i=0; i<arr.length; i++){
            arr[i] = new ArrayList<>();
        }

        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inputArrLen; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            arr[entry.getValue()].add(entry.getKey());
        }

        int counter = 0;
        int[] result = new int[k];
        for(int i = nums.length; i > 0 && counter < k; i--){
            if(!arr[i].isEmpty()){
                for(int j=0; j<arr[i].size() && counter < k; j++){
                    result[counter] = arr[i].get(j);
                    counter++;
                }
            }
        }

        return result;
    }
}
