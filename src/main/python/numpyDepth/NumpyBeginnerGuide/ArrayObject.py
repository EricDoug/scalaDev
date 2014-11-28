#!/usr/bin/env python
# _*_ coding: UTF-8 _*_
__author__ = 'EricDoug'
import numpy as np
import sys
from datetime import datetime
class ArrayObject:
    def pythonsum(self,n):
        '''

        :param n:
        :return:
        '''
        a = range(n)
        b = range(n)
        c = []
        for i in range(len(a)):
            a[i] = i ** 2
            b[i] = i ** 3
            c.append(a[i] + b[i])
        return c
    def numpysum(self,n):
        '''

        :param n:
        :return:
        '''
        a = np.arange(n) ** 2
        b = np.arange(n) ** 3
        c = a + b
        return c

if __name__ == "__main__":
    n = 1000
    arrayobject = ArrayObject()
    start = datetime.now()
    c = arrayobject.pythonsum(n)
    delta = datetime.now() - start
    print "The last 2 elements of the sum",c[-2:]
    print "PythonSum elapsed time in microseconds",delta.microseconds
    start  = datetime.now()
    c = arrayobject.numpysum(n)
    delta = datetime.now() - start
    print "The last 2 elements of the sum", c[-2:]
    print "NumpySum elapsed time in microseconds",delta.microseconds