#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> adj[3001];
vector<bool> visited(3001, false);
vector<bool> open(3001, true);
int n, m;
void printVisit()
{
    for (int i = 1; i <= n; i++)
    {
        cout << visited[i] << " " ;
    }
    cout << endl;
}
void printOpen()
{
    for (int i = 1; i <= n; i++)
    {
        cout << open[i] << " " ;
    }
}
void dfs(int x)
{
    printOpen();
    printVisit();
    visited[x] = true;
    for (int i : adj[x])
    {
        if (!visited[i] && open[i])
        {
            dfs(i);
        }
    }
}

int main()
{
    ifstream fin("closing.in");
    ofstream fout("closing.out");
    fin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        fin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    dfs(1);
    bool connected = true;
    for (int j = 1; j <= n; j++)
    {
        if (open[j] && !visited[j])
        {
            connected = false;
            break;
        }
    }
    fout << (connected ? "YES" : "NO") << endl;

    for (int i = 1; i < n; i++)
    {
        int x;
        fin >> x;
        open[x] = false;
        visited = vector<bool>(3001, false);
        for (int j = 1; j <= n; j++)
        {
            if (open[j])
            {
                dfs(j);
                break;
            }
        }
        bool connected = true;
        for (int j = 1; j <= n; j++)
        {
            cout << visited[i] << endl;
            if (open[j] && !visited[j])
            {
                connected = false;
                break;
            }
        }
        fout << (connected ? "YES" : "NO") << endl;
    }
}