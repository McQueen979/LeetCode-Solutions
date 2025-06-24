
class Solution {
    public boolean isValid(String s) {
        // 处理空字符串或长度为0的情况
        if (s == null || s.length() == 0) {
            return true;
        }
        
        // 长度为奇数时直接不匹配
        if (s.length() % 2 != 0) {
            return false;
        }
        
        // 定义括号映射关系（右括号 -> 左括号）
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');
        
        // 使用栈存储左括号
        Stack<Character> stack = new Stack<>();
        
        // 遍历字符串每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 若为右括号，检查匹配关系
            if (bracketMap.containsKey(c)) {
                // 栈为空或栈顶左括号不匹配时返回false
                if (stack.isEmpty() || stack.pop() != bracketMap.get(c)) {
                    return false;
                }
            } 
            // 若为左括号，直接入栈
            else {
                stack.push(c);
            }
        }
        
        // 最终栈必须为空才说明完全匹配
        return stack.isEmpty();
    }
}
