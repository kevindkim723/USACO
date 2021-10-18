#include <iostream>
#include <vector>
#include <fstream>
#include <cmath>
#include <limits>

using namespace std;
int n,k,b;
vector<int> pref(100001, 0);
int main()
{
    ifstream fin("maxcross.in");
    ofstream fout("maxcross.out");
    fin >> n >> k >> b;
    for (int i = 0; i < b; i++)
    {
        
        int x;
        fin >> x;
        pref[x] = pref[x-1] +1;
        for (int j = x+1; j <= n; j++)
        {
            pref[j] = pref[j] +1;
        }

    }
    int minsum=b;
    cout << minsum << endl;
    for (int i = 1 ; i <= n-k+1;i++)
    {
        int a = i;
        int b = i+k-1;
        minsum = min(minsum, pref[b]-pref[a]);
        
    }
    fout << minsum;

}