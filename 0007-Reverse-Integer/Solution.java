class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            // 提取最后一位数字
            int digit = x % 10;
            x /= 10;

            // 检查反转后是否溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            // 构建反转后的数字
            result = result * 10 + digit;
        }

        return result;
    }
}