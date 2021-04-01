def listInsertIndex(lst):
    lst.insert(len(lst) // 2, len(lst) * 10)
    return lst

def listInsertEnd(lst):
    lst.append(len(lst) * 10)
    return lst

def setInsert(st):
    st.add(len(st) * 10)
    return st

def dictInsert(dic):
    dic[len(dic) * 10] = len(dic) * 10
    return dic


def test_listInsertIndex_10(benchmark):
    benchmark(listInsertIndex, lst=list(x for x in range(10)))


def test_listInsertEnd_10(benchmark):
    benchmark(listInsertEnd, lst=list(x for x in range(10)))

def test_listInsertEnd_100(benchmark):
    benchmark(listInsertEnd, lst=list(x for x in range(100)))

def test_listInsertEnd_1000(benchmark):
    benchmark(listInsertEnd, lst=list(x for x in range(1000)))


def test_setInsert_10(benchmark):
    benchmark(setInsert, st=set(x for x in range(10)))

def test_setInsert_100(benchmark):
    benchmark(setInsert, st=set(x for x in range(100)))

def test_setInsert_1000(benchmark):
    benchmark(setInsert, st=set(x for x in range(1000)))


def test_dictInsert_10(benchmark):
    benchmark(dictInsert, dic=dict((x, x) for x in range(10)))

def test_dictInsert_100(benchmark):
    benchmark(dictInsert, dic=dict((x, x) for x in range(100)))

def test_dictInsert_1000(benchmark):
    benchmark(dictInsert, dic=dict((x, x) for x in range(1000)))