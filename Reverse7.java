package JZOffer;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: Reverse7
 * @Author: hp
 * @Date: 26/06/2021 17:02
 * @Version: 1.0
 * @Description:
 * 描述：
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例：
 * 输入：x = 123
 * 输出：321
 * 输入：x = -123
 * 输出：-321
 * 提示：
 * -231 <= x <= 231 - 1
 */
public class Reverse7 {
    public int reverse(int x) {
        int flag = 1;
        String s = String.valueOf(x);
        int sum = 0, temp = 1;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                flag = -1;
            } else {
                int cur = sum;
                int c = Integer.parseInt(String.valueOf(s.charAt(i))) * temp;
                sum += c;
                temp *= 10;
                // if(cur != 0 && sum % 10 != cur % 10) return 0;
                if(c != 0 && sum % c != cur) return 0;
            }
        }
        return flag * sum;
    }

    public static void main(String[] args) {
        // int x = 1563847412;
        int x = -2147483412;
        System.out.println(new Reverse7().reverse(x));
    }
}
