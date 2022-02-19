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
            # 214, 103, 219, 161, 139,
            x = ord(b) ^ key
            print(chr(int(x)))
            o.write(chr(x))


def main():
    # parser = argparse.ArgumentParser(description='Encrypt (?) a file')
    # parser.add_argument('filename', metavar='filename',
    #                     type=str, help='file to encrypt')
    # parser.add_argument('--seed', metavar='seed', type=int,
    #                     default=2021, help='seed')
    # args = parser.parse_args()

    if not os.path.isfile('Crypto/test.txt'):
        print('The file  does not exist')
        sys.exit()

    # random.seed(2021)
    mycrypto('Crypto/test.txt')
    # decrypto('Crypto/secret.enc')


if __name__ == "__main__":
    main()
