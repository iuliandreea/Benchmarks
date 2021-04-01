def listDeletion(n):
    lst = list(x for x in range(n))
    lst.remove(n // 2)
    return lst

def setDeletion(n):
    st = set(x for x in range(n))
    st.remove(n // 2)
    return st

def dictDeletion(n):
    dic = dict((x, x) for x in range(n))
    del dic[n // 2]
    return dic


def test_listDeletion_10(benchmark):
    benchmark(listDeletion, n=10)

def test_listDeletion_100(benchmark):
    benchmark(listDeletion, n=100)

def test_listDeletion_1000(benchmark):
    benchmark(listDeletion, n=1000)


def test_setDeletion_10(benchmark):
    benchmark(setDeletion, n=10)

def test_setDeletion_100(benchmark):
    benchmark(setDeletion, n=100)

def test_setDeletion_1000(benchmark):
    benchmark(setDeletion, n=1000)


def test_dictDeletion_10(benchmark):
    benchmark(dictDeletion, n=10)

def test_dictDeletion_100(benchmark):
    benchmark(dictDeletion, n=100)

def test_dictDeletion_1000(benchmark):
    benchmark(dictDeletion, n=1000)
