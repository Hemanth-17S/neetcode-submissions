class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // n = length of the pattern (s1), which is also the fixed window size.
        // m = length of the text (s2) we are searching in.
        int n = s1.length(), m = s2.length();

        // A permutation of s1 is exactly n characters long.
        // If s2 is shorter than that, no window of size n can exist.
        // This also stops the first-window loop below from reading past the end of s2.
        if (n > m) return false;

        // Letter frequency tables. Index 0 = 'a', 1 = 'b', ..., 25 = 'z'.
        // need   -> how many of each letter a valid permutation must contain (from s1).
        // window -> how many of each letter are in the current window of s2.
        int[] need = new int[26];
        int[] window = new int[26];

        // Build both tables in one pass over the first n positions.
        for (int i = 0; i < n; i++) {
            // s1.charAt(i) - 'a' maps a letter to its table index.
            // Example: 'a' - 'a' = 0, 'c' - 'a' = 2.
            // Count every letter of s1 into need.
            need[s1.charAt(i) - 'a']++;

            // Count the first n letters of s2 (indices 0..n-1) into window.
            // After the loop, window describes s2's first window.
            window[s2.charAt(i) - 'a']++;
        }

        // Two strings of the same length are permutations of each other
        // exactly when every letter count matches.
        // Arrays.equals compares the two 26-element tables position by position.
        // This checks the first window (indices 0..n-1) before any sliding.
        if (Arrays.equals(need, window)) return true;

        // Slide the window one position to the right per iteration.
        // i is the index of the character ENTERING the window on the right.
        // It starts at n because indices 0..n-1 are already in the first window.
        for (int i = n; i < m; i++) {

            // Add the new right-hand character to the window counts.
            // The window temporarily holds n + 1 characters after this line.
            window[s2.charAt(i) - 'a']++;

            // Remove the character that just fell off the left side.
            // The window is n wide and its right edge is i,
            // so the leftmost old character sits at index i - n.
            // After this line the window is back to n characters,
            // covering indices (i - n + 1) through i.
            window[s2.charAt(i - n) - 'a']--;

            // Compare the updated window to the target counts.
            // A match means this window is a permutation of s1.
            if (Arrays.equals(need, window)) return true;
        }

        // Every window of size n in s2 was checked and none matched.
        return false;
    }
}