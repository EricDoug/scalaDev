This chapter about basic type and operation
5.1 基本类型
interal type
--Int,Long,Short,Byte,Float,Double,Char,Boolean.
numeric type
--Float,Double
除了String归于java.lang包之外，其余所有的基本类型都是包scala的成员。如，Int的全名是scala.Int。然而，由于包scala和java.lang的所有成员都被每个scala源文件自动引用，因此可以在任何地方只用简化名。
5.2 字面量
a.整数字面量
十进制
val dec1 = 31
十六进制
val hex1 = ox5
八进制
val oct = 035
Long类型
val tower = 35L
Short类型
val little:Short = 367
Byte类型
val littler : Byte = 38

b.浮点数字面量
Double类型
val big = 1.2345
val bigger = 1.2345e1
val biggerStill = 123E45
Float类型
val little = 1.2345F
val littleBigger = 3e5f

c.字符字面量
val a = 'A'
val c = '\101'
val f = '\u0044'

d.字符串字面量
val hello = "hello"
println("|Welcome to Ultamix 3000.
          |Type "Help" for help.".stripMargin)

e.符号字面量

f.布尔型字面量
val bool = true

5.3 操作符和方法
val s = "Hello,world!"
s indexOf 'o'
s indexOf ('o',5)
任何方法都可以是操作符
一元（unary）操作符：前缀和后缀操作符

5.4 数学运算
+ - * / %

5.5 关系和逻辑操作
a.关系方法
> < >= <= !
b.逻辑方法
&&  ||  (注意短路机制)
5.6 位操作符
与&  或|  异或^  取反~
移位方法
左移<<  右移>>  无符号右移>>>
-1 >> 31
-1 >>> 31
1 << 2

5.7 对象相等
scala的"=="，首先，检测左侧是否为null，如果不是，调用左操作数的equals方法。
与java有区别

5.8 操作符的优先级和关联性
