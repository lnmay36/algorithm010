//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if(strs.length==0)
            return res;

        for (String s:strs) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);//将字符串按字母升序排列
            String s1 = Arrays.toString(letters);

            if (!map.containsKey(s1)){
                List<String> l = new ArrayList<>();
                l.add(s);
                res.add(l);
                map.put(s1, l);
            } else {
                map.get(s1).add(s);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
