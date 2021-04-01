
def listCreation(size):
    lst = []
    for i in range(size):
        lst.append(i)
    return lst

def setCreation(size):
    set_aux = set(x for x in range(size))
    return set_aux

def dictCreation(size):
    dict_aux = dict((x, x) for x in range(size))
    return dict_aux

def test_listCreation_10(benchmark):
    benchmark(listCreation, 10)

def test_listCreation_100(benchmark):
    benchmark(listCreation, 100)

def test_listCreation_1000(benchmark):
    benchmark(listCreation, 1000)


def test_setCreation_10(benchmark):
    benchmark(setCreation, 10)

def test_setCreation_100(benchmark):
    benchmark(setCreation, 100)

def test_setCreation_1000(benchmark):
    benchmark(setCreation, 1000)


def test_dictCreation_10(benchmark):
    benchmark(dictCreation, 10)

def test_dictCreation_100(benchmark):
    benchmark(dictCreation, 100)

def test_dictCreation_1000(benchmark):
    benchmark(dictCreation, 1000)
