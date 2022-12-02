# 5'. Задайте число. Составьте список чисел Фибоначчи, в том числе для отрицательных индексов.(Дополнительно)
# *Пример:*
# - для k = 8 список будет выглядеть так: [-21 ,13, -8, 5, −3, 2, −1, 1, 0, 1, 1, 2, 3, 5, 8, 13, 21] [Негафибоначчи]

a = int(input("Введите число: "))
result = [0, 1]
for i in range(2, a + 1):
    result.append(result[i - 1] + result[i - 2])

b = result.copy()
result.reverse()

for j in range(3, len(result) + 1):
    if j % 2 != 0:
        result[-j] = -result[-j]

for h in range(len(b)-2):
    result.append(b[h+2])
print(result)

