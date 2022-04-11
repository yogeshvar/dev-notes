import argparse
from distutils import errors
from distutils.log import error
import os
import sys
import random


def decrypto(filename):
    with open(filename, 'rb') as f:
        blob = f.read()
        for b in blob:
            x = b.decode(errors='ignore')
            print(x)


def mycrypto(filename):
    with open(filename, 'r') as f, open(filename + '.enc', 'w') as o:
        blob = f.read()
        for b in blob:
            key = random.randrange(255)
            x = ord(b) ^ key
            print(chr(int(x)))
            o.write(chr(x))


def main():

    if not os.path.isfile('Crypto/test.txt'):
        print('The file  does not exist')
        sys.exit()

    mycrypto('Crypto/test.txt')
    decrypto('Crypto/secret.enc')


if __name__ == "__main__":
    main()
