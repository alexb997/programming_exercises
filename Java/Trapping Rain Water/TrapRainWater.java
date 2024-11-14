public class TrapRainWater {
    public static int solution(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int water_trapped = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    water_trapped += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    water_trapped += right_max - height[right];
                }
                right--;
            }
        }

        return water_trapped;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int waterTrapped = solution(height);

        System.out.println("Water Trapped: " + waterTrapped);
    }
}