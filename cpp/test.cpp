#include <iostream>
using namespace std;
void showStats(Shape duplicate)                        //  1
{                                                      //  2
    std::cout << duplicate.perimeter() << std::endl;   //  3
}                                                      //  4

int main()                                             //  5
{                                                      //  6
    std::cout << "Let's go!" << std::endl;             //  7

    if (3 > 0) {                                       //  8
        int stackTriangle{3};                        //  9
        showStats(stackTriangle);                      // 10

        int* heapSquarePtr;                          // 11
        // showStats(*heapSquarePtr);                  // 12

        int& alias = stackTriangle;                  // 13
        showStats(alias);                              // 14
    }                                                  // 15

    heapSquarePtr = new int{4};                      // 16
    showStats(*heapSquarePtr);                         // 17
    delete heapSquarePtr;                              // 18

    std::cout << "All done!" << std::endl;             // 19

    return 0;                                          // 20
}                                                      // 21