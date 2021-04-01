def succListFind(lst):
    find = (len(lst) / 2) in lst
    return find

def failListFind(lst):
    find = (len(lst) + 2) in lst
    return find

def succSetFind(st):
    find = (len(st) / 2) in st
    return find

def failSetFind(st):
    find = (len(st) + 2) in st
    return find

def succDictFind(dic):
    find = (len(dic) / 2) in dic
    return find

def failDictFind(dic):
    find = (len(dic) + 2) in dic
    return find


def test_succListFind_10(benchmark):
    benchmark(succListFind, lst=list(x for x in range(10)))

def test_succListFind_100(benchmark):
    benchmark(succListFind, lst=list(x for x in range(100)))

def test_succListFind_1000(benchmark):
    benchmark(succListFind, lst=list(x for x in range(1000)))


def test_failListFind_10(benchmark):
    benchmark(failListFind, lst=list(x for x in range(10)))

def test_failListFind_100(benchmark):
    benchmark(failListFind, lst=list(x for x in range(100)))

def test_failListFind_1000(benchmark):
    benchmark(failListFind, lst=list(x for x in range(1000)))


def test_succSetFind_10(benchmark):
    benchmark(succSetFind, st=set(x for x in range(10)))

def test_succSetFind_100(benchmark):
    benchmark(succSetFind, st=set(x for x in range(100)))

def test_succSetFind_1000(benchmark):
    benchmark(succSetFind, st=set(x for x in range(1000)))


def test_failSetFind_10(benchmark):
    benchmark(failSetFind, st=set(x for x in range(10)))

def test_failSetFind_100(benchmark):
    benchmark(failSetFind, st=set(x for x in range(100)))

def test_failSetFind_1000(benchmark):
    benchmark(failSetFind, st=set(x for x in range(1000)))


def test_succDictFind_10(benchmark):
    benchmark(succDictFind, dic=dict((x, x) for x in range(10)))

def test_succDictFind_100(benchmark):
    benchmark(succDictFind, dic=dict((x, x) for x in range(100)))

def test_succDictFind_1000(benchmark):
    benchmark(succDictFind, dic=dict((x, x) for x in range(1000)))


def test_failDictFind_10(benchmark):
    benchmark(failDictFind, dic=dict((x, x) for x in range(10)))

def test_failDictFind_100(benchmark):
    benchmark(failDictFind, dic=dict((x, x) for x in range(100)))

def test_failDictFind_1000(benchmark):
    benchmark(failDictFind, dic=dict((x, x) for x in range(1000)))