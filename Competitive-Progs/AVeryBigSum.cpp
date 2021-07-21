// CAUTION: Wait for the result.
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int n = 5;
    vector<long> v;
    long result;

    v.assign(1000000001, 1000000005);

    for (int i = 0; i < v.size(); i++)
    {
        result += v[i];
    }
    cout << result << endl;
    return 0;
}