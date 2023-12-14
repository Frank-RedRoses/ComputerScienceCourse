#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    int N = atoi(argv[1]);
    int *a = malloc(N*sizeof(int));
    int i, j, k;
    for (i = 0; i < N; i++)
        scanf("%d", &a[i]);
    for (i = 0; i < N; i++) {
        for (j = i + 1; j < N; j++)
            for (k = j+1; k < N; k++)
                if (a[i] + a[j] + a[k] == 0)
                    printf("%d %d %d\n", a[i], a[j], a[k]);
    }
    system("pause");
}