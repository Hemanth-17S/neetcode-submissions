class Solution {
    public int trap(int[] height) {
          if (height == null || height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int maxL = height[0];
        int maxR = height[height.length - 1];
        int totalWater = 0;

        while (l < r) {
            int trappedWater = 0;
            if (maxL < maxR) {
                l++;
                maxL = Math.max(maxL, height[l]);
                trappedWater = maxL - height[l];
                totalWater += (trappedWater > 0 ? trappedWater : 0);

            } else {
                r--;
                maxR = Math.max(maxR, height[r]);
                trappedWater = maxR - height[r];
                totalWater += (trappedWater > 0 ? trappedWater : 0);
            }
        }
        return totalWater;
    }
}
