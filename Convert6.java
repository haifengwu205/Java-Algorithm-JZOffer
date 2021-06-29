package JZOffer;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: Convert6
 * @Author: hp
 * @Date: 24/06/2021 09:50
 * @Version: 1.0
 * @Description: 6. Z 字形变换
 * 描述：
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Convert6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j + i < n; j += cycleLen) {
                str.append(s.charAt(j + i));
                if(i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    str.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(new Convert6().convert(str, numRows));
    }
}
