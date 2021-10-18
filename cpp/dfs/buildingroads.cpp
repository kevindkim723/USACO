#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>
#include <string>

using namespace std;

int n,m;
vector<int> adj[100001];
bool visited[100001];
void dfs(int x)
{
    visited[x] =  true;
    for (auto i : adj[x])
    { 
        if (!visited[i]) dfs(i);
    }
}

int main()
{

    cin >> n >> m;
    int a,b;
    int roads=0;
    //create graph
    for (int i =0 ; i < m; i++)
    {
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    //dfs graph
    dfs(1);
    string s;

    for (int i = 2 ; i <= m ; i ++)
    {
       if (!visited[i]) 
       {
           visited[i] = true;
           roads++;
           s += to_string(1) + " " + to_string(i) + "\n";
           dfs(i);
       }
    }
    cout << roads << endl;
    cout << s;
}
