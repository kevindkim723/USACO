#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;


int main()
{
    int n,k;
    cin >>n >> k;
    
    vector<pair<int, int>> movies;
    multiset<int> p;
    int tot=0;
    for (int i  =0 ; i < k; ++i)
    {
        p.insert(0);
    }
    for (int i = 0 ; i < n ; i ++){
        int a, b;
        cin >>a >> b;
        movies.push_back(make_pair(b, a));
    }
    sort(begin(movies), end(movies));
    for (int i = 0 ; i  < n; i ++ )
    {
        auto it = p.upper_bound(movies[i].second);//find person with time before the movie start time
        if (it == begin(p))
        {
            continue;//if the earliest done watching person can watch the new movie then 
        }
        auto low = p.lower_bound(movies[i].second);
        p.erase(--it);
        p.insert(movies[i].first);
        tot++;


    }
    cout << tot;

    

  



}
