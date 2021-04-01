import random
import string

def factorialUtil(num):
    if num >= 1:
        return num * factorialUtil(num - 1)
    else:
        return 1

def commonDivisorUtil(n1, n2):
    if n2 == 0:
        return n1
    return commonDivisorUtil(n2, n1 % n2)

def reverseUtil(str):
    if not str:
        return str
    return reverseUtil(str[1:]) + str[0]

def recFactorial(size):
    result = factorialUtil(size)
    return result

def recCommonDivisor(cd1, cd2):
    gcd = commonDivisorUtil(cd1, cd2)
    return gcd

def reverseString(str):
    str = reverseUtil(str)
    return str


def test_recFactorial_10(benchmark):
    benchmark(recFactorial, 10)

def test_recFactorial_100(benchmark):
    benchmark(recFactorial, 100)


def test_recCommonDivisor_10(benchmark):
    benchmark(recCommonDivisor, cd1=random.randrange(1, 10), cd2=random.randrange(1, 10))

def test_recCommonDivisor_100(benchmark):
    benchmark(recCommonDivisor, cd1=random.randrange(1, 100), cd2=random.randrange(1, 1000))

def test_recCommonDivisor_1000(benchmark):
    benchmark(recCommonDivisor, cd1=random.randrange(1, 100), cd2=random.randrange(1, 1000))


def test_reverseString_10(benchmark):
    benchmark(reverseString, str=''.join(random.choice(string.ascii_lowercase) for _ in range(10)))

def test_reverseString_100(benchmark):
    benchmark(reverseString, str=''.join(random.choice(string.ascii_lowercase) for _ in range(100)))
