class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int max = 0;
        int res = 0;
        HashMap<Character, Integer> f = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            f.put(s.charAt(r), f.getOrDefault(s.charAt(r), 0) + 1);
            max = Math.max(max, f.get(s.charAt(r)));

            while (r - l + 1 - max > k) {
                f.put(s.charAt(l), f.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
