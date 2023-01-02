import base64
from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP
import binascii

note = "This is my private note"
print(note)

ascii_note = ""
for i in range(len(note)):
    ascii_note = ascii_note + str(ord(note[i])) + " "

base64_note = base64.b64encode(ascii_note.encode())

print(base64_note)


with open("./Fun/journalscripts/priv_note.pem", "rb") as key_file:
    privKey = RSA.importKey(key_file.read())
    print(privKey.can_encrypt())

with open("./Fun/journalscripts/enc_note.pem", "rb") as key_file:
    pubKey = RSA.importKey(key_file.read())
    print(pubKey.can_encrypt())


encryptor = PKCS1_OAEP.new(pubKey)
encrypted = encryptor.encrypt(base64_note)
print("Encrypted:", binascii.hexlify(encrypted))

decryptor = PKCS1_OAEP.new(privKey)
decrypted = decryptor.decrypt(encrypted)
print("Decrypted:", decrypted.decode())


# convert base64 to ascii
decrypted = base64.b64decode(decrypted)
# convert ascii to string
decrypted = decrypted.decode()
# convert string to list of ints
decrypted = decrypted.split()
# convert list of ints to string
decrypted = ''.join(chr(int(i)) for i in decrypted)
print(decrypted)
