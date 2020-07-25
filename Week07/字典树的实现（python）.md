# 字典树的实现（python）

```
END_OF_WORD = '#'
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = collections.defaultdict();#字典
        # self.root = {}


    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for char in word:
            node = node.setdefault(char, collections.defaultdict())
            # node = node.setdefault(char, {})
        node[END_OF_WORD] = END_OF_WORD


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
                
        return END_OF_WORD in node #has_key

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]

        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
```