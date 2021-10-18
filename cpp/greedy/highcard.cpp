#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <set>
#include <fstream>
#define ll long long
using namespace std;

int x, n, d;
vector<int> eCards;
vector<int> bCards;
int main()
{
    ifstream fin("highcard.in");
    ofstream fout("highcard.out");
    fin >> n;
    bool elsieCards[2 * n + 1]={0};
    for (int i = 0; i < n; i++)
    {
        fin >> x;
        elsieCards[x] = true;
    }
    for (int i = 1 ; i <= 2* n ; i++)
    {
        if (elsieCards[i])
        {
            eCards.push_back(i);
        }
        else{
            bCards.push_back(i);
        }
    }
    int tot = 0;
    sort(eCards.begin(), eCards.end());
    sort(bCards.begin(), bCards.end());
    int bc = 0;
    int ec = 0;
    for (int i  = 0 ; i < n ; i++)
    {
        if (bCards[i] > eCards[ec])
        {
            tot++;
            ec++;
        }
    }

    fout << tot << endl;
    fin.close();
    fout.close();
}
