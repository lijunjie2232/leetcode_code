package leetcode.java;

import java.util.*;

public class L0224Prio {
    public static Integer singlecalc(Character op, Integer a, Integer b) {
        switch (op) {
            case '/':
                return a / b;
            case '*':
                return a * b;
            case '+':
                return a + b;
            case '-':
                return a - b;
        }
        System.out.println("op error");
        return 0;
    }

    public static int calculate(String s) {
        Stack<Integer> vars = new Stack<>();
        Stack<Character> signal = new Stack<>();
        StringBuffer number = new StringBuffer();
        Map<Character, Integer> isp = new HashMap<>();
        Map<Character, Integer> icp = new HashMap<>();
        boolean lastNumber = false;
        isp.put('(', 1);
        isp.put('*', 5);
        isp.put('/', 5);
        isp.put('-', 3);
        isp.put('+', 3);
        isp.put(')', 6);

        icp.put('(', 6);
        icp.put('*', 4);
        icp.put('/', 4);
        icp.put('-', 2);
        icp.put('+', 2);
        icp.put(')', 1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ')
                continue;
            else if (c > '9' || c < '0') {
                if (!number.isEmpty()) {
                    // System.out.println("number" + number);
                    vars.add(Integer.valueOf(number.toString()));
                    // x = 1;
                    number = new StringBuffer();
                    lastNumber = true;
                } else if (!lastNumber && c == '-') {
                    // x = -1;
                    // if (!vars.empty())
                    // signal.add('+');
                    // chars[i] = '*';
                    // i--;
                    signal.add('*');
                    vars.add(-1);
                    continue;
                } else if (!lastNumber && c == '+') {
                    continue;
                }
                while (!signal.empty() && isp.get(signal.peek()) > icp.get(c)) {
                    Integer b = vars.pop(), a = vars.pop();
                    vars.add(singlecalc(signal.pop(), a, b));
                }
                if (!signal.empty() && isp.get(c) == icp.get(signal.peek())) {
                    signal.pop();
                    // if (!lastNumber) {
                    // vars.add(vars.pop() * x);
                    // x = 1;
                    // }
                } else
                    signal.add(c);
                if (c != ')')
                    lastNumber = false;
            } else
                number.append(c);
        }
        if (!number.isEmpty()) {
            // System.out.println("number" + number);
            vars.add(Integer.valueOf(number.toString()));
            // x = 1;
            number = new StringBuffer();
        }
        while (!signal.empty()) {
            Integer b = vars.pop(), a = vars.pop();
            vars.add(singlecalc(signal.pop(), a, b));
        }

        return vars.peek();
    }

    public static void main(String[] args) {
        System.out.println(calculate("1+2"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("10*2"));
        System.out.println(calculate("4/2"));
        System.out.println(calculate("(1+5)/3*((5*9)-10)"));
        System.out.println(calculate("1*( -2)"));
        System.out.println(calculate("1*( +2)"));
        System.out.println("*****************************");
        System.out.println(calculate("1 + 1"));// 2
        System.out.println(calculate(" 2-1 + 2 "));// 3
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));// 23
        System.out.println(calculate("1-(     -2)"));// 3
        System.out.println(calculate("-2+ 1"));// -1
        System.out.println(calculate("-1"));// -1
        System.out.println(calculate("- (3 + (4 + 5))"));// -12

    }
}
