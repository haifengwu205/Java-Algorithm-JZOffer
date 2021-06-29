package JZOffer;

import java.util.HashMap;

/**
 * @ProjectName: project
 * @Package: JZOffer
 * @ClassName: RomanToInt13
 * @Author: hp
 * @Date: 27/06/2021 20:24
 * @Version: 1.0
 * @Description:
 */
public class RomanToInt13 {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i +2))) {
                ans += map.get(s.substring(i, i + 2));
                i++;
            } else {
                ans += map.get(s.substring(i, i+1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(new RomanToInt13().romanToInt(s));
    }
}
