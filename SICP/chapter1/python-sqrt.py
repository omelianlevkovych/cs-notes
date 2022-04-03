def my_sqrt(x, esp):
    n = x / 2

    while (1):
        g = 0.5 * (n + x/n)
        print(g)
        if abs(n - g) < esp:
            break
        n = g
    return g

number = 2
approximation = 0.000001
result = my_sqrt(number, approximation)

print(result)