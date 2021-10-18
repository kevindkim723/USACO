#include <iostream>
#include <vector>
#include <fstream>
#include <string>
#include <map>

using namespace std;

int t;
int n;
string l;
void printarr(vector<int> arr)
{
    for (int i : arr){
        cout << i;
    
    }
    cout << endl;
}
int main()
{
    //ifstream fin("goodsubarray.in");
    //ofstream fout("goodsubarray.out");
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        cin >> n;
        map<int, int> m;
        vector<int> arr(n + 1, 0);
        vector<int> pref(n+1, 0);
        cin >> l;
        for (int j = 1; j <= n; j++)
        {
            arr[j] = l[j - 1] - '0';
            pref[j] = pref[j-1] + arr[j];
        }
        int good =0;
        for (int j = 0; j < n;j++)
        {
            int diff = pref[j] - j;
            m[diff] = m[diff] + 1;
        }
        for (int k : d)
        {
            if (k>1)
            {
                cout << k << endl;
                good += k*(k+1)/2;
            }
        }


        cout << good << endl;

        
    }
    
}
