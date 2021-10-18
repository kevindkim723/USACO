#include <vector>
#include <iostream>
using namespace std;



int binarysearch(vector<int> arr, int  k)
{
    int lo=0;
    int hi = arr.size()-1;
    while (lo < hi)
    {

        int mid =  lo + (hi-lo)/2;
        cout << lo << " " << hi <<" mid: " << mid << endl;
        if (k < arr[mid])
        {
            hi = mid;
        }
        else{ //k > arr[mid]
            lo = mid+1;
        }

    }
    return lo;
}
int main()
{
    vector<int> vec{1,2,3,4,5};
    cout << binarysearch(vec, 3.6)<< endl;

}


