package JZOffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: FindRepeatNumberA
 * @Author: hp
 * @Date: 23/06/2021 15:35
 * @Version: 1.0
 * @Description: 剑指 Offer 03. 数组中重复的数字
 */
public class FindRepeatNumber03 {
    // 第一种方式：简单的排序+比较
    // 时间复杂度O（nlog(n)）,空间复杂度O（n）
    public int findRepeatNumberA(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }
    // 第二种方式：Hash表，时间复杂度O(N) 空间O(N)
    public int findRepeatNumberB(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return num;
            map.put(num, 1);
        }
        return 0;
    }

    // 第三种方式，根据限制条件 2 <= n <= 100000
    // 而数组中的所有数字都在0~n-1
    public int findRepeatNumberC(int[] nums) {
        int[] map = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(map[nums[i]] == 1) return nums[i];
            map[nums[i]] = 1;
        }
        return 0;
    }

    // 第四种方式，原地标记
    public int findRepeatNumberD(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]);
            if(nums[pos] < 0) return pos;
            nums[pos] = -nums[pos];
        }
        return 0;
    }
}
