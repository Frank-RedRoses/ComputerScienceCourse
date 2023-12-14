import sys # import used to read the arguments 

# Take N from command-line arguments
N = int(sys.argv[1])
# Create the array of 0 Of size N
a = [0]*N
# read the input from file 
rel_dir = 'C:\\Users\\frank\\Coding\\Courses\\Computer.Science.Programming.with.a.Purpose\\Workspace\\ComputerScienceCourse\\resources\\In\\threeSum\\8ints.txt'   
f = open(rel_dir, "r")
for i in range(N):
    a[i] = int(f.readline())
# for loop the array to check the three sum
for i in range(N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            if (a[i] + a[j] + a[k]) == 0:
                # print with format
                print(f'{a[i]:3d} {a[j]:3d} {a[k]:3d}')
# Close the input file 
f.close()
