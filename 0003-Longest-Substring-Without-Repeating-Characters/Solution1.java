import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        Map<Character, Integer> charMap = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            // 如果字符已存在且上次出现位置在当前左指针之后，更新左指针
            if (charMap.containsKey(c) && charMap.get(c) >= left) {
                left = charMap.get(c) + 1;
            }
            // 更新字符的最新位置
            charMap.put(c, right);
            // 计算当前窗口长度并更新最大长度
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}