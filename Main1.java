#include <stdio.h>
void main()
{
    int n;
    scanf("%d",&n);
    int arr[n+1];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int new_element;
    scanf("%d",&new_element);
    arr[0]=new_element;
    n--;
    for(int i=0;i<n;i++){
        printf("%d",arr[i]);
    }
}
