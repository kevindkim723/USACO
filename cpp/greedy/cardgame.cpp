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
    ifstream fin("cardgame.in");
    ofstream fout("cardgame.out");
    fin >> n;
    bool elsieCards[2 * n + 1]={0};
    for (int i = 0; i < n; i++)
    {
        fin >> x;
        elsieCards[x] = true;
        eCards.push_back(x);
    }
    for (int i = 1 ; i <= 2* n ; i++)
    {
        if (elsieCards[i])
        {
            continue;
        }
        else{
            bCards.push_back(i);
        }
    }
    int tot = 0;
    sort(eCards.begin(), eCards.begin() + eCards.size()/2);
    sort(bCards.begin(), bCards.end());
    int bc = 0;
    int ec = 0;
    for (int i  = n/2 ; i < n ; i++)
    {
        if (bCards[i] > eCards[ec])
        {
            tot++;
            ec++;
        }
    }
    ec = eCards.size()/2;

    reverse(bCards.begin(),bCards.begin() + bCards.size()/2);
    sort(eCards.begin()+eCards.size()/2, eCards.end());
    reverse(eCards.begin() + eCards.size()/2,  eCards.end());
    for (int i  = 0 ; i < n/2 ; i++)
    {
        if (bCards[i] < eCards[ec])
        {
            tot++;
            ec++;
        }
    }

    fout << tot << endl;
    fin.close();
    fout.close();
}
