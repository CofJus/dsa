package string.substring;

import java.util.Scanner;

/**
 * 最大子串
 * @author Ji Rui
 * @date 2020/8/24 15:19
 */
public class MaxSubString {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String s1 = cin.nextLine();
            String s2 = cin.nextLine();
            String max = s1.length() >= s2.length() ? s1 : s2;
            String min = s1.length() >= s2.length() ? s2 : s1;
            int l = 0;
            String s = "";
            for (int i = 0; i < min.length(); i++) {
                for (int j = i + 1; j <= min.length(); j++) {
                    if (max.contains(min.substring(i, j)) && j - i > l) {
                        l = j - i;
                        s = min.substring(i, j);
                    }
                }
            }
            System.out.println(s);
        }
    }
}

