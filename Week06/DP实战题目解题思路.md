# DP实战题目解题思路
## Fibonacci数列
### 傻递归，时间复杂度2^n

	int fib (int n) {
		if (n <=0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
	
### 带有缓存的递归，O(n)所有数据从数组中取
	int fib (int n, int[] memo) {
		// 递归终止条件
		if (n <=1) {
			return n;
		} 
		
		if (memo[n]==0){
			memo[n] = fib(n-1) + fib(n-2);
		}
		
		return memo[n];
	}
	
### Bottom Up自底向上
	int fib (int n, int[] memo) {
		int[] res = new int[n];
		res[0] = 0;
		res[1] = 1;
		for (int i=2;i<n;++i) {
			res[i] = res(i-1) + res(i-2);
		}
		
		return res[n-1];
	}
	
## 63不同路径II

人可以往右(A)或者往下(B)走，递推公式path(start, end) = path(A, end) + path(B, end)，如果能到达目的地，则返回1；如果遇到障碍物，则返回0

	int countPaths(boolean[][] grid, int row, int col) {
		if (!validSquare(grid, row, col))
			return 0;
		if (isAtEnd(grid, row, col))
			return 1;
		return countPaths(grid, row+1, col) + countPaths(grid, row, col+1);
	} 
	
递推公式path[m][n] = path[m-1][n] + path[m][n-1]

	//bottom up
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m==0)
            return 0;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];//java默认初始化值就是0，所以不用管障碍物处的值

        for (int i=0;i<m&&obstacleGrid[i][0]==0;++i) {
            path[i][0] = 1;
        }
        for (int i=0;i<n&&obstacleGrid[0][i]==0;++i) {
            path[0][i] =  1;
        }

        for (int i=1;i<m;++i) {
            for (int j=1;j<n;++j) {
                if (obstacleGrid[i][j]==0)
                    path[i][j] = path[i-1][j] + path[i][j-1];
                // else
                //     path[i][j] = 0;//有障碍物不用管，因为数组初始化默认值就是0
            }
        }
        return path[m-1][n-1];
    }
    
## 120. 三角形最小路径和

从2开始走，要找到最短路径，要从下一层3、4中的较小者继续走。

将三角形的第一列改成竖直线->直角三角形，可以很方便地看出状态转移方程：

f(i,j) = min(f(i+1, j) ,f(i+1, j+1)) + a[i][j]

	def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        for i in range(len(triangle)-2,-1,-1):#第二个参数是stop计数停止，不包括-1这个下标，即到0
            for j in range(0,len(triangle[i])):
                triangle[i][j] = min(triangle[i+1][j], triangle[i+1][j+1]) + triangle[i][j]
        return triangle[0][0]

## 1143. 最长公共子序列
**递归版本（超时）**
	
	if (text1=="" or text2==""):
            return 0
      if (text1[-1]==text2[-1]):
      		return 1 + lcs(text1[:-1],text2[:-1])
      else:
      		return max(lcs(text1[:-1], text2), lcs(text1, text2[:-1]))
**动态规划版本**

	public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;++i) {
            for (int j=1;j<=n;++j) {
                if (text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
## 53. 最大子序和

* subproblems: max_sum(i) = max( max_sum(i-1), 0 ) + a[i]
* 状态数组：f[i]
* 状态方程：f[i] = max(f[i-1], 0) + a[i]

## 322. 零钱兑换

画状态树理解？

* subproblems：
* 状态数组：dp[i]
* 状态方程：dp[i] = min(dp[i], dp[i - coin] + 1)

## 198. 打家劫舍

2种情况：

上一次没偷nums[i-1]，那么这一次可以偷nums[i]；否则不偷nums[i]

状态方程：
	a[i] = max(a[i-2]+nums[i], a[i-1])

	a[0] = nums[0]
	a[1] = max(nums[0], nums[1])
	
	for i in range(2, len(nums)):
	    a[i] = max(a[i-2]+nums[i], a[i-1])
