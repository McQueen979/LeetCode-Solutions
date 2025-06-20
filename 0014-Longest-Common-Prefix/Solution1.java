class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 处理特殊情况：数组为空或长度为0
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 以第一个字符串作为初始公共前缀
        String prefix = strs[0];

        // 从第二个字符串开始依次比较
        for (int i = 1; i < strs.length; i++) {
            // 调用辅助方法更新公共前缀
            prefix = findCommonPrefix(prefix, strs[i]);
            // 如果公共前缀为空，提前结束比较
            if (prefix.isEmpty()) {
                break;
            }
        }

        return prefix;
    }

    // 辅助方法：查找两个字符串的公共前缀
    private String findCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int index = 0;

        // 逐个字符比较，直到找到不匹配的字符或遍历完较短的字符串
        while (index < minLength && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }

        // 返回公共前缀子串
        return str1.substring(0, index);
    }
}