## 基础概念


### Spark的RDD是由 类型 + 数据 组成
那么 json 格式的类型 映射到 RDD中是以什么类型存储的


### Spark RDD中的常用算子 转换算子和行动算子


### Spark Shuffle 算子
去重: distinct
排序: groupByKey，reduceByKey等
重分区: repartition，coalesce
集合或者表操作: interection，join


### Spark 中的 cache / persist / checkpoint 应该在什么时候使用



### Spark的一个运行架构 Job -> Stage -> Task 的关系


### Spark UDF / UDAF 有写过吗?



### Spark中的广播变量和累加器
Spark广播变量
如果Executor端需要访问Driver端的某个变量，spark会向Executor端每个task都发送一个此变量的副本。如果此变量很大，就会占用大量的Executor节点的内存。
利用广播变量，spark只会给一个Executor节点发送一个变量。

Spark累加器的作用
累加器对信息进行聚合。向Spark传递函数时，通常可以使用Driver端定义的变量，但是在Executor端使用此变量时，每个task中使用的都是此变量的副本。如果变量的值发生了变化，Driver端的变量值却不会改变。



### Spark参数调优
基本数据类型是直接存储值, 而引用数据类型是存储指向对象的引用(地址值)
类、接口(List, Set, Map)、数组



### Spark SQL调优
Spark SQL的谓词下推


### Spark 数据倾斜问题 产生的原因以及解决方案



