#!/usr/bin/env python
# _*_ coding: UTF-8 _*_
__author__ = 'EricDoug'

from numpy import *
import operator
import matplotlib
import matplotlib.pyplot as plt
from os import *

class kNN:
    '''
    kNN 是一种最近邻算法。
    kNN is a supervised learning algorithm for classify the data from our collection to procast the unkown result.
    示例一：使用K-近邻算法改进约会网站的配对效果
    1.准备数据：从文本文件中解析数据
    2.分析数据：使用matplotlib创建散点图
    3.准备数据：归一化数值
    4.测试算法：作为完整程序验证分类器
    5.使用算法：构建完整可用系统
    示例二：手写识别系统
    1.准备数据：将图像转换为测试向量
    2.测试算法：使用K-近邻算法识别手写数字
    '''
    def classify(self,inX,dataSet,labels,k):
        '''
        this method is main handler of kNN
        :param inX:
        :param dataSet:
        :param labels:
        :param k:
        :return:
        '''
        dataSetsize = dataSet.shape[0]
        diffMat = tile(inX,(dataSetsize,1)) - dataSet

        sqDiffMat= diffMat**2
        sqDistances = sqDiffMat.sum(axis=1)
        distances = sqDistances**0.5
        sortedDistIndicies = distances.argsort()
        classCount = {}
        for i in rank(k):
            voteIlabel = labels[sortedDistIndicies[i]]
            classCount[voteIlabel] = classCount.get(voteIlabel,0) + 1
        sortedClassCount = sorted(classCount.iteritems(),key=operator.itemgetter(1),reverse=True)
        return sortedClassCount[0][0]

    def file2matrix(self,filename):
        '''
        This function aim to transform the file to matrix for handler with math metholodogy
        :param filename:需要处理的文件
        :return:
        '''
        #read file
        fr = open(filename)
        #read line of file
        arrayOfLines = fr.readlines()
        #count the number of file
        numberOfLines = len(arrayOfLines)
        #init matrix
        sampleMatrix = zeros((numberOfLines,3))
        labelVector = []
        index = 0
        for line in arrayOfLines:
            love_dic={"largeDoses":3,"smallDoses":2,"didntLike":1}
            line = line.strip()
            lineSplit = line.split('\t')
            sampleMatrix[index,:] = lineSplit[0:3]
            if(lineSplit[-1].isdigit()):
                labelVector.append(int(lineSplit[-1]))
            else:
                labelVector.append(love_dic.get(lineSplit[-1]))
            index +=1
        return sampleMatrix,labelVector
    @staticmethod
    def img2vector(filename):
        '''

        :param filename:
        :return:
        '''
        returnVect = zeros((1,1024))
        fr = open(filename)
        for i in range(32):
            lineStr = fr.readline()
            for j in range(32):
                returnVect[0,32*i+j] = int(lineStr[j])
        return returnVect


    def autoNorm(self,dataSet):
        minVals = dataSet.min(0)
        maxVals = dataSet.max(0)

        ranges = maxVals - minVals
        normDataSet = zeros(shape(dataSet))
        m = dataSet.shape[0]
        normDataSet = dataSet - tile(minVals,(m,1))
        normDataSet = normDataSet/tile(ranges,(m,1))
        return normDataSet,ranges,minVals

    def handwritingClassTest(self):
        hwLabels = []
        trainingFileList = listdir('resources/digits/trainingDigits')
        m = len(trainingFileList)
        trainingMat = zeros((m,1024))
        for i in range(m):
            fileNameStr = trainingFileList[i]
            fileStr= fileNameStr.split('.')[0]
            classNumStr = int(fileStr.split('_')[0])
            hwLabels.append(classNumStr)
            #trainingFile = str('resources/digits/trainingDigits/%s' % fileNameStr)
            trainingMat[i,:] = kNN.img2vector('resources/digits/trainingDigits/%s' % fileNameStr)

        testFileList = listdir('resources/digits/testDigits')
        errorCount = 0.0
        mTest = len(testFileList)

        for i in range(mTest):
            fileNameStr = testFileList[i]
            fileStr = fileNameStr.split('.')[0]
            classNumStr = int(fileStr.split('-')[0])
            testFile = str('resource/digits/testDigits/%s' % fileNameStr)
            vectorUnderTest = kNN.img2vector(testFile)
            classifierResult = kNN.classify(vectorUnderTest,trainingMat,hwLabels,3)
            print "the classifier came back with:%d,the real answer is: %d" % (classifierResult,classNumStr)
            if(classifierResult != classNumStr):
                errorCount += 1.0
        print "\nthe total number of errosr is: %d" % errorCount
        print "\nthe total error tate is: %f " % (errorCount/float(mTest))


class DecisionTrees:
    pass







if __name__ == "__main__":
    knn = kNN()





    #datingDataMat,datingLabels = knn.file2matrix('resources/datingTestSet.txt')
    #print datingDataMat
    #print datingLabels
    #fig = plt.figure(1)
    #ax = fig.add_subplot(111)
    #ax.scatter(datingDataMat[:,1],datingDataMat[:,2],15.0*array(datingLabels),15.0*array(datingLabels))
    #plt.show()

    #testVector = knn.img2vector('resources/digits/testDigits/0_13.txt')
    #print testVector[0,0:31]
    #print testVector[0,32:63]
    #knn.handwritingClassTest()

