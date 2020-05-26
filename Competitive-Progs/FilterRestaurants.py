restaurants = [[1, 4, 1, 40, 10], [2, 8, 0, 50, 5], [3, 8, 1, 30, 4], [4, 10, 0, 10, 3], [5, 1, 1, 15, 1]]
veganFriendly = 1
maxPrice = 50
maxDistance = 10

hotels = []

for i in range(0, len(restaurants)):
    if veganFriendly is restaurants[i][2]:
        hotels.append(i)
        print 'vegan',i,restaurants[i]
    elif maxPrice < restaurants[i][3]:
        hotels.append(i)
        print 'price', i, restaurants[i]
    elif maxDistance < restaurants[i][4]:
        hotels.append(i)
        print 'distance',i, restaurants[i]


x = sorted(hotels, key=lambda x: x[1], reverse=True)
print x