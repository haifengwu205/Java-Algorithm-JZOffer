package JZOffer;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: LongestCommonPrefix14
 * @Author: hp
 * @Date: 28/06/2021 09:37
 * @Version: 1.0
 * @Description: 14. 最长公共前缀
 * 描述：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefix14 {
    // 判断第i个字符是否相等
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 1) return strs[0];
        int i = 0;
        while (i <= 200) {
            for(int j = 1; j < strs.length; j++) {
                if(i < strs[0].length()) {
                    char str0 = strs[0].charAt(i);
                    if (i >= strs[j].length() || strs[j].charAt(i) != str0) {
                        return strs[0].substring(0, i);
                    }
                } else {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
        return "";
    }

    public static void main(String[] args) {
        // String[] strs = {"flower","flow","flight"};
        // String[] strs = {"dog","racecar","car"};
        //String[] strs = {"a", "a"};
        String[] strs = {"a"};
        System.out.println(new LongestCommonPrefix14().longestCommonPrefix(strs));
    }
}
