## Linux


### 查看文件
cat a.txt          //查看文件最后一屏内容
less a.txt         //PgUp向上翻页，PgDn向下翻页，"q"退出查看
more a.txt         //显示百分比，回车查看下一行，空格查看下一页，"q"退出查看
tail -100 a.txt    //查看文件的后100行，"Ctrl+C"退出查看


### 修改文件权限
chmod 777 a.txt


### 查看进程
ps -ef         //查看所有正在运行的进程


### grep
grep -i "the" demo_file              //在文件中查找字符串(不区分大小写)
grep -A 3 -i "example" demo_text     //输出成功匹配的行，以及该行之后的三行
grep -r "ramesh" *                   //在一个文件夹中递归查询包含指定字符串的文件


