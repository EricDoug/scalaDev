__author__ = 'qiutiaoming'

import scipy as sp


data = sp.genfromtxt("web_traffic.tsv")

print(data[:10])
print(data.shape)
print sp.sum(sp.isnan(data))

x = data[:, 0]
y = data[:, 1]

print x
print y
x = x[~sp.isnan(y)]
y = y[~sp.isnan(y)]

import matplotlib.pyplot as plt

plt.scatter(x, y)
plt.title("web traffic over the last month")
plt.xlabel("Time")
plt.ylabel("Hits/hour")
plt.xticks([w * 7 * 12 for w in range(10)], ['week %i' % w for w in range(10)])
plt.autoscale(tight=True)
plt.grid()
plt.show()