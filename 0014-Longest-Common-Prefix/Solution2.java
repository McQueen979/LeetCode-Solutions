class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // 取第一个字符串作为长度基准
        int firstLen = strs[0].length();
        int strsLen = strs.length;

        // 纵向扫描每个字符位置
        for (int i = 0; i < firstLen; i++) {
            char c = strs[0].charAt(i);

            // 检查所有字符串的i位置字符是否相同
            for (int j = 1; j < strsLen; j++) {
                // 当前字符串长度不足或字符不匹配
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        // 第一个字符串是所有字符串的前缀
        return strs[0];
    }
}