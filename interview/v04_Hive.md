## 基础概念


### Hive 内部表 和 外部表 的区别
1. 内部表: 管理元数据和实际表的数据, drop的话删除全部数据
2. 外部表: 只管理元数据 (external), drop的话只删除元数据
   内部表和外部表的数据都是存放在HDFS中


### Hive中用过的函数
处理字符串: 
    cast()
    substr()
处理json:

时间函数: 
    to_timestamp()
    to_date()


### Hive中常用的开窗函数


### Hive中行转列和列转行的函数



