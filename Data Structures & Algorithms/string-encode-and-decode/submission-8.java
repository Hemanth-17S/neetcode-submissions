class Solution {
    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s : strs) {
            str.append(s.length()).append("#").append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(i) != '#') {
                i++;
            }
            Integer idx = Integer.parseInt(str.substring(j,i));
            i = i + 1;
            j = i + idx;
            result.add(str.substring(i,j));
            i = j;
        }
        return result;
    }
}
