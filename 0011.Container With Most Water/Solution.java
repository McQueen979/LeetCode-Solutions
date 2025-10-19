class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int t = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, t);
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
//Math.min(double a, double b) 和 Math.max(double a, double b)
/* Math.min 是 Java 中的一个内置方法，用于比较两个数值并返回其中较小的一个。
功能说明
        作用：返回两个参数中的最小值
        语法：Math.min(double a, double b)
        参数类型：支持多种数值类型（int, double, float, long等）
        返回值：两个参数中较小的那个数

在第6行 Math.min(height[l], height[r]) 中：
    比较左指针 l 和右指针 r 所指向的高度值
    返回两者中的较小值
    这个较小值决定了当前容器能够盛水的最大高度（木桶效应）
    配合宽度 (r - l) 计算出当前容器的面积
    这是解决"盛最多水的容器"问题的关键步骤，确保容器的盛水量由较短的那条边决定。
 */
//关键步骤！！！
/*
    if (height[l] < height[r])
    当左侧高度小于右侧时，左指针右移（++l）。否则右指针左移（--r）
    也就是说要保留更高的那个！！！
* */