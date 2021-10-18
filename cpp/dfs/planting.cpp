#include <iostream>
#include <algorithm>
#include <vector>
#include <fstream>
#include <cmath>
using namespace std;

vector<int> adj[100001];
int main()
{
    ifstream fin("planting.in");
    ofstream fout("planting.out");
    int n, a, b;
    fin >> n;

    //creating adjacency list of graph
    for (int i = 1; i < n; i++)
    {
        fin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    int totalPatch;
    bool visited[100001];
    bool looked[100001];
    int maxsize = 0;
    for (int i = 1; i < 100001; i++)
    {
        if (!adj[i].empty())
        {
            maxsize = max(maxsize, (int) adj[i].size());
            
        }
    }
    fout << maxsize + 1;
    fin.close();
    fout.close();
}