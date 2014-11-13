#!/usr/bin/env python
# _*_ coding: UTF-8 _*_
__author__ = 'EricDoug'

import sys
import os
import urllib

def Main():
    sys.stdout.write("开始程序\n")
    i = 1
    print i,type(i),id(i)
    i = 1000000000
    print i,type(i),id(i)
    i = 1.1
    print i,type(i),id(i)
    i = 10
    j = ' 虎虎'
    print str(i) + j
    print os.listdir("/")
    #htmlresult = urllib.urlopen("http://www.baidu.com").read()
    #print htmlresult

if __name__ == "__main__":
    Main()
