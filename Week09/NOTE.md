# WEEK09笔记

## 递归、分治、动态规划复习

函数自己调用自己，递归模板

分治就是分而治之，分治模板，例子：快速排序、归并排序

**感触：**

1. 人肉递归低效，很累
2. 找到最近、最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维

**本质：**寻找重复性，计算机指令集（for，while，递归）

状态树，重复子问题，fibonacci傻递归

**动态规划**：

* 将复杂的问题分解成一个个简单的子问题
* 分治+最优子结构
* 顺推形式：动态递推（自底向上）

**DP顺推模板：**

```
function DP():
	dp = [][] #(二维情况) 状态数组
	
	for i=1 .. M:
		for j=1 .. N:
			dp[i][j] = _Function( dp[i'][j']... ) #状态转移方程，难（简单加减，最值，k个状态最值）
			
	return dp[M][N]
```

##常见动态规划问题及状态方程：

爬楼梯：

	f(n) = f(n-1) + f(n-2), f(1) = 1, f(0) = 0
![](./爬楼梯问题各种解法.PNG)

不同路径：

	f(x, y) = f(x-1, y) + f(x, y-1)
![](./不同路径的动态规划解法.PNG)

不同路径2:

	if (A[x][y] == 0):
		f(x, y) = f(x-1, y) + f(x, y-1)

打家劫舍：
	定义dp[i]: max $ of robbing A[0 -> i]
	
	dp[i] = max(dp[i-2]+a[i], dp[i-1]) #因为不能连续地偷
![](./house_robbing解法.PNG)

最小路径和：

	dp[i][j]状态定义：minPath(A[1->i][1->j])
	边初始化：
	for j=1 .. n
		dp[0][j] += dp[0][j-1]
	for j=1 .. M
		dp[j][0] += dp[j-1][0]
	dp[i][j] = min(dp[i-1][j], dp[i][j-1] )+ A[i][j]
	
股票买卖：

一个方法团灭股票问题
![](./股票买卖问题.PNG)![](./股票买卖问题2.PNG)![](./股票买卖问题3.PNG)
[https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/)

## 高级动态规划

状态拥有更多维度（二维、三维、多维，甚至需要压缩），状态方程更加复杂

爬楼梯问题
	
	## 原始问题
	for (i=2; i < n; ++i)
		a[i] = a[i-1] + a[i-2]
	##可以上1，2，3级台阶
	for (i=3; i < n; ++i)
		a[i] = a[i-1] + a[i-2] + a[i-3]
	 ## 每次可以上x1 ... xm步
	 a[i][k] #i表示上到第几级台阶，k表示在第几步即最后一步通过x1 ... xm级台阶走上来的
	 for (i=2; i < n; ++i)
	 	for (j=0; j < m; ++j)
	 		for (k=0; k < m; ++k)
				a[i][ x[j] ] += a[ i- x[j] ][ x[k] ] 好像不对??
				
### 746. 使用最小花费爬楼梯

```
public int minCostClimbingStairs(int[] cost) {
    // dp[i] :爬到第i级台阶需要的体力花费
    // dp[i] = min(dp[i-1], dp[i-2] + a[i]) <-- 最后一层，如果是i-1层跳上来的，不用加上cost[m-1];
    // dp[i] = min(dp[i-1], dp[i-2]) + a[i] <-- 中间层，不管是i-1层还是i-2层跳上来的，都需要加上cost[i];
    int m = cost.length;
    int[] dp = new int[m];
    dp[0] = cost[0];
    dp[1] = cost[1];

    for (int i=2;i<m;i++) {
        if (i == m-1)
            dp[i] = Math.min(dp[i-1], dp[i-2] + cost[i]);
        else
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
    }
    return dp[m-1];
}
```
	 
### 72. 编辑距离

	w1 0...m
	w2 0..n
	dp[i][j]表示w1[0:i-1]和w2[0:j-1]子串的最小编辑距离
	
	w1 ...x (i)
	w2 ...x (j) w1,w2最后一位相同
	dp[i][j] = dp[i-1][j-1] 分治
	
	w1 ...x (i)
	w2 ...y (j) w1 w2最后一位不同
	dp[i][j] = min(
		dp[i-1][j-1] + 1, //替换
		dp[i-1][j] + 1, //w1删x（或者w2加x）
		dp[i][j-1] + 1 //w1加y （或者w2删y）
	)// +1表示编辑距离加了1次
	
	初始值
	w1 ""
	w2 "" -> dp[i][j] = 0
	
	w1 ""
	w2 abc -> dp[i][j] = w2的长度
