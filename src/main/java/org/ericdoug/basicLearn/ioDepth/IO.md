#Java IO

##一、File文件对象

##二、IO流

###Ⅰ、概念

> 流：

 程序  与 文件/数组/网络连接/数据库，以程序为中心

###Ⅱ、IO流分类

 1.流向：输入流与输出流

 2.数据：
   字节流：二进制，可以一切文件 包括 存文本 doc 音频 视频等等

   字符流:文本文件，只能处理纯文本

 3.功能：

   节点：包裹源头
   处理：增强功能，提高性能

###Ⅲ、字符流与字节流

 1.字节流


> 输入流：
   InputStream()  FileInputStream()

    ---read(byte)

> 输出流：
   OutputStream()  FileOutputStream()

    ---write()

    ---flush()

    ---close()

 2.字符流

    输入流：Read()  FileReader()
    ---read(char)

    输出流:Write()  FileWriter()
    ---write()
    ---flush()
    ---close()
###Ⅳ、操作

 1.举例：搬家   --->读取文件

    1)关联房子   --->建立与文件联系
    2）选择搬家公司  --->选择对应流
    3）搬家         --->读取/写出
        a)卡车大小     --->数组大小
        b）运输        --->读取、写出
    4)打发over     --->释放资源

###Ⅴ、案例

a.读取文件

1.建立联系  File对象

2.选择流   文件输入流  InputStream   FileInputStream

3.操作  byte[] car = new byte[1024]
        read()
        输出
4.释放资源：关闭

b.写出文件

a.读取文件

1.建立联系  File对象  目的地

2.选择流   文件输入流  OutputStream   FileOutputStream

3.操作  byte[] car = new byte[1024]
        write() flush()
4.释放资源：关闭