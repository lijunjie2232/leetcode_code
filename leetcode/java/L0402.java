package leetcode.java;

public class L0402 {
    public static String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        if (k == 0)
            return num;
        StringBuilder sb = new StringBuilder();
        int lpoint = 0;
        while (lpoint < num.length() && k > 0) {
            while (!sb.isEmpty() && sb.charAt(sb.length() - 1) > num.charAt(lpoint) && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(num.charAt(lpoint));
            lpoint++;
        }
        while (lpoint < num.length())
            sb.append(num.charAt(lpoint++));
        while (0 < k--)
            sb.deleteCharAt(sb.length() - 1);
        while (!sb.isEmpty() && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        if (sb.isEmpty())
            sb.append('0');
        return sb.toString();
    }

    public static void main(String[] args) {
        // String num = "1432219";
        // System.out.println(num.substring(0, 7));
        // System.out.println("10200".charAt(5));
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
        System.out.println(removeKdigits("1234567890", 9));
    }
}
