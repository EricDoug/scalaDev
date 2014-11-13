#!/usr/bin/env python
# _*_ coding: UTF-8 _*_
__author__ = 'EricDoug'
import matplotlib.pyplot as plt
import numpy as np

class Plot():
    def scatter1(self):
        x = np.random.randn(1000)
        y = np.random.randn(1000)
        size = 50 * np.random.randn(1000)
        colors = np.random.rand(1000)
        plt.scatter(x,y,s=size,c=colors)
        plt.show()


if __name__ == "__main__":
    plot = Plot()
    plot.scatter1()