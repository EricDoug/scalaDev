#!/usr/bin/env python
# _*_ coding: UTF-8 _*_
__author__ = 'EricDoug'

import csv
from collections import namedtuple
import json

class CSVtest:
    def readCSV(self,file):
        '''
        In the preceding code,row will be a tuple.
        :param file:
        :return:
        '''
        with open(file) as f:
            f_csv = csv.reader(f)
            haadings = next(f_csv)
            Row = namedtuple('Row',haadings)
            for r in f_csv:
                row = Row(*r)
                if(row[0] == "BA"):
                    print(row)

    def dictReadCSV(self,file):
        with open(file) as f:
            f_csv = csv.DictReader(f)
            for row in f_csv:
                print row
class JsonTest:

    def readJson(self,file):
        '''

        :return:
        '''
        try:
            with open(file,'r') as f:
                content = json.load(f)
                return content
        finally:
            f.close()
    def writeJson(self,content,file):
        '''

        :return:
        '''
        f = object
        try:
                f = open(file,"w")
                json.dump(content,f)
        finally:
            f.close()


if __name__ == "__main__":
    """
    csvTest = CSVtest()
    #csvTest.readCSV("resources/stocks.csv")
    csvTest.dictReadCSV("resources/stocks.csv")
    """
    data = {
        'name':'ACME',
        'shares':100,
        'price':542.23
    }
    jsonTest = JsonTest()
    jsonTest.writeJson(data,"resources/data.json")
    #jsonData = jsonTest.readJson("resources/data.json")
    #print jsonData
    #print jsonData['name']


