#!/usr/bin/env python
# _*_ coding: UTF-8 _*_
__author__ = 'EricDoug'

import numpy as np


def numpyArray():
    '''
    Numpy数组对象：
    Numpy中的ndarray是一个多维数组对象，该对象有两部分组成：实际的数据和描述这些数据的元数据
    大部分的数组操作仅仅修改元数据部分，而不改变底层的实际数据。
    numpy.arange()一维数组
    numpy.ndarray()多维数组
    :return:
    '''

    #一维数组
    a = np.arange(5)
    print a
    print a.dtype
    print a.shape
    #数据类型对象：元素在内存中占用的字节数
    print a.dtype.itemsize

    #自定义数据类型
    t = np.dtype([('name',np.str_,40),('numitems',np.int32),('price',np.float32)])
    items = np.array([('Meaning of lief DVD',42,3.14),('Butter',13,2.72)],dtype=t)

    print items[1]

    #多维数组
    a = np.arange(9).reshape(3,3)
    print(a)
    b = 2 * a
    print b
    #水平组合数组
    c1 = np.hstack((a,b))
    c2 = np.concatenate((a,b),axis=1)
    print c1
    print c2
    #垂直组合数组
    d1 = np.vstack((a,b))
    d2 = np.concatenate((a,b),axis=0)
    print d1
    print d2
    #深度组合
    e = np.dstack((a,b))
    print e

    #转置
    x = np.arange(16).reshape((4,4))
    print x
    y = x.T
    print y
    print x.flat[2]
    print y.flat[2]


if __name__ == "__main__":
    numpyArray()
