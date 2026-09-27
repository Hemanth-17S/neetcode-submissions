class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length - 1;
        while (l < r) {
            while (l < r && !((c[l] >= 'a' && c[l] <= 'z') || (c[l] >= '0' && c[l] <= '9'))) {
                l++;
            }
            while (l < r && !((c[r] >= 'a' && c[r] <= 'z') || (c[r] >= '0' && c[r] <= '9'))) {
                r--;
            }
            if (c[l] == c[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
