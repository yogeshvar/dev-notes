#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int size = 6;
    int result = 0;
    vector<int> v = {1, 2, 3, 4, 10, 11};

    for (int i = 0; i < v.size(); i++)
    {
        result += v[i];
    }

    cout << result << endl;

    return 0;
}