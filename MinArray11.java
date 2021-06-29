package JZOffer;

import DP.MinStepsA;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: MinArray11
 * @Author: hp
 * @Date: 27/06/2021 10:43
 * @Version: 1.0
 * @Description: 剑指 Offer 11. 旋转数组的最小数字
 * 描述：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 输入：[3,4,5,1,2]
 * 输出：1
 */
public class MinArray11 {
    // 暴力法
    public int minArray(int[] numbers) {
        if(numbers.length < 2) return numbers[0];
        if(numbers[0] >= numbers[numbers.length - 1]) {
            for(int i = 1; i < numbers.length; i++) {
                if(numbers[i] < numbers[i - 1]) return numbers[i];
            }
        }
        return numbers[0];
    }
    // 二分查找
    public int minArrayA(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int middle = low + (low + high) / 2;
            if(numbers[middle] < numbers[high]) {
                high = middle;
            } else if(numbers[middle] > numbers[high]) {
                low = middle + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
//        int[] nums = {3, 4, 5, 1, 2};
//        int[] nums = {2, 2, 2, 0, 1};
        int[] nums = {1, 3, 5};
//        System.out.println(new MinArray11().minArray(nums));
        System.out.println(new MinArray11().minArrayA(nums));
    }
}
