#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <set>
#include <fstream>
#define ll long long
using namespace std;

int c, n;
multiset<int> chicken;
vector<pair<int,int>> cows;
int main()
{
    ifstream fin("helpcross.in");
    ofstream fout("helpcross.out");
    fin >> c >> n;
    for (int i = 0; i < c ; i++)
    {
        int t;
        fin >> t;
        chicken.insert(t);
    }
    for (int i = 0 ; i < n; i++)
    {
        int a,b;
        fin >> a >> b;
        cows.push_back(make_pair(b,a)); //sort endtime
    }
    sort(cows.begin(), cows.end());
    int tot =0;
    for (auto p : cows)
    {
        if (chicken.empty())
        {
            break;
        }
        auto c = chicken.lower_bound(p.second); //earliest chicken
        if (c != chicken.end() && *c <= p.first)
        {
            tot++;
            chicken.erase(c);
        }
    }

    fout << tot;

}
