# 2'. Задайте натуральное число N. Напишите программу, которая составит список простых множителей числа N.
# * 6 -> [1,2,3]
# * 144 -> [2,3]

num = int(input('Введите число: '))
result = {1}
divider = 2
while num > 2:
    if num % divider == 0:
        result.add(divider)
        num /= divider
        divider = 2
    else:
        divider += 1
print(result)
