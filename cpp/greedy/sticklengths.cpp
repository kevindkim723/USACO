#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int n;
int main(){
    cin >> n;

    vector<int> sticks(n);
    for (int &x : sticks)
    {
        cin >> x;
    }
    sort(sticks.begin(), sticks.end());
    int sum;
    for (int x: sticks)
    {
        sum += abs(x-sticks[sticks.size()/2]);
    }
    cout << sum;




}
