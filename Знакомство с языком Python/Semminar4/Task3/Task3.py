# 3'. Задайте последовательность чисел.
# Напишите программу, которая выведет список неповторяющихся элементов исходной последовательности.

a = [2, 17, 123, 123, 15, 1231, 1242, 17]
b = []
for elem in a:
    if a.count(elem) == 1:
        b.append(elem)
print(b)
