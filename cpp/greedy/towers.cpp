#include <iostream>
#include <vector>
#include <algorithm>

#define ll long long
using namespace std;


vector<int> towers;
vector<int> t2;
int main()
{
    ll n;
    cin >>n;
    for (ll i = 0 ; i < n ; i ++){
        ll a;
        cin >> a;
        ll lo = 0;
        ll hi = towers.size();
        while (lo < hi)
        {
            ll mid = (lo + hi)/2;
            if (a >= towers[mid])
            {
                lo = mid+1;
            }
            else{
                hi =  mid;
            }
        }
        if (lo >= towers.size())
        {
            towers.push_back(a);
        }
        else{
            towers[lo] = a;
        }

    }
    cout << towers.size();



}

