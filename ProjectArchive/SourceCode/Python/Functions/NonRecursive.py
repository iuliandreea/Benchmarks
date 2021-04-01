import random

def primeUtil(num):
    for i in range(2, num//2):
        if num % i == 0:
            return True
    return False

def nonRecFactorial(size):
    result = 1
    for i in range(size):
        result *= i
    return result

def nonRecCommonDivisor(cd1, cd2):
    gcd = 1
    i = 1
    while i <= cd1 and i <= cd2:
        if cd1 % i == 0 and cd2 % i == 0:
            gcd = i
        i += 1
    return gcd

def primeNumbers(size):
    num = size
    while num >= 2:
        primeUtil(num)
        num -= 1


def test_nonRecFactorial_10(benchmark):
    benchmark(nonRecFactorial, 10)

def test_nonRecFactorial_100(benchmark):
    benchmark(nonRecFactorial, 100)

def test_nonRecFactorial_1000(benchmark):
    benchmark(nonRecFactorial, 1000)


def test_nonRecCommonDivisor_10(benchmark):
    benchmark(nonRecCommonDivisor, cd1=random.randrange(1, 10), cd2=random.randrange(1, 10))

def test_nonRecCommonDivisor_100(benchmark):
    benchmark(nonRecCommonDivisor, cd1=random.randrange(1, 100), cd2=random.randrange(1, 10))

def test_nonRecCommonDivisor_1000(benchmark):
    benchmark(nonRecCommonDivisor, cd1=random.randrange(1, 1000), cd2=random.randrange(1, 1000))


def test_primeNumbers_10(benchmark):
    benchmark(primeNumbers, 10)

def test_primeNumbers_100(benchmark):
    benchmark(primeNumbers, 100)

def test_primeNumbers_1000(benchmark):
    benchmark(primeNumbers, 1000)
