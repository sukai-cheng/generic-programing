package sukai.algorithm.halfSort.case01;

/**
 * @author chengsukai
 * @since 2022-08-08 13:40
 */
public class Solution {
    public static void main(String[] args) {



    }

    /**
     * 相错终止/左闭右闭
     *
     * @param nums   数组
     * @param target 目标
     */
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        // r = l - 1;
        while (l <= r) {
            int c = l + (r - l) / 2;
            if (nums[c] == target) return c;
            else if (nums[c] < target) {
                l = c + 1;
            } else {
                r = c - 1;
            }
        }
        return -1;
    }
}
