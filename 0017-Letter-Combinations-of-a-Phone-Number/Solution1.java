class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result;
    private char[] path;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        int n = digits.length();
        if (n == 0) return result;

        path = new char[n];
        backtrack(digits, 0);
        return result;
    }

    private void backtrack(String digits, int index) {
        if (index == digits.length()) {
            result.add(new String(path));
            return;
        }

        // 直接通过字符运算获取字母范围，避免toCharArray()
        String letters = KEYS[digits.charAt(index) - '0'];
        int len = letters.length();
        for (int i = 0; i < len; i++) {
            path[index] = letters.charAt(i);
            backtrack(digits, index + 1);
        }
    }
}