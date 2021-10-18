#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;
int n;
int prefs[100001];
int prefh[100001];
int prefp[100001];
int fs = -1;
int fh = -1;
int fp = -1;
int maxwins(int arr1[], int arr2[], int n)
{
    int m = 0;
    for (int i = 1; i <= n; i++)
    {
        m = max(m, arr1[i] + arr2[n] - arr2[i]);
    }
    return m;
}
int main()
{
    ifstream fin("hps.in");
    ofstream fout("hps.out");
    fin >> n;
    for (int i = 1; i <= n; i++)
    {
        string x;
        fin >> x;
        prefp[i] = prefp[i - 1];
        prefs[i] = prefs[i - 1];
        prefh[i] = prefh[i - 1];
        if (x == "P")
        {

            prefp[i] = prefp[i - 1] + 1;
        }
        if (x == "H")
        {

            prefh[i] = prefh[i - 1] + 1;
        }
        if (x == "S")
        {

            prefs[i] = prefs[i - 1] + 1;
        }
    }
    int sol = 0;
    sol = max(sol, maxwins(prefh, prefs, n));
    sol = max(sol, maxwins(prefh, prefp, n));
    sol = max(sol, maxwins(prefs, prefp, n));
    sol = max(sol, maxwins(prefs, prefh, n));
    sol = max(sol, maxwins(prefp, prefs, n));
    sol = max(sol, maxwins(prefp, prefh, n));
    fout << sol << endl;
}