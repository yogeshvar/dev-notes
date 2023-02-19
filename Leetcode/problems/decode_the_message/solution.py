class Solution(object):
    def decodeMessage(self, key, message):
        """
        :type key: str
        :type message: str
        :rtype: str
        """
        key = key.replace(" ", "")
        alphabet = "abcdefghijklmnopqrstuvwxyz"

        hash_table = {}
        cur = 0
        res = ''

        for i in key:
            if i not in hash_table:
                hash_table[i] = alphabet[cur]
                cur += 1
        for i in message:
            if i == ' ':
                res = res + ' '
            else:
                res = res + hash_table[i]
        return res