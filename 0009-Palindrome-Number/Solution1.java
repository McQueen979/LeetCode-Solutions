public class Solution {
    public boolean isPalindrome(int x) {
        // 负数不可能是回文数，以0结尾的非0数也不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        // 只反转后半部分数字，避免整数溢出
        while (x > reversedNumber) {
            reversedNumber = reversedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，reversedNumber会比x多一位，需要除以10
        return x == reversedNumber || x == reversedNumber / 10;
    }
}