import urllib
import requests
from multiprocessing.dummy import Pool as ThreadPool

nums = list(x for x in range(10))

def add(x):
    return x + 1

def threads(size):
    pool = ThreadPool(size)
    results = pool.map(add, nums)
    pool.close()
    pool.join()
    return results

def test_threads_2(benchmark):
    benchmark(threads, 2)

def test_threads_5(benchmark):
    benchmark(threads, 5)

def test_threads_10(benchmark):
    benchmark(threads, 10)

def test_threads_20(benchmark):
    benchmark(threads, 20)