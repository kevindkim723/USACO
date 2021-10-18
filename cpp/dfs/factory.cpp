#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>

using namespace std;

vector<int> adj[101];
int connected[101] ={};
int main()
{
    ofstream fout("factory.out");
    ifstream fin("factory.in");
    int n, a,b;
    fin >> n;
    for (int i = 0; i < n; i++)
    {
        fin >> a >> b;
        adj[a].push_back(b);
        connected[b]=1;
    }
    int r= -1;
    for (int i  = 1; i <= 100; i++)
    {
        if (adj[i].size() == 0 && connected[i]==1)
        {
            if (i > r && r != -1)
            {
                r=-1;
                break;
            }
            r = i;
        }
    }
    fout << r << endl;
    fin.close();
    fout.close();


}