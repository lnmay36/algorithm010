# WEEK07笔记
## 字典树 Trie

二叉树、二叉搜索树

前缀感应出整个单词，如谷歌输入“you”，浏览器联想到“youtube”

字典树的节点是每个单词的字母

字典树定义：

![](字典树定义.PNG)
蓝色是单词的频次

Trie的基本性质：

* 节点本身不存完整的单词
* 从根节点到某一节点，路径上的字符连接起来，为该节点对应的字符串
* 每个节点的所有子节点路径代表的字符都不相同

26叉树（255分叉）多叉树

空间复杂度很高

时间复杂度就是所查询的单词的字符个数

核心思想：

* 空间换时间
* 公共前缀提升查询效率

	比如you这个前缀的所有子树，按频次排序，可以放在you查询词的联想单词列表中

212. 单词搜索 II用 Tire 树方式实现的时间复杂度`O(k*m*m*4^k)`，如果在叶子结点处存储插入的单词，优化后的时间复杂度是`O(k*m*m)`

## 并查集

比较死板，记住模板

**应用场景**：组团配对问题，你和他是不是朋友，是不是在一个集合中，群合并

**基本操作**：

* makeSet(s): 建立一个新的并查集，其中包含s个单元素集合
* unionSet(x,y): 将元素x，y所在的集合合并，如果两个集合有交集则不合并
* find(x): 找到x所在集合的代表。可用于判断x，y是否属于同一个集合(find(x)==find(y))

并查集每个元素都有一个parent，指向自己，自己是自己的老大
![](初始化.PNG)
合并：parentA=find(x)，parentB=find(y), parentA.parent = parentB
![](合并.PNG)
路径压缩，将路径上所有元素的parent都指向A
![](路径压缩.PNG)

并查集模板

```
// Java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	//init
	public void UnionFind(int n) { 
		count = n; //独立集合个数
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	//找领头元素
	public int find(int p) { 
		int root = p;
		while (root != parent[root]) { //找到当前节点的老大
			root = parent[root]; //节点上移
		}
		while (p!=parent[p]) {
			int x = p;
			p = parent[p];//节点上移
			parent[x] = root;//路径压缩
		}
		return p; 
	}
	//合并
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

## 双向bfs

维护两个set，每次将节点加入较短的set，直到endset中找到结果






