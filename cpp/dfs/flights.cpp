#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>

int n, m;
using namespace std;
vector<int> adj[100001];
bool visited[100001];
void dfs(int a)
{
    if (visited[a])
    {
        return;
    }
    visited[a] = true;
    for(int x : adj[a])
    {
        dfs(x);
    }
}
int main()
{
    cin >> n >> m;
    int a,b;
    for (int i  = 0 ; i < m; i++)
    {
        cin >> a >> b;
        adj[a].push_back(b);
    }
    for (int i = 1 ; i <= n; i++)
    {
        fill(visited, visited+n+1, false);
        dfs(i);
        for (int j  = 1; j <=n; j++)
        {
            if (!visited[j])
            {
                cout << "NO" << endl << i << j;
                return 0;
            }
        }
    }
    cout << "YES" << endl;
}
