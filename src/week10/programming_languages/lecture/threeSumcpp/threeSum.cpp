#include <iostream>
#include <cstdlib>
int main(int argc, char *argv[]) 
{
    int N = atoi(argv[1]);
    int *a = new int[N];
    int i, j, k;
    for (i = 0; i < N; i++)
        std::cin >> a[i];
    for (i = 0; i < N; i++) {
        for (j = i+1; j < N; j++)
            for (k = j+1; k < N; k++)
                if (a[i] + a[j] + a[k] == 0)
                    std::cout << a[i] << " " << a[j] << " " << a[k] << std::endl;
    }
    system("pause");
}