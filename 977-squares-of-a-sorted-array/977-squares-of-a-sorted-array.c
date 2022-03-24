

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortedSquares(int* arr, int size, int* returnSize){
    
    int size1= size-1;
    int *p = malloc(sizeof(int) *  (*returnSize = size));
    int low = 0;
    int high = size-1;
    
    
    while(low<=high)
    {
    
        if(*(arr+low)>0)
        {
            *(arr);
        }
        else
        {
            *(arr+low)= *(arr+low) * -1;
        }
        
        

        if(*(arr+high)>0)
        {
            *(arr);
        }
        else
        {
            *(arr+high)= *(arr+high) * -1;
        }
           
           
        if(*(arr+low)>= *(arr+high))
        {
            p[size1--] = *(arr+low) * *(arr+low);
            low++;
        }
        else
        {
            p[size1--] = *(arr+high)  * *(arr+high);
            high--;

        }
    }

    return p;
    

}