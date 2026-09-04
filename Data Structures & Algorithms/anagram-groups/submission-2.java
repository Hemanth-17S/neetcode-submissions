class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> h = new HashMap();
        // for (String s : strs){
        //     char[] c = s.toCharArray();
        //     Arrays.sort(c);
        //     String code = new String(c);
        //     h.putIfAbsent(code, new ArrayList<String>());
        //     h.get(code).add(s);
        // }
        // return new ArrayList(h.values());
        for (String s: strs){
            int[] arr1 = new int[26];
            for (char x: s.toCharArray()){
                arr1[x - 'a']++;
            }
            String key = Arrays.toString(arr1);
            h.putIfAbsent(key, new ArrayList<String>());
            h.get(key).add(s);
        }
        return new ArrayList(h.values());
    }
}
