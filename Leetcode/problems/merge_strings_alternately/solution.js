/**
 * @param {string} word1
 * @param {string} word2
 * @return {string}
 */
var mergeAlternately = function(word1, word2) {
    one_pointer = 0
    two_pointer = 0

    word3 = ''
    while (one_pointer < word1.length && two_pointer < word2.length) {
        word3 += word1[one_pointer] + word2[two_pointer]
        one_pointer += 1
        two_pointer += 1
    }
    if (one_pointer < word1.length) {
        word3 += word1.slice(one_pointer)
    }
    if (two_pointer < word2.length) {
        word3 += word2.slice(two_pointer)
    }
    return word3
};