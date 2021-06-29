package JZOffer;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: IntToRoman12
 * @Author: hp
 * @Date: 27/06/2021 19:50
 * @Version: 1.0
 * @Description:
 */
public class IntToRoman12 {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] index = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                ans.append(index[i]);
            }
            if(num == 0) break;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int x = 80;
        System.out.println(new IntToRoman12().intToRoman(x));
    }
}
