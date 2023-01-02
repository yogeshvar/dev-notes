#include <iostream>

#define LOG(X) cout << x << endl;
using namespace std;

class Entity
{
public:
    float x, y;

    void move(float xa, float ya)
    {
        x += xa;
        y += ya;
    }
};

class Player : public Entity
{
public:
    const char *name;
    void printName()
    {
        cout << name << endl;
    }
};

int main()
{
    Player player1;

    player1.move(1, 1);

    string str = "Maggie";

    player1.name = &str[0];

    player1.printName();

    return 0;
}