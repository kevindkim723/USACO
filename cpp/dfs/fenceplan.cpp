#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

vector<pair<int, int>> xy;
int visited[201] = {false};
int n,m;
vector<int> adj[201];
pair<pair<int,int>, pair<int,int>> bb;

void dfs(int x)
{
    if (!visited[x])
    {
        bb.first.first = max(bb.first.first, xy[x].first);
        bb.first.second = max(bb.first.second, xy[x].first);
        bb.second.first = min(bb.second.first, xy[x].second);
        bb.second.second = min(bb.second.second, xy[x].second);
        visited[x] = true;
        for (int i : adj[x])
        {
            if (!visited[i])
            {
                dfs(i);
            }
        }
    }
}

int main()
{
    int minperim = 100000001;
    ifstream fin("fenceplan.in");
    ofstream fout("fenceplan.out");
    fin >> n >> m;
    xy.push_back(make_pair(-1,-1));
    for (int i = 1; i <= n; i++)
    {
        int x, y;
        fin >> x >> y;
        xy.push_back(make_pair(x, y));
    }
    for (int i = 1; i <= m; i++)
    {
        int a, b;
        fin >> a >>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    for (int i = 1 ; i <=n;i++)
    {
        bb = make_pair(make_pair(-1,-1), make_pair(100000000,1000000000));
        if (!visited[i])
        {
            dfs(i);
            int perim = (abs(bb.first.first - bb.second.first) + abs(bb.second.second -bb.first.second))*2;
            if (perim < minperim)
            {
                minperim = perim;
            }
        }
    }

    fout << minperim << endl;
}