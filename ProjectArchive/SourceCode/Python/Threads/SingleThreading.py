import threading
import time

threadLock = threading.Lock()

class MyThread(threading.Thread):

    def __init__(self, id):
        threading.Thread.__init__(self)
        self.id = id

    def run(self):
        threadLock.acquire()
        time.sleep(5)
        threadLock.release()

        threadLock.acquire()
        time.sleep(5)
        threadLock.release()


def threads():
    thread1 = MyThread(1)
    thread1.start()
#
# def threads2():
#     thread2 = MyThread(2)
#     thread3 = MyThread(3)
#
#     thread2.start()
#     thread3.start()
#
#     thread2.join()
#     thread3.join()

def test_threads(benchmark):
    benchmark(threads)

# def test_threads2(benchmark):
#     benchmark(threads2)