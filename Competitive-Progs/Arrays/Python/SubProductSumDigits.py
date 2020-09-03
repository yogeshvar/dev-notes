import math
n = 234

values = [int(d) for d in str(n)]
digits_product = math.prod(values)
digits_sum = sum(values)

print(digits_product - digits_sum)
