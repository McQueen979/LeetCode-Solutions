class Solution {
    public String convert(String s, int numRows) {
        // 处理特殊情况
        if (numRows == 1 || s == null || s.length() <= 1) {
            return s;
        }

        // 创建二维数组存储Z字形排列的字符
        char[][] zigzag = new char[numRows][s.length()];
        // 初始化二维数组为特殊字符，方便后续判断
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                zigzag[i][j] = '\0';
            }
        }

        // 计算Z字形的周期
        int cycle = 2 * (numRows - 1);
        // 用于记录当前填充的字符位置
        int index = 0;

        // 遍历原字符串，按Z字形填充到二维数组
        for (int i = 0; i < s.length(); i++) {
            // 计算当前字符在Z字形中的行位置
            int row;
            if (i % cycle < numRows) {
                row = i % cycle;
            } else {
                row = cycle - i % cycle;
            }

            // 填充字符到对应位置
            zigzag[row][index++] = s.charAt(i);
        }

        // 从二维数组中按行读取字符，组成结果字符串
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (zigzag[i][j] != '\0') {
                    result.append(zigzag[i][j]);
                }
            }
        }

        return result.toString();
    }

}