class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        vowel = 'aeiou'
        result = ''
        for i, word in enumerate(sentence.split()):
            if i != 0 and i != len(sentence.split()): 
                result += ' '
            a_count = (i + 1) * 'a'
            if word[0].lower() in vowel:
                result += word + 'ma' + a_count
            if word[0].lower() not in vowel:
                result += word[1:] + word[0] + 'ma' + a_count
        return result