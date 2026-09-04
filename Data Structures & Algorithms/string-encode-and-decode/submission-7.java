class Solution {

    public String encode(List<String> strs) {
        StringBuilder es = new StringBuilder();
        for(String s : strs){
            es.append(s.length()).append("#").append(s);
        }
        return es.toString();
    }

    public List<String> decode(String str) {
        List<String> dss = new ArrayList();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            dss.add(str.substring(j, j + length));
            i = j + length;
        }
        return dss;
    }
}
