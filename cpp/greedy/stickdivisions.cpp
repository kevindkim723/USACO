#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <set>
#define ll long long
using namespace std;

int x, n, d;
multiset<int> sticks;
int main()
{
    cin >> x >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> d;
        sticks.insert(d);
    }
    ll cost = 0;
    while (sticks.size() > 1)
    {
        long long c = *sticks.begin() + *(++sticks.begin());
        sticks.erase(sticks.begin());
        sticks.erase(sticks.begin());
        sticks.insert(c);
        cost += c;
    }
    cout << cost << endl;
}
