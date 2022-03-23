# imperative sqrt of x with eps by Newton method:
def my_sqrt(x, eps):
    n = x * 0.5
    root = 0

    while(1):
        root = 0.5 * (n + x/n)
        if abs(root - n) < eps:
            break
        n = root
    return root

result = my_sqrt(568, 0.00001)
print(result)