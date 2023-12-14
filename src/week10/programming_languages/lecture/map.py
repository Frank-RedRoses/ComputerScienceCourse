def square(x):
    return x*x

def odd(x):
    return 2*x + 1

print (list(map(odd, range(10))))
print (list(map(square, range(10))))