package JavaOb.JZOffer;

/**
 * @ProjectName: IDEACode
 * @Package: JavaOb.JZOffer
 * @ClassName: ReplaceSpace5
 * @Author: hp
 * @Date: 29/06/2021 16:08
 * @Version: 1.0
 * @Description: 剑指 Offer 05. 替换空格
 * 描述：
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 */
public class ReplaceSpace5 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append('%');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(new ReplaceSpace5().replaceSpace(s));
    }
}
