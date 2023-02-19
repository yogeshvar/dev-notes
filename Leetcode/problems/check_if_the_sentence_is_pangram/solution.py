class Solution(object):
    def checkIfPangram(self, sentence):
        """
        :type sentence: str
        :rtype: bool
        """
        set_of_words = set(sentence)
        alphabet = set('abcdefghijklmnopqrstuvwxyz')
        return alphabet.difference(set_of_words) == set()
