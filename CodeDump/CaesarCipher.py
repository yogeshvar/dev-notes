def caesarCipher(string, key):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    newString = ""
    for char in string:
        newString += alphabet[(alphabet.index(char) + key) % 26]
    return newString

x = caesarCipher("xyz", 2) 
