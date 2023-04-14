#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

vector<pair<int, int>> xy;
int power[201];
int visited[201] = {false};
int n;
vector<int> adj[201];
int m = -1;
int curr = 0;
void dfs(int x)
{
    if (!visited[x])
    {
        curr++;
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
bool canReach(int x1, int y1, int x2, int y2, int p)
{
    return (sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2)) <= p);
}

int main()
{
    ifstream fin("moocast.in");
    ofstream fout("moocast.out");
    fin >> n;
    for (int i = 0; i < n; i++)
    {
        int x, y, p;
        fin >> x >> y >> p;
        xy.push_back(make_pair(x, y));
        power[i] = p;
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            pair<int, int> c1 = xy[i];
            pair<int, int> c2 = xy[j];
            if (i == j)
            if (canReach(c1.first, c1.second, c2.first, c2.second, power[i]))
            {
                adj[i].push_back(j);
            }
            if (canReach(c2.first, c2.second, c1.first, c1.second, power[j]))
            {
                adj[j].push_back(i);
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        curr = 0;
        dfs(i);
        if (curr > m)
        {
            m = curr;
        }
    }
    fout << m << endl;
}