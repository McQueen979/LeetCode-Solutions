class Solution {
    public boolean isValid(String s) {
        // 边界情况处理
        if (s == null || s.length() == 0) {
            return true;
        }
        
        // 长度为奇数时肯定不匹配
        if (s.length() % 2 != 0) {
            return false;
        }
        
        // 使用栈存储左括号
        Stack<Character> stack = new Stack<>();
        
        // 遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 左括号直接入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // 右括号需要检查匹配情况
            else {
                // 栈为空时，说明没有对应的左括号
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // 检查是否匹配
                if ((c == ')' && top != '(') || 
                    (c == ']' && top != '[') || 
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        // 最终栈必须为空才说明完全匹配
        return stack.isEmpty();
    }
}
