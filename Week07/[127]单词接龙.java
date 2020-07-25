//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 389 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> __wordList) {
        Set<String> wordList = new HashSet<> (__wordList);
        if (!wordList.contains(endWord))
            return 0;
        Set<String> beginSet = new HashSet<> (),
                endSet   = new HashSet<> ();
        Set<String> visited = new HashSet<> ();
        int len = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);

        while (beginSet.size()>0 && endSet.size()>0) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;//双向bfs是每次将new word加入较小的set
                endSet = temp;//将beginSet变为较短者
            }

            Set<String> temp = new HashSet<> ();
            for (String word:beginSet) {
                char[] chs = word.toCharArray();

                for (int i=0;i<chs.length;++i) {
                    for (char c='a';c<='z';++c) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len+1;//终止条件是endset包含了target
                        }

                        if (!visited.contains(target)&&wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }

                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
