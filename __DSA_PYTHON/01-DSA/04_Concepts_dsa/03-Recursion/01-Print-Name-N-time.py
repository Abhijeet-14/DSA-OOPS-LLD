def func(name, n):
    if n == 0: return
    print(name)
    func(name, n-1)

func("Abhijeet", 4)