#include <fstream>
#include <string>
#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char **argv)
{
    vector<string> lines;
    ifstream file("db.txt");
    string line;
    while (std::getline(file, line))
    {
        if (line.empty())
            continue;
        lines.push_back(line);
    }
    file.close();

    for (auto i = lines.begin(); i != lines.end(); i++)
    {
        cout << *i << endl;
    }
}
