#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> adj[3001];
vector<bool> visited(3001, false);
bool closed[3001] = {false};
int nodes = 0;
int n, m;
int numopen;
void dfs(int x)
{
    if (visited[x] || closed[x])
    {
        return;
    }
    nodes++;
    visited[x] = true;
    for (int i : adj[x])
    {
        dfs(i);
    }
}

int main()
{
    ifstream fin("closing.in");
    ofstream fout("closing.out");
    fin >> n >> m;
    numopen = n;
    int x = 0;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        fin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
        x = a;
    }
    dfs(x);
    if (nodes == n)
    {
        fout << "YES" << endl;
    }
    else
    {
        fout << "NO" << endl;
    }
    for (int i = 0; i < n - 1; i++)
    {
        nodes = 0;
        int a;
        fin >> a;
        closed[a] = true;
        numopen--;
        fill(begin(visited), end(visited), false);
        for (int j = 1; j < 3001; j++)
        {
            if (!closed[j])
            {
                dfs(j);
                break;
            }
        }
        if (nodes == numopen)
        {
            fout << "YES" << endl;
        }
        else
        {
            fout << "NO" << endl;
        }
    }
    fin.close();
    fout.close();
}