

int BSearch(int low,int high,int* arr,int target)
{
    if(low<=high)
    {
        int mid = (low+high)/2;
       if(*(arr+mid)==target)
           return mid;
        else if(*(arr+mid)>target)
            return BSearch(low,mid-1,arr,target);
        else
            return BSearch(mid+1,high,arr,target);
    }
    else
        return -1;
}

int search(int* arr, int size, int target){
    int i=0;
    for(i=0;i<size-1;i++)
    {
        if(*(arr+i)>*(arr+i+1))
            break;
    }
    int x =BSearch(i+1,size-1,arr,target);
    int y =BSearch(0,i,arr,target);
    if(x==y)
        return -1;
    else if(x>y)
        return x;
    else
        return y;
    

}