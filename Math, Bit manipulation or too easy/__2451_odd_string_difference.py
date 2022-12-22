'''
You are given an array of equal-length strings words. Assume that the length of each string is n.

Each string words[i] can be converted into a difference integer array difference[i] of length n - 1 where difference[i][j] = words[i][j+1] - words[i][j] 
    where 0 <= j <= n - 2. Note that the difference between two letters is the difference between their positions in the alphabet 
    i.e. the position of 'a' is 0, 'b' is 1, and 'z' is 25.

For example, for the string "acb", the difference integer array is [2 - 0, 1 - 2] = [2, -1].
All the strings in words have the same difference integer array, except one. You should find that string.

Return the string in words that has different difference integer array.

 

Example 1:

Input: words = ["adc","wzy","abc"]
Output: "abc"
Explanation: 
- The difference integer array of "adc" is [3 - 0, 2 - 3] = [3, -1].
- The difference integer array of "wzy" is [25 - 22, 24 - 25] = [3, -1].
- The difference integer array of "abc" is [1 - 0, 2 - 1] = [1, 1]. 
The odd array out is [1, 1], so we return the corresponding string, "abc".
Example 2:

Input: words = ["aaa","bob","ccc","ddd"]
Output: "bob"
Explanation: All the integer arrays are [0, 0] except for "bob", which corresponds to [13, -13].


Failed TC:
["ddd","poo","baa","onn"]

My Output
"poo"
Expected
"ddd"

REASON: MY SHORT HURRIED LOGIC
In my first code if first 2 were different the later one was considered as answer but it might be that the first one is the ans!

Failed time 2: same reason, less if checks

Failed time 3: (again, jumped to conclusion that only the first 3 words can give ans, didn't update word1 and word2)
["mll","edd","jii","tss","fee","dcc","nmm","abb","utt","zyy","xww","tss","wvv","xww","utt"]

my output
"edd"
Expected
"abb"

Failed time 4: solved for above but base case issue
["adc","wzy","abc"]


my output
""
Expected
"abc"

'''

# works after 4 tries! do more easy questions -> multiple silly mistake due to underestimating the question!!
class Solution:
    # return list as a string separated with '_'
    def getDiffList(self, word: str) -> str:
        diff_str = ""
        for i in range(0, len(word) - 1):
            diff_str = diff_str + str(ord(word[i + 1]) - ord(word[i])) + "_"
        return diff_str        

    def oddString(self, words: List[str]) -> str:
        diff_str1 = ""
        word1 = ""

        diff_str2 = ""
        word2 = ""
        for word in words:
            diff_str = self.getDiffList(word)

            if not diff_str1:
                diff_str1 = diff_str
                word1 = word
            elif not diff_str2:
                if diff_str != diff_str1:
                    diff_str2 = diff_str
                    word2 = word
            else:
                if diff_str1 == diff_str:
                    return word2
                else:
                    return word1
        return word2

