public class Solution {
    public String convert(String s, int numRows) {
        // 处理特殊情况
        if (numRows == 1 || s == null || s.length() <= 1) {
            return s;
        }

        // 创建StringBuilder数组，每个元素存储对应行的字符
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // 计算Z字形的周期
        int cycle = 2 * (numRows - 1);
        // 遍历原字符串，按Z字形将字符添加到对应行
        for (int i = 0; i < s.length(); i++) {
            // 计算当前字符在Z字形中的行位置
            int row;
            if (i % cycle < numRows) {
                row = i % cycle;
            } else {
                row = cycle - i % cycle;
            }

            // 将字符添加到对应行的StringBuilder中
            rows[row].append(s.charAt(i));
        }

        // 拼接所有行的字符串，生成结果
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

}