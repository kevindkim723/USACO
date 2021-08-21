#include <iostream>
#include <fstream>
#include <vector>

using namespace std;
int n;
int p;
long long pref[500001];
int main()
{
    long long mmax = 0;
    ifstream fin("div7.in");
    ofstream fout("div7.out");
    vector<long long> v(7, -1);
    v[0] = 0;
    fin >> n;
    for (int i = 1; i <= n; i++)
    {
        int a;
        fin >> a;
        int currmod7 = (a + p) % 7;
        if (v[currmod7] == -1)
        {
            v[currmod7] = i; // stores index of the the first index in which prev is divisible by 7;
        }
        else
        {
            mmax = max(mmax, i - v[currmod7]);
        }
        p = currmod7;
    }

    fout << mmax << endl;
    return 0;
}