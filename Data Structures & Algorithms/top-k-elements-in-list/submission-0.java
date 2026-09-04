class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> q = 
        new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            q.add(pair);
            if(q.size() > k){
                q.poll();
            }
        }
        int[] l = new int[k];
        for(int i=0; i<k; i++){
            l[i] = (q.poll().getKey());
        }
        return l;
    }
}