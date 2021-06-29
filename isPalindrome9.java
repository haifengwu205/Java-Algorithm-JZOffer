package JZOffer;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: isPalindrome9
 * @Author: hp
 * @Date: 27/06/2021 17:29
 * @Version: 1.0
 * @Description: 9. 回文数
 * 描述:
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 示例：
 * 输入：x = 121
 * 输出：true
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class isPalindrome9 {
    // 字符串
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while(left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        if(left >= right) return true;
        return false;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(new isPalindrome9().isPalindrome(x));
    }
}
