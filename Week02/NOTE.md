# WEEK02笔记
## 哈希表
哈希表根据关键码-值（key value）而直接访问的数据结构，通过将关键码值映射到表中的一个位置来访问记录，时间复杂度为O(1)，这个映射函数叫散列函数（Hash Function）。设计散列函数目的是尽可能减少哈希碰撞，对于不同的数据，得到相同的值。解决哈希冲突方法，拉链法

Java HashMap的应用

```
Map<T> m = new HashMap<> ();
m.put(key, value);
m.get(key);
m.containsKey(key);
m.size()
m.isEmpty()
m.clear()
```

## 四步做题法

1. clarification 和面试官确认题目意思（边界条件，大小写是否敏感等）
2. possible solution（暴力法）optimal(time & space)
3. code
4. test cases

## 二叉树

树是特殊化的链表（升维，2个next指针）

图是特殊化的树（有环）

树状结构 状态空间 棋类 alphago

二叉树的遍历（递归）前序 中序 后序

## 二叉搜索树

改进二叉树遍历的复杂度O(n)，节点有序，中序遍历-升序

可视化visualgo.net

查询/插入/删除 logn

删除:
	叶子结点直接删除
	子树的根节点，找和他最接近的节点来垫背，取第一个大于子树根节点的节点来垫背（右子树最小的节点）
	
退化为链表->O(n)

## 堆

用处：快速找到最大值或最小值（优先级） O(1)

大/小顶堆

实现：二叉堆（binary) 斐波那契堆 等等

API（大顶堆）：find-max(O(1))

delete-max(O(logn))

insert(O(logn)/斐波那契堆O(1))

二叉堆：实现容易，时间复杂度高，完全二叉树实现

	1. 完全树
	2. 树中任意节点的值总是>=子节点的值 ：根节点是最大节点
	
实现：**数组** 根节点下标：0

i节点的左儿子2\*i+1，右儿子2*i+2，父节点floor((i-1)/2)

二叉堆的维护操作：向上调整(HeapifyUp)

插入（Insert）：

	1. 新元素插入堆堆尾部
	2. 向上调整直到根

删除堆顶元素：

	1. 将堆顶元素和最后的元素对调
	2. size--
	3. 向下调整堆顶元素（HeapifyDown），一直到堆尾

HeapifyUP

```
while(i!=root)
	如果当前节点大于父亲节点，将当前节点与父亲节点元素交换，i=floor((i-1)/2)
```

HeapifyDown

```
while(i的儿子!=size-1)
	将当前节点与较大的儿子节点元素j交换，i=j
```

Java API：**PriorityQueue**



