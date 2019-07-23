package medium;

import java.util.Random;

public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        String temp = null;
        StringBuilder intermediate = new StringBuilder();
        String output = "0";
        if (num1.length() > num2.length()) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int times = 0;
        int index = num1.length() - 1;
        int count = 0;
        while (index >= 0) {
            times = num1.charAt(index) - '0';
            intermediate.append(multiply(times, num2));
            for (int i = 0; i < count; i++) {
                intermediate.append('0');
            }
            output = add(output, intermediate.toString());
            intermediate = new StringBuilder();
            count++;
            index--;
        }
        return output;
    }

    public String multiply(int times, String num) {
        String output = "0";
        while (times-- > 0) {
            output = add(output, num);
        }
        return output;
    }

    public String add(String num1, String num2) {
        StringBuilder output = new StringBuilder();
        int forward = 0;
        int sum = 0;
        int i = 1;
        for (; i <= num1.length() && i <= num2.length(); i++) {
            char digit = '0';
            sum = (num1.charAt(num1.length() - i) - '0') + (num2.charAt(num2.length() - i) - '0') + forward;
            forward = 0;
            if (sum >= 10) {
                forward = 1;
                sum -= 10;
            }
            output.insert(0, (char) (digit + sum));
        }
        if (num2.length() >= i) {
            num1 = num2;
        }
        while (i <= num1.length()) {
            sum = forward + num1.charAt(num1.length() - i) - '0';
            forward = 0;
            if (sum >= 10) {
                forward = 1;
                sum -= 10;
            }
            output.insert(0, (char) (sum + '0'));
            i++;
        }
        if (forward == 1) {
            output.insert(0, 1);
        }

        return output.toString();
    }

    public static void main(String[] args) {
        _43_MultiplyStrings s = new _43_MultiplyStrings();
        Random random = new Random();
        while (true) {
            int a = random.nextInt(210);
            int b = random.nextInt(99);
            a = 53;
            b = 68;
            String num1 = String.valueOf(a);
            String num2 = String.valueOf(b);
            if (!String.valueOf(a * b).equals(s.multiply(num1, num2))) {
                System.out.println("" + a + " " + b);
                System.out.println(s.multiply(num1, num2));
                System.out.println(a * b);

                break;
            }
        }

    }
}
