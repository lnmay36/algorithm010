# WEEK04笔记

## 暴力搜索

	遍历所有的点，保证每个点只访问且仅访问一次
	深度优先搜索
	广度优先搜索
	
```
visited = set() 
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 
	visited.add(node) 
	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```
```
# Python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 
	while queue: 
		node = queue.pop() 
		visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
	# other processing work 
	...
```

## 贪心算法
	是每一步都考虑最优解法，从而希望得到最终的最有结果
	贪心算法每一步都不能回退，而动态规划会保存当前运算结果，可以回退
	鼠目寸光，只顾眼前
	贪心：当下做局部最优判断
	回溯：能够回退
	递归：最优判断+回退
	应用：最小生成树，哈夫曼编码。工程中一般用贪心算法得不到最优结果
	贪心算法比较高效，得到的结果比较接近最优解，可以用作辅助算法，或者解决队结果没有精确要求的问题。
	贪心策略：局部贪心；从后往前贪心
	
贪心法例子 coin change 题目
	
	用所给的硬币组成目标值，要求硬币数量最少
	特殊情况：所给的硬币呈整除关系，这种情况下每次选能够匹配的最大值，结果最优。比如：20 10 5 1匹配 36。结果20+10+5+1
	但是硬币如果非整除关系，结果就不是最优。如10 9 1匹配18.结果1个10，8个1
	
## 二分查找
	前提：有序；有上下界；数组（可索引访问）
	
二分查找模版（记熟）

	# Python
	left, right = 0, len(array) - 1 
	while left <= right: 
		  mid = (left + right) / 2 
		  if array[mid] == target: 
			    # find the target!! 
			    break or return result 
		  elif array[mid] < target: 
			    left = mid + 1 
		  else: 
			    right = mid - 1
	