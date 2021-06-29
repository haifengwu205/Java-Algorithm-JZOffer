package JZOffer;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: Fib10
 * @Author: hp
 * @Date: 23/06/2021 14:43
 * @Version: 1.0
 * @Description: 剑指 Offer 10- I. 斐波那契数列
 * 描述：
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例1：
 * 输入：n = 2
 * 输出：1
 * 示例2：
 * 输入：n = 5
 * 输出：5
 * 提示：
 * 0 <= n <= 100
 */
public class Fib10 {
    public int fib(int n) {
        if(n== 0 || n == 1) return n;
        int a = 1, b = 0;
        for(int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            a %= 1000000007;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 44;
        System.out.println(new Fib10().fib(n));
    }
}
