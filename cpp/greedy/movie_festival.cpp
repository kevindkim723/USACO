#include <iostream>
#include <vector>
#include <algorithm>
#include <multiset>

using namespace std;


vector<pair<int, int>> movies;
int main()
{
    int n;
    cin >>n;
    for (int i = 0 ; i < n ; i ++){
        int a, b;
        cin >>a >> b;
        movies.push_back(make_pair(b, a));

    }
    sort(movies.begin(), movies.end());
    int endtime = 0;
    int m =0 ;
    for (auto x : movies)
    {
        if (x.second >= endtime)
        {
           endtime = x.first;
           m++; 
        }
    }
    cout << m;



}
