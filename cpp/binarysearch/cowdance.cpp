#include <iostream>
#include <set>
#include <vector>
#include <fstream>
#include <algorithm>
#include <queue>

using namespace std;
int n, t;
vector<int> dance;
bool canDance(int k, int t)
{
    int time = 0;
    multiset<int> ms;
    for (int i = 0; i < dance.size(); i++)
    {
        if (ms.size() == k)
        {
            time += *ms.begin();
            ms.erase(ms.begin());
        }

        ms.insert(dance[i]);
    }
    time += *ms.begin();
    ms.erase(ms.begin());
    if (!ms.empty())
    {
        time += max(*--ms.end() - time,0);
    }
    return time <= t;
}
int main()
{
    ifstream fin("cowdance.in");
    ofstream fout("cowdance.out");
    fin >> n >> t;
    for (int i = 0; i < n; i++)
    {
        int a;
        fin >> a;
        dance.push_back(a);
    }
    int lo = 1;
    int hi = n + 1;
    while (lo < hi)
    {
        int mid = lo + (hi - lo) / 2;
        if (canDance(mid, t))
        {
            hi = mid;
        }
        else
        {
            lo = mid + 1;
        }
    }
    fout << lo << endl;
}
