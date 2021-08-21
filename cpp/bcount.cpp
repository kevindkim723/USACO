#include <iostream>
#include <fstream>
#include <cmath>
using namespace std;
int N;
int Q;
int p1[100001];
int p2[100001];
int p3[100001];

int main()
{
    ifstream fin("bcount.in");
    ofstream fout("bcount.out");
    fin >> N >> Q;
    for (int i = 1; i < N+1 ; i++)
    {
        int x;
        fin >> x;
        switch (x)
        {
            case 1:
                p1[i] = p1[i-1] + 1;
                p2[i] = p2[i-1];
                p3[i] = p3[i-1];
                break;
            case 2: 
                p2[i] = p2[i-1] + 1;
                p1[i] = p1[i-1];
                p3[i] = p3[i-1];
                break;
            case 3:
                p3[i] = p3[i-1] + 1;
                p2[i] = p2[i-1];
                p1[i] = p1[i-1];
                break;
        }
    }
    for (int i = 0;i < Q; i++)
    {
        int a, b;
        fin >> a >> b;
        fout << abs(p1[b] -p1[a-1]) << " "<< abs( p2[b] - p2[a-1]) << " "<< abs(p3[b]-p3[a-1]) << endl;
    }
    
}