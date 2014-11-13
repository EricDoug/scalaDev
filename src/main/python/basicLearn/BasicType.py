#!/usr/bin/env python
# _*_ coding: UTF-8 _*_
__author__ = 'EricDoug'
import sys

class Basic:
    def listTest(self):
        '''
        Python中的列表(list)类似于java中的ArrayList，用于顺序存储结构。列表用符号[]表示，中间的元素可以是任何类型(包括列表本身,以实现多维数组)，
        元素之间用逗号分割。
        '''

        array = [1,2,3]
        print array[0]
        array[0] = 'a'
        print array
        L = [123,'spam',1.23]
        print len(L)
        print L[0]
        print L[:-1]  #不包含最后一个
        print L+[4,5,6]  #
        #切片
        test = ['never',1,2,'yes',1,'no','maybe']
        print test[0:3]  #包括test[0],不包括test[3]
        print test[0:6:2]
        print test[:-1]
        print test[-3:]  #抽取最后3个

        #排序与反转
        array1 = [5,2,3,1,8]
        array1.sort()
        print("-----------------sort--------------")
        print array1
        for s in array1:
            print s
        array1.reverse()
        print("--------------Inverse--------------")
        for s in array1:
            print s

        #矩阵
        M = [[1,2,3],[4,5,6],[7,8,9]]
        print M
        print M[0]
        print M[1]
        print M[2]
        #按列索引

        col2 = [row[1] for row in M]
        print col2
        print row[1]
        col3 = [row[1]+1 for row in M]
        print col3
        colfilter = [row[1] for row in M if row[1]%2 == 0]
        print colfilter


    def dictTest(self):
        '''
        类似java中的Hashtable，python里的哈希表就是字典(dict)。与set类似，字典是一种无序存储结构，它包括关键字(key)和关键字对应的值(value)。
        字典里的key为不可变类型，如字符串、整数、只包含不可变对象的元组，列表等不能作为关键字。
        :return:
        '''
        dict = {"a":"apple","b":"banana","g":"grape","o":"orange"}
        print dict
        print dict["a"]
        dict2 = {1:"apple",2:"banana",3:"grape",4:"orange"}
        print(dict2)
        print dict2[1]
        #增
        dict["w"] = "watermelon"
        print("----------------add-----------------")
        print dict
        #删
        print("----------------delete---------------")
        del(dict["a"])
        print dict
        print dict.pop("b")
        #字典遍历
        for k in dict:
            print "dict[%s]="%k,dict[k]
        #输出key的列表
        print dict.keys()
        #输出values的列表
        print dict.values()
        D = {'food':'spam','quantity':4,'color':'pink'}
        print D['food']
        D['quantity'] += 1
        print D
        D = {}
        D['name'] = 'Bob'
        D['job'] = 'dev'
        D['age'] = 40
        print D
        #使用键值，进行排序
        D = {'a':1,'b':2,'c':3}
        print D
        Ks = D.keys()
        print Ks
        Ks.sort()
        print(Ks)
        for key in Ks:
            print key,'=>',D[key]
        for key in sorted(D):
            print key,'=>',D[key]
        #迭代与优化
        squares = [x ** 2 for x in [1,2,3,4,5]]
        print squares
        squares = []
        for x in [1,2,3,4,5]:
            squares.append(x**2)
        if not D.has_key('a'):
            print 'not exist the key'
        else:
            print D['a']

    def tupleTest(self):
        '''
        元组与列表非常相似，使用();但元组比列表的速度更加快。
        :return:
        '''
        tuple_name = ("apple","banana","grape","orange")
        print tuple_name[0]
        #分片
        print tuple_name[-1]
        #多元
        multi_tuple = (('t1','t2'),('t3','t4'))
        print multi_tuple[0][0]
        #解包
        a,b,c,d = tuple_name
        print a,b,c,d
        #交换数据
        a = 1
        b = 2
        a,b = b,a
        print a,b

    def setTest(self):
        '''
        集合是指无序的、不重复的元素集。
        :return:
        '''
        a = [133,224,2344,2243,22342,224,133,133,989]
        print a
        b = set(a)
        print b
        a = ["11","22","33"]
        b = ["11","33"]
        c = set(a)&set(b)
        print a
        print b
        print c

if __name__ == "__main__":
    basic = Basic()
    #basic.listTest()
    #basic.dictTest()
    #basic.tupleTest()
    basic.setTest()
