#!/usr/bin/env python
# _*_ coding: UTF-8 _*_
__author__ = 'EricDoug'

from numpy import *
import matplotlib.pylab as plt

class Numpy:
    """

    """
    def __init__(self):
        pass

    def basic(self):
        a = array([1,2,3])
        print a
        b = a.dtype
        print b
        ran = random.rand(4,4)
        print ran
        #transform array to matrix
        randMat = mat(ran)
        print randMat
        #使用I产生逆矩阵
        inverse = randMat.I
        print inverse
        multiply = randMat * inverse
        print multiply
        error = multiply - eye(4)
        print error

    def drawPicture(self):

        x = arange(0,5,0.1)
        y = sin(x)
        plt.plot(x,y)

if __name__ == "__main__":
    test = Numpy()
    test.basic()

