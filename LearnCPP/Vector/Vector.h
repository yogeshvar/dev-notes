#include <stddef.h>

template <typename T>
class Vector
{
public:
    Vector()
    {
        Realloc(2);
    }

    void PushBack(const T &value)
    {
        if (size == capacity)
        {
            Realloc(capacity + capacity / 2);
        }
        data[size] = value;
        size++;
    }

    size_t Size() const { return size; }

    const T &operator[](size_t index) const
    {
        return data[index];
    }

private:
    void
    Realloc(size_t newCapacity)
    {
        T *newBlock = new T[newCapacity];

        if (newCapacity < size)
            size = newCapacity;

        for (size_t i = 0; i < size; i++)
            newBlock[i] = data[i];

        delete[] data;
        data = newBlock;
        capacity = newCapacity;
    }

private:
    T *data = nullptr;
    size_t size = 0;
    size_t capacity = 0;
};