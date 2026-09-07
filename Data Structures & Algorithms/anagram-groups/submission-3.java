class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for(String s : strs){
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String key = new String(cArr);
            List<String> val = map.get(key);
            if(val == null){
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(key, temp);

            } else {
                val.add(s);
            }
        }
        return map.values().stream()
        .collect(Collectors.toList());
    }
}
