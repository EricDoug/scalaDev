#第 9 章  广度优先搜索

    当题目看不出任何规律,既不能用分治,贪心,也不能用动规时,这时候万能方法——搜索,就 派上用场了。搜索分为广搜和深搜,广搜里面又有普通广搜,双向广搜,A* 搜索等。深搜里面又有 普通深搜,回溯法等。
广搜和深搜非常类似(除了在扩展节点这部分不一样),二者有相同的框架,如何表示状态?如 何扩展状态?如何判重?尤其是判重,解决了这个问题,基本上整个问题就解决了。

##9.1 Word Ladder

**描述**

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

>* Only one letter can be change datatime.

>* Each intermediate word must exist in the dictionary.

For example, Given:
  start = "hit"
  end = "cog"
  dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is ”hit” -> ”hot” -> ”dot” -> ”dog” -> ”cog”, return its length 5. Note:

>* Return0ifthereisnosuchtransformationsequence.

>* Allwordshavethesamelength.

>* Allwordscontainonlylowercasealphabeticcharacters.


