# WEEK03笔记

## 递归

树的代码为什么一般用递归：
	树本身用递归进行定义
	左右子树具有自相似性
	
递归模板

```
// Java
public void recur(int level, int param) { 
  // terminator  递归终止条件
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 这一层的逻辑代码
  process(level, param); 
  // drill down  下到下一层
  recur( level: level + 1, newParam); 
  // restore current status 恢复现场（不一定必须） 
 
}
```

思维要点： 

	1. 不要人肉进行递归（不要画递归树）
	2. 找最近重复子问题
	3. 数学归纳法思维
		n = 1、2成立
		若果n成立 n+1也成立
子问题mutual exclusive互斥，complete exhaustive子问题加一起就是所有问题

## 分治、回溯

碰到题目，找问题的重复性

	最优子结构：动态规划
	
	最近重复性：分治、回溯等
	
分治就是把问题分解为多个啥子问题的递归

分治=递归 + **子问题结果Merge**

回溯就是在递归的每一层进行试错：八皇后