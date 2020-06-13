# 算法训练营第一周笔记

## git
1. github远端仓库（新建或克隆）
2. git本地目录。git init。工作区 git add . ; 
	暂存区 git commit -m "xxx"
	版本区
3.  git log；git status 
4.  RSA公钥
5.  git push推送到远端

##   学习方法
1. 三分看视频，7分靠练习
2. 五毒神掌。看高票答案（英文站题解），一道题做5遍。死记硬背解题模板
3. 不要死磕AC

## 时间复杂度和空间复杂度
1. 不建议看公式证明，直接读程序判断
2. BigO notation .O(1).O(logn).O(n).O(n^2).O(n^3).O(2^n).O(n!)
3. 递归程序的时间复杂度 递归树
4. 主定理 记住四种情形

```
二分查找T(n) = T(n/2) + O(1) -->O(logn)
二叉树的遍历T(n) = 2T(n/2) + O(1) -->O(n)
有序的二维矩阵进行查找T(n) = 2T(n/2) + O(nogn) -->O(n)
归并排序T(n) = 2T(n/2) + O(n) -->O(nlogn)
```
空间复杂度
数组O(n).递归的深度

## 数组、链表、跳表
第一周的数据结构学习了数组、链表和跳表。

数组：内存管理器，内存地址，访问时间O(1)；插入O(n)、删除O(n) 内存拷贝(System.arraycopy)

链表：插入节点O(1);删除O(1);访问时间O(n).Java Linklist 双向链表

链表插入删除的操作

跳表：升维方法，针对有序的链表，插入/删除/查询都是O(logn)

学习了一些基本解题框架比如双指针法、索引法、哈希表等等

## 栈与队列

查 API ：java 8 stack。class。工程上直接用双端队列（头尾都可pop push）
java 8 queue 接口 队列
java 8 deque 接口（有很多实现方式） 双端队列

作业：改写PPT deque 代码

```
Deque<String> deque = new LinkedList<String>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.getFirst();
System.out.println(str);
System.out.println(deque);

while (!deque.isEmpty()) {
	System.out.println(deque.removeFirst());
}
System.out.println(deque);
```

## queue源码分析，队列是接口，可以用LinkedList实现

### 插入，尾插法，时间复杂度为O(1)

```
public void addFirst(E e) {
        linkFirst(e);
 }
 private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
 }
```
### 删除  O(1)

```
public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
}
private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
        return element;
}
```
### lookup O(n)

## PriorityQueue，也叫优先队列，是一个通过完全二叉树实现的小顶堆。其作用是每次以O(1)取出队列中权值最小的元素,再以O(logn)维护队列

```
//插入操作 O(logn)
public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
}
//删除操作 O(logn)
private E removeAt(int i) {
        // assert i >= 0 && i < size;
        modCount++;
        int s = --size;
        if (s == i) // removed last element
            queue[i] = null;
        else {
            E moved = (E) queue[s];
            queue[s] = null;
            siftDown(i, moved);
            if (queue[i] == moved) {
                siftUp(i, moved);
                if (queue[i] != moved)
                    return moved;
            }
        }
        return null;
 }
 // 查询（一般是查队首元素（最高优先级）） O(1)
 public E peek() {
        return (size == 0) ? null : (E) queue[0];
 }
```

