#include <iostream>

using namespace std;

int num = 99;

class MyClass
{
public:
    MyClass()
    {
        cout << "This is the Constructor of MyClass" << endl;
    }
    void setName(string value)
    {
        name = value;
    }
    string getName()
    {
        return name;
    }
    ~MyClass()
    {
        cout << "This is the Deconstructor of MyClass" << endl;
    }

private:
    string name;

    friend void friendSetName(MyClass &myObject);
};

void friendSetName(MyClass &myObject)
{
    myObject.name = "Friends";
    cout << myObject.name << endl;
}

int main()
{
    int num = 11;
    MyClass myObject;
    friendSetName(myObject);
    myObject.setName("Maggie");
    cout << myObject.getName() << endl;
    cout << ::num << endl;
    return 0;
}