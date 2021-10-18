#include <iostream>
#include <vector>
#include <algorithm>

#define ll long long
using namespace std;


vector<pair<int, int>> tasks;
int main()
{
    ll n;
    cin >>n;
    for (ll i = 0 ; i < n ; i ++){
        ll a, b;
        cin >>a >> b;
        tasks.push_back(make_pair(a,b));

    }
    sort(tasks.begin(), tasks.end());
    ll currtime=0;
    ll points = 0;
   for (auto x : tasks)
    {
        currtime += x.first;
        points += (x.second - currtime);

    }
    cout << points;



}

