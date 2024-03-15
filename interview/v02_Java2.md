## 基础概念

### 引用数据类型有哪些, 这些引用数据类型和基本数据类型的区别
类、接口(List, Set, Map)、数组


### String字符串, 正则匹配操作的一些相关类
Pattern / Matcher


### 写几行代码, 把当前时间以 日月年 时分秒的格式打印出来
```java

```


### 重载和重写的区别
1. 重载: 发生在同一个类中, 方法名必须相同, 参数类型不同, 个数不同, 顺序不同, 方法返回值和访问修饰符可以不同, 发生在编译时
2. 重写: 发生在父子类中, 方法名, 参数列表必须相同, 返回值范围 <= 父类, 抛出异常范围 <= 父类, 访问修饰符范围 >= 父类, 如果父类方法是private的, 则子类不能重写该方法.


### 抽象类和接口的区别
1. a
2. b


### 子类可以继承父类的哪些内容
1. 公有属性和公有方法
2. 构造方法可以通过super()调用


### 在Java中, 为什么不允许从静态方法中访问非静态变量
1. 静态变量属于类本身，在类加载的时候就会分配内存，可以通过类名直接访问；
2. 非静态变量属于类的对象，只有在类的对象产生时，才会分配内存，通过类的实例去访问；
3. 静态方法也属于类本身，但是此时没有类的实例，内存中没有非静态变量，所以无法调用。


### 简述一下JDBC连接的步骤
1、加载JDBC驱动程序
2、创建数据库的连接
3、创建一个 Statement (静态SQL) / PreparedStatement (动态SQL) / CallableStatement (数据库存储过程)
4、执行SQL语句 executeQuery() 执行查询, 返回ResultSet / executeUpdate() 执行 INSERT、UPDATE、DELETE / execute()
5、遍历结果集 rs.next()
6、处理异常，关闭JDBC对象资源









```Java
// ArrayList 和 LinkedList 的区别是什么 ? 
1. ArrayList是动态数组的数据结构实现，查找和遍历的效率较高；
2. LinkedList是双向链表的数据结构，增加和删除的效率较高；
    


```











- 假设一个List集合, 要存 int 类型的数字, 使用什么泛型

  ```Java
  List<Integer> list = new ArrayList<>(5, 13, 50, 60);
  
  // 2. stream流
  int sum1 = list.stream().mapToInt(i -> i).sum();
  
  ```



- 假设我们在A方法中 new 了一个 List, 这个List中有3个元素, 然后我们把List的对象, 传到B方法中, 在B方法中再添加一个元素.
- 请问, 现在A方法中的List, 里面是3个元素还是4个元素, 为什么 ?



- Key - Value 格式的数据用什么数据类型存储
- 如果是 A - B - C 格式的数据用什么数据类型来存储



```Java
// 集合概念性问题

// List和Set的相同点和不同点
1. List, Set都是继承自Collection接口
2. List特点：元素有放入顺序，元素可重复 ，Set特点：元素无放入顺序，元素不可重复，重复元素会覆盖掉，

// Map的遍历方式
// 第一种方法，foreach keySet
for (Integer key : testMap.keySet())

// 第二种方法，foreach values
for (String value : testMap.values())

// 第三种方法，foreach entrySet
for (Map.Entry<Integer, String> entry : testMap.entrySet()) {
    System.out.print(entry.getKey() + "-" + entry.getValue() + "\t");
}

// 第四种方法，entrySet iterator
Iterator<Map.Entry<Integer, String>> it = testMap.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry<Integer, String> entry = it.next();
    System.out.print(entry.getKey() + "-" + entry.getValue() + "\t");
}

// 第五种方法，Map的forEach方法，Java8独有
testMap.forEach((key, value) -> {
    System.out.print(key + "-" + value + "\t");
});




// 在遍历List的时候可以进行 add() remove() 操作嘛? 为什么

// 删除List中的某个或者某些元素, 有哪些方法 ? 
1. list.remove()
2. iterator.remove()
3. for循环正序或者倒序, remove完之后, 移动下标回正


// 48.迭代器, 作用是获取和删除集合中的元素
// 普通的迭代器只能单向移动, 迭代器统一了对容器的访问方式。
// 除了普通的迭代器, 有没有用过别的迭代器, ListIterator


```



- 并发编程

  ```Java
  // 线程池有没有用过 ? 
  // 之前有过什么业务的并发
  
  // 创建线程池的几个核心参数, Java线程池的完整构造函数
  public ThreadPoolExecutor(
      int corePoolSize, // 线程池长期维持的最小线程数，即使线程处于Idle状态，也不会回收
      int maximumPoolSize, // 线程数的上限
      long keepAliveTime, // 线程最大生命周期
      TimeUnit unit, //时间单位
      BlockingQueue<Runnable> workQueue, //任务队列。当线程池中的线程都处于运行状态，而此时任务数量继续增加，则需要一个容器来容纳这些任务，这就是任务队列。
      ThreadFactory threadFactory, // 线程工厂。定义如何启动一个线程，可以设置线程名称，并且可以确认是否是后台线程等。
      RejectedExecutionHandler handler // 拒绝任务处理器。由于超出线程数量和队列容量而对继续增加的任务进行处理的程序。
  )
  
  ```



