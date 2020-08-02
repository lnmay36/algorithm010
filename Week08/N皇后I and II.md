## N皇后

```
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        result = []
        self.dfs(result, [], [], [], n)

        return [ ['.'*i + 'Q' + '.'*(n-i-1) for i in r] for r in result ]

    def dfs(self, result, queens, pie, na, n):
        # queens:每一行放的皇后的坐标
        # pie :撇攻击线坐标
        # na :捺攻击线坐标

        p = len(queens) #没加入一个皇后，len(queens)增加1，相当于枚举每一列

        if p==n:
            result.append(queens)
            return

        for q in range(n):#枚举每一行
            if q not in queens and p-q not in pie and p+q not in na:
                self.dfs(result, queens + [q], pie + [p-q], na + [p+q], n)
```

## N皇后II

```
class Solution(object):
    def totalNQueens(self, n):
        self.result = 0
        self.dfs(n, 0, 0, 0, 0)#用int的二进制位取代数组，至少有32位
        return self.result
        
    def dfs(self, n, row, col, pie, na):#n皇后，行，列，撇，捺

        if row>=n:#枚举行数超过n，出现一个结果
            self.result += 1
            return

        bits = (~(col | pie | na)) & ((1 << n) - 1) #得到当前所有空位
        #col | pie | na 得到当前所有的占位
        #(1 << n) - 1 n皇后只需n位，将0~n-1位与全1相与，得到0～n-1位

        while bits:#枚举当前所有空位
            p = bits&-bits #取得最低位的1
            bits = bits&(bits - 1) # 清零最低位的1，放了一个皇后
            self.dfs(n, row+1, col|p, (pie|p )<< 1, (na|p) >> 1) #撇左移一位 捺右移一位
            # col pie na是int，当前状态下没有被改变，无需revert
```