class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 1;
        while (r < s.length()) {
            if (!charSet.contains(s.charAt(r))) {
                charSet.add(s.charAt(r));
                max = Math.max(r - l + 1, max);
                r++;
            } else {
                while (charSet.contains(s.charAt(l))) {
                    charSet.remove(s.charAt(l));
                }
                l++;
            }
        }
        return max;
    }
}
