#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <set>
#include <fstream>
#define ll long long
using namespace std;

int x, n, d;
vector<int> cows;
int main()
{
    ifstream fin("lemonade.in");
    ofstream fout("lemonade.out");
    fin >> n;
    for (int i = 0 ; i < n; i++)
    {
        fin >> x;
        cows.push_back(x);
    }
    sort(cows.begin(), cows.end());
    reverse(cows.begin(), cows.end());
    int numcows = 0;
    for (int i = 0 ; i < n; i++)
    {
        if (numcows > cows[i]){ //if the number of cows in line is less than w_i
            break;
        }
        numcows++;
    }
    fout << numcows << endl;
    fin.close();
    fout.close();




}
