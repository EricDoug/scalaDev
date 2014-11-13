#!/usr/bin/env python
# _*_ coding: UTF-8 _*_
__author__ = 'EricDoug'
import sys
import random

class Functions:
    def compareNum(self,num1,num2):
        if(num1 > num2):
            return 1
        elif(num1 == num2):
            return 0
        else:
            return -1

    def arithmetic(self,x=1,y=1,operator="+"):
        result={
            "+":x+y,
            "-":x-y,
            "*":x*y,
            "/":x/y
        }
        return result.get(operator)
    def test(self,arg):
        z = 1
        print locals()



if __name__ == "__main__":

    functions = Functions()
    """
    num1 = random.randrange(1,9)
    num2 = random.randrange(1,9)
    print "num1=",num1
    print "num2=",num2
    print functions.compareNum(num1,num2)
    """

    """
    print functions.arithmetic(1,2)
    print functions.arithmetic(1,2,"-")
    """

    functions.test(5)
    print globals()