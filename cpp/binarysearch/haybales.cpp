#include <iostream>
#include <set>
#include <vector>
#include <fstream>
#include <algorithm>

using namespace std;
int n,q;
vector<int> bales;
int main()
{
    ifstream fin("haybales.in");
    ofstream fout("haybales.out");
    fin >> n >> q;
    for (int i = 0 ; i < n; i++)
    {
        int a;
        fin >> a;
        bales.push_back(a);
    }
    sort(begin(bales), end(bales));
    for (int i = 0 ; i < q ; i++)
    {
        int a, b;
        fin >> a>> b;
        auto p1 = lower_bound(bales.begin(), end(bales), a);
        auto p2 = upper_bound(begin(bales), end(bales), b);

        fout << p2 - p1<< endl;
    }


}