
def square(x):
    return x*x

def table(f, sequence):
    for x in sequence:
        print ("{} {}".format(x, f(x)))

table (square, range(10))
