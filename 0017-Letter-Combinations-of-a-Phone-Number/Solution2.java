class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result;
    private char[] current;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        int n = digits.length();
        if (n == 0) return result;

        current = new char[n]; // 预先分配固定长度字符数组
        backtrack(digits, 0);
        return result;
    }

    private void backtrack(String digits, int index) {
        if (index == digits.length()) {
            result.add(new String(current)); // 直接转换字符数组为字符串
            return;
        }

        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current[index] = c; // 直接填充字符数组
            backtrack(digits, index + 1);
        }
    }
}