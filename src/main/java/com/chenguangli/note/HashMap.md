1.7和1.8的区别


1.jdk1.8会将链表转换为红黑树
2.新节点插入链表的顺序不相同(jdk1.7是插入头结点，1.8因为要遍历链表把链表转换为红黑树所以采用插入到尾结点)
3.hash算法的简化
4.resize逻辑修改(1.7会出现死循环, 1.8不会)
5.hash冲突的解决办法 开放地址法(发生冲突，继续寻找下一块未被占用的存储地址)、再散列函数法、链地址法
6.1.7使用头插法，1.8尾插法
7.HashMap的数组大小是2的n次幂的原因
    在获取存储下标时使用了 hash & (length-1)
    默认长度为16和规定数组长度为2的幂,是为了降低hash碰撞的几率。

8.1.7 put方法先扩容后插入新值 1.8先插入新值后扩容
9.hashMap在多线程环境下的问题：
    put时如果发生扩容也就是reHash，这个过程会将原数组的内容重新hash到新的扩容数组中，存在put同一个hash值相同的元素，会出现链表的闭环，导致get时出现死循环
    put时还会出现元素丢失的情况