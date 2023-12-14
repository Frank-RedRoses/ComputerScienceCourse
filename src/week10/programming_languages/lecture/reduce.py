import functools

def plus(x, y):
    return x + y

def odd(x):
    return 2*x + 1

print(functools.reduce(plus, [1]*100))