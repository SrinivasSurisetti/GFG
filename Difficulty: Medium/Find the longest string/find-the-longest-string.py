class Solution():
    def longestString(self, words):
        maxCount = 0
        ans = ""
        word_set = set(words)

        for word in words:
            prefix = ""
            valid = True
            for ch in word[:-1]:  # skip full word
                prefix += ch
                if prefix not in word_set:
                    valid = False
                    break
            if valid:
                if len(word) > maxCount:
                    maxCount = len(word)
                    ans = word
                elif len(word) == maxCount and word < ans:
                    ans = word
        return ans
