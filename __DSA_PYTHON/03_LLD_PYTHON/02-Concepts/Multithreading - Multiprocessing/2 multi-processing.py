import multiprocessing as mp
import time
def cal_square(numbers):
    for n in numbers:
        time.sleep(5)
        print("cube " +str(n*n))

def cal_cube(numbers):
    for n in numbers:
        time.sleep(15)
        print("square " +str(n*n*n))


if __name__ == "__main__":
    arr= [1,2,3]     
    p1 = mp.Process(target=cal_square, args=(arr,))
    p2 = mp.Process(target=cal_cube, args=(arr,))

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    print("Done")

# SHared memory
mp.Array('i', 3)
mp.Value(100)
q = mp.Queue()
q.get() # pop
q.put() 


# Lock - shared memory
"""
lock = mp.Lock()

fun(lock):
   lock.acquire()
   # do somthing
   lock.release
fun(lock)
"""


"""
POOL: -- cPU - cores - processing units
distribute Process to no of cores - for speed work
p = mp.Pool()
p.map(func, arr)
"""